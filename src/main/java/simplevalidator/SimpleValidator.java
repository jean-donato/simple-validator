package simplevalidator;

import org.reflections.Reflections;
import simplevalidator.object.ObjectValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SimpleValidator {

    private Map<Object, String> fieldsToValidate = new HashMap<>();

    private List<Validator> validators = new ArrayList<>();

    private boolean errorFounded;

    public void build() throws InstantiationException, IllegalAccessException {
        loadValidators();

        for (Map.Entry<Object, String> entry : fieldsToValidate.entrySet()) {
            Object field = Objects.nonNull(entry.getKey()) ? entry.getKey() : null;

            Validator validatorFounded = validators.stream()
                    .filter(validator -> validator.isSameType(field))
                    .findFirst()
                    .orElse(new ObjectValidator());

            errorFounded = validatorFounded.validate(entry.getKey());

            if (errorFounded) {
                throw new IllegalArgumentException(entry.getValue());
            }
        }
    }

    private void loadValidators() throws InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("simplevalidator");
        Set<Class<? extends Validator>> subTypes = reflections.getSubTypesOf(Validator.class);
        for (Class<? extends Validator> validator : subTypes) {
            validators.add(validator.newInstance());
        }
    }

    public SimpleValidator validate(Object field, String message) {
        this.fieldsToValidate.put(field, message);
        return this;
    }
}

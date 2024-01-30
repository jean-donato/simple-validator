package simplevalidator.object;

import simplevalidator.Validator;

import java.util.Objects;

public class NullObjectValidator implements Validator {

    @Override
    public <T> boolean validate(T field) {
        return Objects.isNull(field);
    }

    @Override
    public <T> boolean isSameType(T field) {
        return Objects.isNull(field);
    }
}

package simplevalidator.string;

import simplevalidator.Validator;

public class EmptyStringValidator implements Validator {

    @Override
    public <T> boolean validate(T field) {
        String string = (String) field;
        return string.trim().isEmpty();
    }

    @Override
    public <T> boolean isSameType(T field) {
        return field instanceof String;
    }
}

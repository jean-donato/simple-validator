package simplevalidator.integer;

import simplevalidator.Validator;

import java.math.BigDecimal;

public class IntegerBiggerThanZeroValidator implements Validator {

    @Override
    public <T> boolean validate(T field) {
        Integer integer = (Integer) field;
        return integer <= 0;
    }

    @Override
    public <T> boolean isSameType(T field) {
        return field instanceof Integer;
    }
}

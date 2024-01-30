package simplevalidator.bigdecimal;

import simplevalidator.Validator;

import java.math.BigDecimal;

public class BigDecimalBiggerThanZeroValidator implements Validator {

    @Override
    public <T> boolean validate(T field) {
        BigDecimal bigDecimal = (BigDecimal) field;
        return bigDecimal.compareTo(BigDecimal.ZERO) <= 0;
    }

    @Override
    public <T> boolean isSameType(T field) {
        return field instanceof BigDecimal;
    }
}

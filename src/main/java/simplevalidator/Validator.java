package simplevalidator;

public interface Validator {
    <T> boolean validate(T field);

    <T> boolean isSameType(T field);
}

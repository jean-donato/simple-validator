package simplevalidator.collection;

import simplevalidator.Validator;

import java.util.Collection;
import java.util.Collections;

public class EmptyCollectionValidator implements Validator {
    @Override
    public <T> boolean validate(T field) {
        Collection collection = (Collection) field;
        return collection.isEmpty();
    }

    @Override
    public <T> boolean isSameType(T field) {
        return field instanceof Collection;
    }
}

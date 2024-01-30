package simplevalidator.validators.object;

import org.junit.jupiter.api.Test;
import simplevalidator.SimpleValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ObjectValidatorTest {

    @Test
    void shouldValidateNull() {
        Object nullObject = null;
        String expectedMessage = "The field client can not be null";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(nullObject, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldReturnNullExceptionWithGoodValue() {
        Object object = new Object();
        String expectedMessage = "The field client can not be null";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(object, expectedMessage).build();
        });

        assertThat(exception).isNull();
    }
}

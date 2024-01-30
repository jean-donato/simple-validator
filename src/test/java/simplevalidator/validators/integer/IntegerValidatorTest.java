package simplevalidator.validators.integer;

import org.junit.jupiter.api.Test;
import simplevalidator.SimpleValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class IntegerValidatorTest {

    @Test
    void shouldValidateBiggerThanZero() {
        Integer zeroValue = 0;
        String expectedMessage = "The field value of car have to be bigger than zero";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(zeroValue, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldValidateLessThanZero() {
        Integer oneNegate = -1;
        String expectedMessage = "The field value of car have to be bigger than zero";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(oneNegate, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldReturnNullExceptionWithGoodValue() {
        Integer integer = 10;
        String expectedMessage = "The field value of car have to be bigger than zero";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(integer, expectedMessage).build();
        });

        assertThat(exception).isNull();
    }
}

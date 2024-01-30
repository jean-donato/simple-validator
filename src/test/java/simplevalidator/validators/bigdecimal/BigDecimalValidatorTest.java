package simplevalidator.validators.bigdecimal;

import org.junit.jupiter.api.Test;
import simplevalidator.SimpleValidator;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BigDecimalValidatorTest {

    @Test
    void shouldValidateBiggerThanZero() {
        BigDecimal zeroValue = BigDecimal.ZERO;
        String expectedMessage = "The field value of car have to be bigger than zero";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(zeroValue, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldValidateLessThanZero() {
        BigDecimal oneNegate = BigDecimal.ONE.negate();
        String expectedMessage = "The field value of car have to be bigger than zero";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(oneNegate, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldReturnNullExceptionWithGoodValue() {
        BigDecimal bigDecimal = BigDecimal.TEN;
        String expectedMessage = "The field value of car have to be bigger than zero";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(bigDecimal, expectedMessage).build();
        });

        assertThat(exception).isNull();
    }

}

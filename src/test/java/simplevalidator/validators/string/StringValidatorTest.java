package simplevalidator.validators.string;

import org.junit.jupiter.api.Test;
import simplevalidator.SimpleValidator;
import simplevalidator.SimpleValidatorTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringValidatorTest {

    @Test
    void shouldValidateEmpty() {
        String emptyString = "";
        String expectedMessage = "The field name can not be empty";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(emptyString, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldValidateWhiteSpace() {
        String emptyString = "   ";
        String expectedMessage = "The field name can not be empty";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(emptyString, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldReturnNullExceptionWithGoodValue() {
        String string = "name";
        String expectedMessage = "The field name can not be empty";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(string, expectedMessage).build();
        });

        assertThat(exception).isNull();
    }

}

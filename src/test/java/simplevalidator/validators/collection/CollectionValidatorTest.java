package simplevalidator.validators.collection;

import org.junit.jupiter.api.Test;
import simplevalidator.SimpleValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CollectionValidatorTest {

    @Test
    void shouldValidateNull() {
        List<String> nullList = null;
        String expectedMessage = "The list of car can not be null neither empty";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(nullList, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldValidateEmpty() {
        List<String> emptyList = new ArrayList<>();
        String expectedMessage = "The list of car can not be null neither empty";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(emptyList, expectedMessage).build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void shouldReturnNullExceptionWithGoodValue() {
        List<String> list = Arrays.asList("String");
        String expectedMessage = "The list of car can not be null neither empty";

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator().validate(list, expectedMessage).build();
        });

        assertThat(exception).isNull();
    }

}

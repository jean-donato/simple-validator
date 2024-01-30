package simplevalidator;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SimpleValidatorTest {

    @ParameterizedTest
    @MethodSource("getInvalidParameters")
    void shouldValidateDifferentFields(BigDecimal bigDecimal, String string, Object object, String expectedMessage) {

        Throwable exception = catchThrowable(() -> {
            new SimpleValidator()
                    .validate(bigDecimal, expectedMessage)
                    .validate(string, expectedMessage)
                    .validate(object, expectedMessage)
                    .build();
        });

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> getInvalidParameters() {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal someBigDecimal = BigDecimal.TEN;
        String emptyString = "";
        Object object = new Object();
        String string = "Some String";

        return Stream.of(
                Arguments.of(zero, string, object, "The field value of car can not be zero."),
                Arguments.of(someBigDecimal, emptyString, object, "The field name can not be empty."),
                Arguments.of(someBigDecimal, string, null, "The field object can not be null.")
        );
    }
}

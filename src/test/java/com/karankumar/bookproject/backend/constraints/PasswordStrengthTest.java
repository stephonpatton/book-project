package com.karankumar.bookproject.backend.constraints;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayName("PasswordStrength should")
class PasswordStrengthTest {
    @Test
    void notAllowOutOfBoundValues() {
        // given
        int belowArrayLowerBound = -1;
        int aboveArrayUpperBound = PasswordStrength.values().length;

        // when
        Throwable thrown1 = catchThrowable(() -> PasswordStrength.byNum(belowArrayLowerBound));
        Throwable thrown2 = catchThrowable(() -> PasswordStrength.byNum(aboveArrayUpperBound));

        // then
        assertSoftly(softly -> {
            softly.assertThat(thrown1).isInstanceOf(IllegalArgumentException.class);
            softly.assertThat(thrown2).isInstanceOf(IllegalArgumentException.class);
        });
    }
}

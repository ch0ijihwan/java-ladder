package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightTest {

    @ParameterizedTest
    @DisplayName("사다리 높이는 양수어야 한다.")
    @ValueSource(ints = {0, -1})
    void validateRange(final int input) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(input))
                .withMessage("사다리의 높이는 양수어야 합니다.");
    }

    @Test
    @DisplayName("사다리 높이를 반환한다.")
    void getValue() {
        //given
        int input = 3;
        LadderHeight ladderHeight = new LadderHeight(input);

        //when
        int actual = ladderHeight.getValue();

        //then
        assertThat(actual).isEqualTo(input);
    }
}
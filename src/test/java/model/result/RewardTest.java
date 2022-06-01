package model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RewardTest {

    @Test
    @DisplayName("값을 반환한다.")
    void getValue() {
        //given
        String input = "5000";
        Reward reward = new Reward(input);

        //when
        String actual = reward.getValue();

        //then
        assertThat(actual).isEqualTo(input);
    }

    @Test
    @DisplayName("상금은 공백일 수 없으며 5자리를 초과하면 안된다.")
    void validateSize() {
        //given
        String input = "123456";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Reward(input))
                .withMessage("상금은 공백일 수 없으며 5자리를 초과해서는 안됩니다.");
    }
}

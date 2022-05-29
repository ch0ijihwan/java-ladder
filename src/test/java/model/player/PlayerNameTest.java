package model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNameTest {

    @Test
    @DisplayName("이름을 입력받고, 이름이 5자 초과인 경우 예외처리를 한다.")
    void validatePlayerNameSize() {
        //given
        String input = "spring";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayerName(input))
                .withMessage("플레이어의 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void getName() {
        //given
        String input = "apple";
        PlayerName playerName = new PlayerName(input);
        String expect = "apple";

        //when
        String actual = playerName.getName();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
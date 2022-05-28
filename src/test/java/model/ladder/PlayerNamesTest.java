package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNamesTest {

    @Test
    @DisplayName("플레이어들의 이름을 반환한다.")
    void getNames() {
        //given
        List<String> input = List.of("apple", "hello", "watch");
        PlayerNames playerNames = new PlayerNames(input);

        //when
        List<String> actual = playerNames.getNames();

        //then
        assertThat(actual).isEqualTo(input);
    }

    @Test
    @DisplayName("플레이어들의 인원 수를 반환한다.")
    void countPlayers() {
        //given
        List<String> input = List.of("apple", "hello", "watch");
        PlayerNames playerNames = new PlayerNames(input);
        int expect = 3;

        //when
        int actual = playerNames.countPlayers();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("사다리타기 게임을 하려면 플레이어 수는 최소 2명이어야 합니다.")
    void validateCountOfPlayer() {
        //given
        List<String> input = List.of("apple");

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayerNames(input))
                .withMessage("사다리타기 게임을 하려면 플레이어 수는 쵯고 2명이어야 합니다.");
    }

    @Test
    @DisplayName("플레이어중 중복된 이름이 있는 플레이어가 있으면 예외처리한다.")
    void validateDuplication() {
        //given
        List<String> input = List.of("apple", "apple");

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayerNames(input))
                .withMessage("중복된 이름을 가지고 있는 플레이어가 있습니다.");
    }
}
package model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @Test
    @DisplayName("플레이어들의 이름을 반환한다.")
    void getNames() {
        //given
        List<String> input = List.of("apple", "hello", "watch");
        Players players = new Players(input);

        //when
        List<String> actual = players.getNames();

        //then
        assertThat(actual).isEqualTo(input);
    }

    @Test
    @DisplayName("플레이어들의 인원 수를 반환한다.")
    void countPlayers() {
        //given
        List<String> input = List.of("apple", "hello", "watch");
        Players players = new Players(input);
        int expect = 3;

        //when
        int actual = players.countPlayers();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("사다리타기 게임을 하려면 플레이어 수는 최소 2명이어야 합니다.")
    void validateCountOfPlayer() {
        //given
        List<String> input = List.of("apple");

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Players(input))
                .withMessage("사다리타기 게임을 하려면 플레이어 수는 쵯고 2명이어야 합니다.");
    }

    @Test
    @DisplayName("플레이어중 중복된 이름이 있는 플레이어가 있으면 예외처리한다.")
    void validateDuplication() {
        //given
        List<String> input = List.of("apple", "apple");

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Players(input))
                .withMessage("중복된 이름을 가지고 있는 플레이어가 있습니다.");
    }

    @Test
    @DisplayName("해당 인덱스에 있는 플레이어의 이름을 반환한다.")
    void get() {
        //given
        List<String> inputNames = List.of("apple", "hello", "hi");
        int input = 2;
        Players players = new Players(inputNames);
        String expect = "hi";

        //when
        String actual = players.get(input);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}

package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
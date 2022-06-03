package model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RewardsTest {

    @Test
    @DisplayName("상금들의 갯수는 게임에 참여하는 플레이어의 수와 같아야 한다.")
    void validateSize() {
        //given
        int countOfPlayers = 3;
        List<String> inputRewards = List.of("1000", "2000,", "꽝", "3000");

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Rewards(countOfPlayers, inputRewards))
                .withMessage("상금들의 갯수는 게임에 참여하는 플레이어의 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("모든 상금들을 반환한다.")
    void getRewards() {
        //given
        int countOfPlayers = 4;
        List<String> inputRewards = List.of("1000", "2000,", "꽝", "3000");
        Rewards rewards = new Rewards(countOfPlayers, inputRewards);

        //when
        List<String> actual = rewards.getRewards();

        //then
        assertThat(actual).hasSize(countOfPlayers);

    }

    @Test
    @DisplayName("입력 받은 인덱스 위치에 있는 상금을 반환한다.")
    void get() {
        //given
        int countOfPlayers = 4;
        List<String> inputRewards = List.of("1000", "2000,", "꽝", "3000");
        Rewards rewards = new Rewards(countOfPlayers, inputRewards);
        int input = 0;
        String expect = "1000";

        //when
        String actual = rewards.get(input);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
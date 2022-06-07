package model.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LadderGameResultTest {

    private final Map<String, String> result = new HashMap<>();
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        result.put("a", "1000");
        result.put("b", "2000");
        result.put("c", "3000");
        ladderGameResult = new LadderGameResult(result);
    }

    @Test
    @DisplayName("해당 플레이어의 게임 결과를 반환한다.")
    void getResult() {
        //given
        String input = "a";
        String expect = "1000";

        //when
        String actual = ladderGameResult.getResult(input);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("all 키워드가 입력 되면 전체 게임 결과를 반환한다.")
    void getAllResult() {
        //when
        Set<Map.Entry<String, String>> actual = ladderGameResult.getAllResult();

        //then
        assertThat(actual).isEqualTo(result.entrySet());

    }

    @Test
    @DisplayName("볼 수 있는 총 게임 결과 사이즈를 반환한다.")
    void getSize() {
        //given
        int expect = 3;

        //when
        int actual = ladderGameResult.getSize();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("해당 이름을 갖고 있으면 true 를 반환한다.")
    void containName() {
        //given
        String input = "a";

        //when
        boolean actual = ladderGameResult.containName(input);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("입력받은 플레이어의 이름이 없으면 예외처리를 한다.")
    void validateContainedName() {
        //given
        String input = "kong";


        //then
        assertThatIllegalArgumentException().isThrownBy(() -> ladderGameResult.containName(input))
                .withMessage("존재하지 않는 플레이어의 이름을 입력하였습니다.");
    }
}
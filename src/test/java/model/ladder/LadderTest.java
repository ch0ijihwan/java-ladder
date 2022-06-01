package model.ladder;

import model.player.Players;
import model.result.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Line> input = List.of(
                new Line(List.of(
                        new Point(0, new Link(false, true)),
                        new Point(1, new Link(true, false)),
                        new Point(2, new Link(false, true)),
                        new Point(3, new Link(true, false)))
                ),
                new Line(List.of(
                        new Point(0, new Link(false, false)),
                        new Point(1, new Link(false, true)),
                        new Point(2, new Link(true, false)),
                        new Point(3, new Link(false, false)))
                )
        );
        ladder = new Ladder(input);
    }

    @Test
    @DisplayName("현재 갖고 있는 Line 들을 리스트 형태로 반환한다.")
    void getLines() {
        List<Line> expect = List.of(
                new Line(List.of(
                        new Point(0, new Link(false, true)),
                        new Point(1, new Link(true, false)),
                        new Point(2, new Link(false, true)),
                        new Point(3, new Link(true, false)))
                ),
                new Line(List.of(
                        new Point(0, new Link(false, false)),
                        new Point(1, new Link(false, true)),
                        new Point(2, new Link(true, false)),
                        new Point(3, new Link(false, false)))
                )
        );

        //when
        List<Line> actual = ladder.getLines();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("라인들의 연결 상태를 반환한다.")
    void getAllLineLinkStatus() {
        //given
        List<List<Boolean>> expect = List.of(
                List.of(true, false, true),
                List.of(false, true, false)
        );

        //when
        List<List<Boolean>> actual = ladder.getRightLinkStatusOfAllLine();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("플레이어의 이름들과 상금들을 받아 사다리 타기를 실행 한 결과를 반환한다.")
    void match() {
        //given
        Players players = new Players(List.of("a", "b", "c", "d"));
        Rewards rewards = new Rewards(4, List.of("1000", "2000", "3000", "꽝"));

        //when
        Map<String, String> actual = ladder.match(players, rewards);

        //then
        assertAll(
                () -> assertThat(actual).containsEntry("a", "3000"),
                () -> assertThat(actual).containsEntry("b", "1000"),
                () -> assertThat(actual).containsEntry("c", "꽝"),
                () -> assertThat(actual).containsEntry("d", "2000")
        );
    }
}
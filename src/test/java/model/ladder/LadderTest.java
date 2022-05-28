package model.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("라인들의 사이즈를 반환한다.")
    void getSize() {
        //given
        int expect = 2;

        //when
        int actual = ladder.getSize();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
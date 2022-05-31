package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("points 를 반환한다.")
    void getPoints() {
        List<Point> input = List.of(
                new Point(0, new Link(false, false)),
                new Point(1, new Link(true, false)),
                new Point(2, new Link(false, false)));
        Line line = new Line(input);


        //when
        List<Point> actual = line.getPoints();

        //then
        assertThat(actual).isEqualTo(input);
    }

    @Test
    @DisplayName("Line 내의 좌표들의 연결 상태를 반환한다.")
    void getPointsLinkStatus() {
        //given
        List<Point> input = List.of(
                new Point(0, new Link(false, true)),
                new Point(1, new Link(true, false)),
                new Point(2, new Link(false, false)));
        Line line = new Line(input);
        List<Boolean> expect = List.of(true, false);

        //when
        List<Boolean> actual = line.getLinkStatusOfAllPoint();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("해당 좌표의 움직인 후의 인덱스를 반환한다.")
    void move() {
        //given
        List<Point> input = List.of(
                new Point(0, new Link(false, true)),
                new Point(1, new Link(false, true)),
                new Point(2, new Link(false, false)));
        Line line = new Line(input);
        int pointIndex = 0;
        int expect = 1;

        //when
        int move = line.move(pointIndex);

        //then
        assertThat(move).isEqualTo(expect);
    }
}
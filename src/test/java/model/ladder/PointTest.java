package model.ladder;

import model.randomlinkstrategy.LinkStrategy;
import model.randomlinkstrategy.RandomLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    static class testLinkStrategy implements LinkStrategy {

        @Override
        public boolean generateLinkable() {
            return true;
        }

        @Override
        public Link generateFirstPositionLink() {
            return new Link(false, generateLinkable());
        }

        @Override
        public Link generateLastPositionLink() {
            return new Link(generateLinkable(), false);
        }
    }

    private final LinkStrategy linkStrategy = new RandomLinkStrategy();

    @ParameterizedTest
    @MethodSource("createLinkParameterProvider")
    @DisplayName("Point 가 갖고 있는 연결 만큼 이동한 후  index 를 반환한다.")
    void move(final Link link, final int expectMovement) {
        //given
        int index = 3;
        Point point = new Point(index, link);
        int expectIndex = expectMovement + index;

        //when
        int actual = point.move();

        //then
        assertThat(actual).isEqualTo(expectIndex);
    }

    static Stream<Arguments> createLinkParameterProvider() {
        return Stream.of(
                Arguments.of(new Link(true, false), -1),
                Arguments.of(new Link(false, true), 1),
                Arguments.of(new Link(false, false), 0)
        );
    }

    @Test
    @DisplayName("다음 Point 를 생성해서 반환한다.")
    void nextPoint() {
        //given
        Point point = new Point(0, new Link(false, false));
        int expectIndex = 1;

        //when
        Point actual = point.nextPoint(linkStrategy);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("index", expectIndex);
    }

    @Test
    @DisplayName("오른쪽 Link 상태를 반환")
    void hasRightLink() {
        //given
        Link input = new Link(true, false);
        Point point = new Point(0, input);

        //when
        boolean actual = point.hasRightLink();

        //then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("첫번째 좌표 생성")
    void createFirstPoint() {
        //given
        Link expect = new Link(false, true);

        //when
        Point actual = Point.createFirst(new testLinkStrategy());

        //then
        assertThat(actual).extracting("link")
                .isEqualTo(expect);
    }

    @Test
    @DisplayName("마지막 좌표 생성")
    void createLastPoint() {
        //given
        int countOfPlayer = 4;
        int lastIndex = 3;

        //when
        Point actual = Point.createLast(countOfPlayer, linkStrategy);

        //then
        assertThat(actual.hasRightLink()).isFalse();
        assertThat(actual).hasFieldOrPropertyWithValue("index", lastIndex);
    }
}
package model.ladder;

import model.randomlinkstrategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinkTest {

    static class alwaysLinkableStrategy implements LinkStrategy {

        @Override
        public boolean generateLinkable() {
            return true;
        }

        @Override
        public Link generateFirstPositionLink() {
            return new Link(false, generateLinkable());
        }

        @Override
        public Link generateLastPositionLink(final Link preLink) {
            return new Link(preLink.getRight(), false);
        }
    }

    private final LinkStrategy testLinkableStrategy = new alwaysLinkableStrategy();

    @Test
    @DisplayName("양쪽다 true 일 경우 예외처리 반환")
    void validateLinkOverLap() {
        //given
        boolean inputLeft = true;
        boolean inputRight = true;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Link(inputLeft, inputRight))
                .withMessage("연결 선이 겹칩니다.");
    }

    @Test
    @DisplayName("첫번째 위치의 Link 의 왼쪽은 false 이여야한다.")
    void getFirstPositionLink() {

        //when
        Link actual = Link.generateFirstPositionLink(testLinkableStrategy);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("left", false);
    }

    @CsvSource(value = {"true", "false"})
    @DisplayName("마지막 위치의 Link 의 오른쪽은 false 이어야한다.")
    void getLastPositionLink(boolean rightOfPreLink) {
        //given
        Link preLink = new Link(false, rightOfPreLink);

        //when
        Link actual = Link.generateLastPositionLink(preLink, testLinkableStrategy);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("right", false);
    }

    @ParameterizedTest
    @MethodSource("createLinkAndNextLinkParameterProvider")
    @DisplayName("기존의 Link 객체를 기반으로 다음 순서에 올 Link 객체를 반환한다.")
    void nextLink(final Link link, final Link expect) {
        //when
        Link actual = link.generateNextLink(testLinkableStrategy);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> createLinkAndNextLinkParameterProvider() {
        return Stream.of(
                Arguments.of(new Link(true, false), new Link(false, true)),
                Arguments.of(new Link(false, true), new Link((true), false))
        );
    }

    @ParameterizedTest
    @DisplayName("오른쪽 연결 상태를 반환한다.")
    @MethodSource("createRightParameterProvider")
    void getRight(final Link link, final boolean expect) {
        //when
        boolean actual = link.getRight();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> createRightParameterProvider() {
        return Stream.of(
                Arguments.of(new Link(true, false), false),
                Arguments.of(new Link(false, true), true)
        );
    }

    @ParameterizedTest
    @MethodSource("createLinkParameterProvider")
    @DisplayName("해당하는 연결에 따라서, 이동 할 수 있는 정도를 반환한다.")
    void move(final boolean left, final boolean right, final int expect) {

        //given
        Link link = new Link(left, right);

        //when
        int actual = link.move();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> createLinkParameterProvider() {
        return Stream.of(
                Arguments.of(true, false, -1),
                Arguments.of(false, true, 1),
                Arguments.of(false, false, 0)
        );
    }
}
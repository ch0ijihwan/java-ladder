package model.ramdomlinkable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private final RandomLinkable randomLinkable = new RandomLinkable();

    @Test
    @DisplayName("양쪽다 true 일 경우 예외처리 반환")
    void validateLinkOverLap () {
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
        Link actual = Link.getFirstPositionLink(randomLinkable);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("left", false);
    }

    @Test
    @DisplayName("마지막 위치의 Link 의 오른쪽은 false 이어야한다.")
    void getLastPositionLink() {
        //when
        Link actual = Link.getLastPositionLink(randomLinkable);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("right", false);
    }

    @ParameterizedTest
    @MethodSource("createLinkParameterProvider")
    @DisplayName("해당하는 연결에 따라서, 움직임 정도를 반환한다.")
    void move(final boolean left, final boolean right, final int expect) {

        //given
        Link link = new Link(left, right);

        //when
        int actual = link.move();
        
        //then
        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> createLinkParameterProvider() {
        return Stream.of(
                Arguments.of(true, false, -1),
                Arguments.of(false, true, 1),
                Arguments.of(false, false, 0)
        );
    }
}
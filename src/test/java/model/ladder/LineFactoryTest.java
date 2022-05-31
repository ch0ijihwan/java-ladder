package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineFactoryTest {

    @Test
    @DisplayName("입력 받은 사이즈에 해당하는 라인 객체를 생성한다.")
    void createLineWith() {
        //given
        int inputSize = 5;
        int expect = 5;

        //when
        Line line = LineFactory.createLineWith(inputSize);

        //then
        assertThat(line.getPoints()).hasSize(expect);
    }

    @Test
    @DisplayName("라인 중 연결이 연속으로 이어져있으면 안된다. [true 가 2개 이상 연결 되어 있으면 안된다.]")
    void validateLinkOverlap() {
        //given
        int inputSize = 1000;
        Line line = LineFactory.createLineWith(inputSize);
        List<Boolean> linkStatusOfAllPoint = line.getLinkStatusOfAllPoint();
        String expect = "true,true";

        //when
        String combinedLinkStatus = linkStatusOfAllPoint.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        //then
        assertThat(combinedLinkStatus)
                .doesNotContain(expect);
    }
}
package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
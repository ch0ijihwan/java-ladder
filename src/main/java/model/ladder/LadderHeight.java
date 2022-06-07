package model.ladder;

import java.util.Objects;

public class LadderHeight {

    private static final int MINIMUM_VALUE_OF_LADDER_HEIGHT = 1;
    private final int value;

    public LadderHeight(final int ladderHeight) {
        validateRange(ladderHeight);
        this.value = ladderHeight;
    }

    private void validateRange(final int ladderHeight) {
        if (ladderHeight < MINIMUM_VALUE_OF_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 양수어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

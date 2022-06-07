package model.result;

import java.util.Objects;

public class Reward {

    private static final int MAXIMUM_SIZE_OF_REWARD = 5;

    private final String value;

    public Reward(final String value) {
        validateSize(value);
        this.value = value;
    }

    private void validateSize(final String value) {
        if (value.length() > MAXIMUM_SIZE_OF_REWARD || value.isEmpty()) {
            throw new IllegalArgumentException("상금은 공백일 수 없으며 5자리를 초과해서는 안됩니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(value, reward.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

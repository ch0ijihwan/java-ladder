package model.playername;

import java.util.Objects;

public class PlayerName {

    private static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    public PlayerName(final String name) {
        validatePlayerNameSize(name);
        this.name = name;
    }

    private void validatePlayerNameSize(final String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("플레이어의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
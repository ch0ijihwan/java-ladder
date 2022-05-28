package model.playername;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerNames {

    private static final int MINIMUM_VALUE_OF_PLAYER_COUNT = 2;

    private final List<PlayerName> playerNames;

    public PlayerNames(final List<String> names) {
        validateCountOfPlayer(names);
        validateDuplication(names);
        this.playerNames = names.stream()
                .map(PlayerName::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateCountOfPlayer(final List<String> names) {
        if (names.size() < MINIMUM_VALUE_OF_PLAYER_COUNT) {
            throw new IllegalArgumentException("사다리타기 게임을 하려면 플레이어 수는 쵯고 2명이어야 합니다.");
        }
    }

    private void validateDuplication(final List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("중복된 이름을 가지고 있는 플레이어가 있습니다.");
        }
    }

    public List<String> getNames() {
        return playerNames.stream()
                .map(PlayerName::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int countPlayers() {
        return playerNames.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerNames that = (PlayerNames) o;
        return Objects.equals(playerNames, that.playerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNames);
    }
}

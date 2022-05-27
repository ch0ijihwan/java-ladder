package model.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerNames {

    private final List<PlayerName> playerNames;

    public PlayerNames(final List<String> names) {
        this.playerNames = names.stream()
                .map(PlayerName::new)
                .collect(Collectors.toUnmodifiableList());
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

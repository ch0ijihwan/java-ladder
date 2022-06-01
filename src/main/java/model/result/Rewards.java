package model.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(final int countOfPlayers, final List<String> inputRewards) {
        validateSize(countOfPlayers, inputRewards);
        this.rewards = createRewards(inputRewards);
    }

    private void validateSize(final int countOfPlayers, final List<String> inputRewards) {
        if (countOfPlayers != inputRewards.size()) {
            throw new IllegalArgumentException("상금들의 갯수는 게임에 참여하는 플레이어의 수와 같아야 합니다.");
        }
    }

    private List<Reward> createRewards(final List<String> inputRewards) {
        return inputRewards.stream()
                .map(Reward::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public String get(final int input) {
        return rewards.get(input)
                .getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

    public List<Reward> getRewards() {
        return new ArrayList<>(rewards);
    }
}

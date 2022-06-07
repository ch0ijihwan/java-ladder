package model.ladder;

import model.player.Players;
import model.result.Rewards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines(){
        return new ArrayList<>(lines);
    }

    public List<List<Boolean>> getRightLinkStatusOfAllLine() {
        return lines.stream()
                .map(Line::getLinkStatusOfAllPoint)
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<String, String> match(final Players players, final Rewards rewards) {
        Map<String, String> result = new HashMap<>();
        IntStream.range(0, players.countPlayers())
                .forEach(index -> result.put(players.get(index), rewards.get(findLastBottomIndex(index))));
        return result;
    }

    private int findLastBottomIndex(final int pointIndex) {
        int currentIndex = pointIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }
}

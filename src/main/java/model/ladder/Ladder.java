package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public List<List<Boolean>> getRightLinkStatusOfAllLine() {
        return lines.stream()
                .map(Line::getLinkStatusOfAllPoint)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getSize() {
        return lines.size();
    }
}

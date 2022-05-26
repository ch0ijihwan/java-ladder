package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public List<List<Boolean>> getAllLineLinkStatus() {
        return lines.stream()
                .map(Line::getPointsLinkStatus)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getSize() {
        return lines.size();
    }
}

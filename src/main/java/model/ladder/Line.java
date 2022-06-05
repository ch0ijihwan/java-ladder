package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public int move(final int pointIndex) {
        return this.points
                .get(pointIndex)
                .move();
    }

    public List<Boolean> getLinkStatusOfAllPoint() {
        int ladderWidth = points.size() - 1;
        return points.stream()
                .map(Point::hasRightLinkable)
                .limit(ladderWidth)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

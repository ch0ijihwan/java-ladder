package model.ladder;

import model.randomlinkstrategy.LinkStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private static final int SIZE_OF_FIRST_AND_LAST = 2;

    private final List<Point> points;

    public Line(final int countOfPlayer, final LinkStrategy linkStrategy) {
        Point firstPoint = Point.createFirst(linkStrategy);
        List<Point> middlePoints = createMiddlePoints(countOfPlayer, linkStrategy, firstPoint);
        Point lastPoint = Point.createLast(countOfPlayer, linkStrategy);
        this.points = combine(firstPoint, middlePoints, lastPoint);
    }

    private List<Point> createMiddlePoints(final int countOfPlayer, final LinkStrategy linkStrategy, final Point firstPoint) {
        int middleWidth = countOfPlayer - SIZE_OF_FIRST_AND_LAST;
        return Stream.generate(() -> firstPoint.nextPoint(linkStrategy))
                .limit(middleWidth)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Point> combine(final Point firstPoint, final List<Point> middlePoints, final Point lastPoint) {
        List<Point> points = new ArrayList<>();
        points.add(firstPoint);
        points.addAll(middlePoints);
        points.add(lastPoint);
        return points;
    }

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
                .map(Point::hasRightLink)
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

package model.ladder;

import model.randomlinkstrategy.LinkStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Point> points;

    Line(final int countOfPlayer, final LinkStrategy linkStrategy) {
        Point firstPoint = Point.createFirst(linkStrategy);
        List<Point> middlePoints = createMiddlePoints(countOfPlayer, linkStrategy, firstPoint);
        Point lastPoint = Point.createLast(countOfPlayer, linkStrategy);
        this.points = combine(firstPoint, middlePoints, lastPoint);
    }

    private List<Point> createMiddlePoints(final int countOfPlayer, final LinkStrategy linkStrategy, final Point firstPoint) {
        return Stream.generate(() -> firstPoint.nextPoint(linkStrategy))
                .limit(countOfPlayer - 2)
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
        return this.points.get(pointIndex).move();
    }

    public List<Boolean> getPointsLinkStatus(){
        int ladderWidth = points.size() - 1;
        return points.stream()
                .map(Point::hasRightLink)
                .limit(ladderWidth)
                .collect(Collectors.toUnmodifiableList());
    }
}

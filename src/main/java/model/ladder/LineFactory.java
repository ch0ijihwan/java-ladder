package model.ladder;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private static final int SIZE_OF_FIRST_AND_LAST = 2;

    public static Line createLineWith(final int countOfPlayer) {
        return new Line(createPoints(countOfPlayer));
    }

    private static List<Point> createPoints(final int countOfPlayer) {
        Point firstPoint = Point.createFirst();
        List<Point> middlePoints = createMiddlePoint(countOfPlayer, firstPoint);
        Point lastPointOfMiddlePoints = middlePoints.get(middlePoints.size() - 1);
        Point lastPoint = Point.createLast(lastPointOfMiddlePoints);
        List<Point> firstAndMiddlePoints = combine(List.of(firstPoint), middlePoints);
        return combine(firstAndMiddlePoints, List.of(lastPoint));
    }

    private static List<Point> createMiddlePoint(final int countOfPlayer, final Point firstPoint) {
        int middleWidth = countOfPlayer - SIZE_OF_FIRST_AND_LAST;
        Point prePoint = firstPoint;
        List<Point> middlePoints = new ArrayList<>();
        for (int i = 0; i < middleWidth; i++) {
            prePoint = prePoint.nextPoint();
            middlePoints.add(prePoint);
        }
        return middlePoints;
    }

    private static List<Point> combine(final List<Point> points, final List<Point> points2) {
        List<Point> joinedPoints = new ArrayList<>();
        joinedPoints.addAll(points);
        joinedPoints.addAll(points2);
        return joinedPoints;
    }

    private LineFactory() {
    }
}

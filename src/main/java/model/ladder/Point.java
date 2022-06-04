package model.ladder;

import model.randomlinkstrategy.LinkStrategy;

import java.util.Objects;

public class Point {

    private static final int FIRST_INDEX = 0;
    private static final int NEXT_INCREMENT_OF_INDEX = 1;

    private final int index;
    private final Link link;

    public Point(final int index, final Link link) {
        this.index = index;
        this.link = link;
    }

    public static Point createFirst(final LinkStrategy linkStrategy) {
        return new Point(FIRST_INDEX, Link.generateFirstPositionLink(linkStrategy));
    }

    public static Point createLast(final Point prePoint) {
        int lastIndex = prePoint.index + NEXT_INCREMENT_OF_INDEX;
        return new Point(lastIndex, Link.generateLastPositionLink(prePoint.link));
    }

    public Point nextPoint(final LinkStrategy linkStrategy) {
        return new Point(index + NEXT_INCREMENT_OF_INDEX, link.generateNextLink(linkStrategy));
    }

    public boolean hasRightLink() {
        return link.getRight();
    }

    public int move() {
        return index + link.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(link, point.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, link);
    }
}

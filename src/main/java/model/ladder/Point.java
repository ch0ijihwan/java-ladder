package model.ladder;

import model.randomlinkstrategy.LinkStrategy;

import java.util.Objects;

public class Point {

    private final int index;
    private final Link link;


    public Point(final int index, final Link link) {
        this.index = index;
        this.link = link;
    }

    public static Point createFirst(final LinkStrategy linkStrategy) {
        return new Point(0, linkStrategy.generateFirstPositionLink());
    }

    public static Point createLast(final int countOfPlayer, final LinkStrategy linkStrategy) {
        return new Point(countOfPlayer - 1, linkStrategy.generateLastPositionLink());
    }

    public Point nextPoint(final LinkStrategy linkStrategy) {
        return new Point(index + 1, link.nextLink(linkStrategy));
    }

    public boolean hasRightLink() {
        return link.getRight();
    }

    public boolean hasLeftLink() {
        return link.getLeft();
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

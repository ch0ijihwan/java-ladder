package model.ladder;

import model.randomlinkstrategy.LinkStrategy;

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
        return new Point(index + 1, new Link(link.getRight(), linkStrategy.generateLinkable()));
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
}

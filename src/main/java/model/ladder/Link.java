package model.ladder;

import model.randomlinkstrategy.LinkStrategy;

import java.util.Objects;

public class Link {

    private final boolean left;
    private final boolean right;

    public Link(final boolean left, final boolean right) {
        validateLinkOverlap(left, right);

        this.left = left;
        this.right = right;
    }

    private void validateLinkOverlap(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("연결 선이 겹칩니다.");
        }
    }

    public static Link getFirstPositionLink(final LinkStrategy linkStrategy) {
        return linkStrategy.generateFirstPositionLink();
    }

    public static Link getLastPositionLink(final LinkStrategy linkStrategy) {
        return linkStrategy.generateLastPositionLink();
    }

    public int move() {
        if (left && !right) {
            return -1;
        }
        if (!left && right) {
            return 1;
        }
        return 0;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getRight() {
        return right;
    }

    public Link nextLink(final LinkStrategy linkStrategy) {
        boolean leftOfNextLink = this.getRight();
        if (leftOfNextLink) {
            return new Link(true, false);
        }
        return new Link(false, linkStrategy.generateLinkable());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return left == link.left && right == link.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

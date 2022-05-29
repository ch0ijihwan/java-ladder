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

    public static Link generateFirstPositionLink(final LinkStrategy linkStrategy) {
        return linkStrategy.generateFirstPositionLink();
    }

    public static Link generateLastPositionLink(final LinkStrategy linkStrategy) {
        return linkStrategy.generateLastPositionLink();
    }

    public boolean getRight() {
        return right;
    }

    public Link generateNextLink(final LinkStrategy linkStrategy) {
        boolean leftOfNextLink = this.getRight();
        if (leftOfNextLink) {
            return new Link(true, false);
        }
        return new Link(false, linkStrategy.generateLinkable());
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

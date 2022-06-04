package model.ladder;

import model.linkablestrategy.LinkableStrategy;

import java.util.Objects;

public class Link {

    private static final int INCREMENT = 1;
    private static final int DECREMENT = -1;
    private static final int STAY = 0;

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

    public static Link generateFirstPositionLink(final LinkableStrategy linkStrategy) {
        return new Link(false, linkStrategy.generateLinkable());
    }

    public static Link generateLastPositionLink(final Link preLink){
        return new Link(preLink.getRight(), false);
    }

    public boolean getRight() {
        return right;
    }

    public Link generateNextLink(final LinkableStrategy linkStrategy) {
        boolean leftOfNextLink = this.getRight();
        if (leftOfNextLink) {
            return new Link(true, false);
        }
        return new Link(false, linkStrategy.generateLinkable());
    }

    public int move() {
        if (left && !right) {
            return DECREMENT;
        }
        if (!left && right) {
            return INCREMENT;
        }
        return STAY;
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

package model.ramdomlinkable;

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
}

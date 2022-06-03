package model.randomlinkstrategy;

import model.ladder.Link;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generateLinkable() {
        return RANDOM.nextBoolean();
    }

    @Override
    public Link generateFirstPositionLink() {
        return new Link(false, generateLinkable());
    }

    @Override
    public Link generateLastPositionLink(final Link preLink) {
        return new Link(preLink.getRight(), false);
    }
}

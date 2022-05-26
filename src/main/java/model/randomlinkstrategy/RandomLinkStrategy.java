package model.randomlinkstrategy;

import model.ladder.Link;
import model.util.RandomUtil;

public class RandomLinkStrategy implements LinkStrategy {

    @Override
    public boolean generateLinkable() {
        return RandomUtil.value();
    }

    @Override
    public Link generateFirstPositionLink() {
        return new Link(false, generateLinkable());
    }

    @Override
    public Link generateLastPositionLink() {
        return new Link(generateLinkable(), false);
    }
}

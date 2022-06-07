package model.ladder.linkablestrategy;

import java.util.Random;

public class RandomLinkableStrategy implements LinkableStrategy {

    private static final Random RANDOM = new Random();

    private static final RandomLinkableStrategy randomLinkableStrategy = new RandomLinkableStrategy();

    public static RandomLinkableStrategy getInstance() {
        return randomLinkableStrategy;
    }

    private RandomLinkableStrategy() {
    }

    @Override
    public boolean generateLinkable() {
        return RANDOM.nextBoolean();
    }
}

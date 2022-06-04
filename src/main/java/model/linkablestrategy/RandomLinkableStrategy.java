package model.linkablestrategy;

import java.util.Random;

public class RandomLinkableStrategy implements LinkableStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generateLinkable() {
        return RANDOM.nextBoolean();
    }
}

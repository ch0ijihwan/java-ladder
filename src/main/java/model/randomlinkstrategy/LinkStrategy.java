package model.randomlinkstrategy;

import model.ladder.Link;

public interface LinkStrategy {

    boolean generateLinkable();

    Link generateFirstPositionLink();

    Link generateLastPositionLink(Link preLink);
}

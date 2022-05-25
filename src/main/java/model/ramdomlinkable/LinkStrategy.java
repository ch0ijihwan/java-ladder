package model.ramdomlinkable;

public interface LinkStrategy {

    boolean generateLinkable();

    Link generateFirstPositionLink();

    Link generateLastPositionLink();
}

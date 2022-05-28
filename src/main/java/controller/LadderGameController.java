package controller;

import model.ladder.LadderHeight;
import model.ladder.Line;
import model.ladder.Lines;
import model.ladder.PlayerNames;
import model.randomlinkstrategy.LinkStrategy;
import model.randomlinkstrategy.RandomLinkStrategy;
import view.Input.Input;
import view.display.Display;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGameController {
    private final Input input;
    private final Display display;

    public LadderGameController(final Input input, final Display display) {
        this.input = input;
        this.display = display;
    }

    public void run() {
        List<String> names = input.inputNames();
        PlayerNames playerNames = new PlayerNames(names);
        LadderHeight ladderHeight = new LadderHeight(input.inputLadderHeight());
        LinkStrategy linkStrategy = new RandomLinkStrategy();
        Lines lines = new Lines(createLines(playerNames.countPlayers(), ladderHeight, linkStrategy));
        display.displayLadderResult(playerNames.getNames(), lines.getAllLineLinkStatus());
    }

    private List<Line> createLines(final int countOfPlayers, final LadderHeight ladderHeight, final LinkStrategy linkStrategy) {
        return Stream.generate(() -> new Line((countOfPlayers), linkStrategy))
                .limit(ladderHeight.getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}

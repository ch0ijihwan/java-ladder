package controller;

import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.ladder.Line;
import model.ladder.LineFactory;
import model.player.Players;
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
        Players players = new Players(names);
        LadderHeight ladderHeight = new LadderHeight(input.inputLadderHeight());
        Ladder ladder = new Ladder(createLines(players.countPlayers(), ladderHeight));
        display.displayLadderResult(players.getNames(), ladder.getRightLinkStatusOfAllLine());
    }

    private List<Line> createLines(final int countOfPlayers, final LadderHeight ladderHeight) {
        return Stream.generate(() -> LineFactory.createLineWith(countOfPlayers))
                .limit(ladderHeight.getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}

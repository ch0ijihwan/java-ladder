package controller;

import model.ladder.*;
import model.player.Players;
import model.result.Rewards;
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
        Rewards rewards = new Rewards(players.countPlayers(), input.inputRewards());
        LadderHeight ladderHeight = new LadderHeight(input.inputLadderHeight());

        Ladder ladder = new Ladder(createLines(players.countPlayers(), ladderHeight));
        display.displayPlayerNames(players.getNames());
        display.displayLadderMap(ladder.getRightLinkStatusOfAllLine());
        display.displayRewards(rewards.getRewards());

        LadderGameResult ladderGameResult = new LadderGameResult(ladder.match(players, rewards));
        displayGameResult(ladderGameResult);
    }

    private void displayGameResult(LadderGameResult ladderGameResult) {
        for (int i = 0; i < ladderGameResult.getSize(); i++) {
            display.displayResult(ladderGameResult, input.inputTargetPlayerName());
        }
    }

    private List<Line> createLines(final int countOfPlayers, final LadderHeight ladderHeight) {
        return Stream.generate(() -> LineFactory.createLineWith(countOfPlayers))
                .limit(ladderHeight.getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}

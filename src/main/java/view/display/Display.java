package view.display;

import model.ladder.LadderGameResult;

import java.util.List;

public interface Display {
    void displayPlayerNames(List<String> playerNames);

    void displayLadderMap(List<List<Boolean>> ladderStatus);

    void displayRewards(List<String> rewards);

    void displayResult(LadderGameResult ladderGameResult, String playerName);
}

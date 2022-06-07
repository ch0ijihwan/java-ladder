package view.display;

import model.ladder.LadderGameResult;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleDisplay implements Display {

    private static final String LINKED = "-----";
    private static final String NONE_LINKED = "     ";
    private static final String LINE_DELIMITER = "|";
    private static final String BLANK = " ";
    private static final String RESULT_DELIMITER = ":";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ALL_PLAYER = "all";
    private static final int MAXIMUM_NAME_SIZE = 5;
    private static final int FIRST_INDEX = 0;

    @Override
    public void displayPlayerNames(List<String> playerNames) {
        System.out.println(RESULT_MESSAGE);
        printRightAligned(playerNames);
    }

    private void printRightAligned(final List<String> tokens) {
        List<String> alignedTokens = tokens.stream()
                .map(this::addBlank)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(String.join("", alignedTokens));
    }

    private String addBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name);
        while (nameBuilder.length() <= MAXIMUM_NAME_SIZE) {
            nameBuilder.insert(FIRST_INDEX, BLANK);
        }
        name = nameBuilder.toString();
        return name;
    }

    @Override
    public void displayLadderMap(final List<List<Boolean>> ladderStatus) {
        ladderStatus.forEach(this::printLine);
    }

    @Override
    public void displayRewards(List<String> rewards) {
        printRightAligned(rewards);
    }

    private void printLine(final List<Boolean> lineStatus) {
        String line = lineStatus.stream()
                .map(this::getLineBar)
                .collect(Collectors.joining(LINE_DELIMITER));
        System.out.println(NONE_LINKED + LINE_DELIMITER + line + LINE_DELIMITER);
    }

    private String getLineBar(final Boolean line) {
        if (Boolean.TRUE.equals(line)) {
            return LINKED;
        }
        return NONE_LINKED;
    }

    @Override
    public void displayResult(final LadderGameResult ladderGameResult, final String playerName) {
        if (playerName.equals(ALL_PLAYER)) {
            ladderGameResult.getAllResult()
                    .forEach(this::printResult);
        }
        if (!playerName.equals(ALL_PLAYER) && ladderGameResult.containName(playerName)) {
            System.out.println(ladderGameResult.getResult(playerName));
        }
    }

    private PrintStream printResult(final Map.Entry<String, String> stringStringEntry) {
        return System.out.printf("%s %s %s %n", stringStringEntry.getKey(), RESULT_DELIMITER, stringStringEntry.getValue());
    }
}


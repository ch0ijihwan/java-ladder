package view.display;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleDisplay implements Display {

    private static final String LINKED = "-----";
    private static final String NONE_LINKED = "     ";
    private static final String LINE_DELIMITER = "|";
    private static final String BLANK = " ";
    private static final int MAXIMUM_NAME_SIZE = 5;
    private static final int FIRST_INDEX = 0;

    @Override
    public void displayLadderResult(final List<String> playerNames, final List<List<Boolean>> ladderStatus) {
        System.out.println("실행 결과");
        printRightAligned(playerNames);
        printLines(ladderStatus);
    }

    private void printRightAligned(final List<String> playerNames) {
        List<String> names = playerNames.stream()
                .map(this::addBlank)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(String.join("", names));
    }

    private String addBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name);
        while (nameBuilder.length() <= MAXIMUM_NAME_SIZE) {
            nameBuilder.insert(FIRST_INDEX, BLANK);
        }
        name = nameBuilder.toString();
        return name;
    }

    private void printLines(final List<List<Boolean>> ladderStatus) {
        ladderStatus.forEach(this::printLine);
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
}

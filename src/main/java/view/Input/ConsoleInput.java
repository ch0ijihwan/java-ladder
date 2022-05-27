package view.Input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInput implements  Input{

    private static final String NAME_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);


    @Override
    public List<String> inputNames() {
        return Arrays.stream(inputSplitNames())
                .collect(Collectors.toUnmodifiableList());
    }

    private String[] inputSplitNames() {
        return SCANNER.nextLine()
                .split(NAME_DELIMITER);
    }

    @Override
    public int inputLadderHeight() {
        return SCANNER.nextInt();
    }
}

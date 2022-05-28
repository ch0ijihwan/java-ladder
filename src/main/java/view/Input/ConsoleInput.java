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
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구문하세요)%n", NAME_DELIMITER);
        return Arrays.stream(inputSplitNames())
                .collect(Collectors.toUnmodifiableList());
    }

    private String[] inputSplitNames() {
        return SCANNER.nextLine()
                .split(NAME_DELIMITER);
    }

    @Override
    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}

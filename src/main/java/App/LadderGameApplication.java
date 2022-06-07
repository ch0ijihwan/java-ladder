package App;

import controller.LadderGameController;
import view.Input.ConsoleInput;
import view.Input.Input;
import view.display.ConsoleDisplay;
import view.display.Display;

public class LadderGameApplication {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Display display = new ConsoleDisplay();
        LadderGameController ladderGameController = new LadderGameController(input, display);
        ladderGameController.run();
    }
}

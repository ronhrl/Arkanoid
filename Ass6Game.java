import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ID 308433762
 * version 1
 * since 18/06/2020
 */
public class Ass6Game {
    /**
     * This is the main class that will run the game.
     * @param args the levels the player wants to play.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner animationRun = new AnimationRunner(gui);
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(animationRun, keyboard, gui, 600, 800);
        List<LevelInformation> levels = new ArrayList<>();
        LevelInformation directHit = new DirectHit(800, 600);
        LevelInformation wideEasy = new WideEasy(800, 600);
        LevelInformation green3 = new Green3(800, 600);
        LevelInformation finalFour = new FinalFour(800, 600);
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "1":
                    levels.add(directHit);
                    break;
                case "2":
                    levels.add(wideEasy);
                    break;
                case "3":
                    levels.add(green3);
                    break;
                case "4":
                    levels.add(finalFour);
                    break;
                default:
                    break;
            }
        }
            if (levels.isEmpty()) {
                levels.add(directHit);
                levels.add(wideEasy);
                levels.add(green3);
                levels.add(finalFour);
            }
            gameFlow.runLevels(levels);
            gui.close();
        }
    }
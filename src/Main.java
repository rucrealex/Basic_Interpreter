import java.util.Scanner;

/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
public class Main {
    public static void main (String[] args) {
        Interpreter inte = new Interpreter();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            inte.parse(input);
            if(input.equalsIgnoreCase("RUN")) {
                break;
            }
        }
    }
}

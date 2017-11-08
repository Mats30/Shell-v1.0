import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //infra
        Supplier<String> consoleReader = () -> new Scanner(System.in).nextLine();
        Consumer<Exception> exceptionHandler = e -> System.out.println(e.getMessage());

        //state
        CwdManager cwdManager = new CwdManager();
        PromptManager promptManager = new PromptManager(cwdManager);

        //behavior
        CommandRegistry commandRegistry = new CommandRegistry();
        commandRegistry.register("dir", new DirCommand(cwdManager));
        commandRegistry.register("cd" , new CdCommand(cwdManager));
        commandRegistry.register("prompt" , new PromptCommand(promptManager));

        //start point
        new MyShell(consoleReader, commandRegistry, System.out::println, exceptionHandler, promptManager).loop();
    }

}
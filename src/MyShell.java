import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class MyShell {

    final Supplier<String> consoleReader;
    final CommandRegistry commandRegistry;
    final Consumer<String> consoleWriter;
    final Consumer<Exception> exceptionHandler;
    final PromptManager promptManager;


    public MyShell(Supplier<String> consoleReader, CommandRegistry commandRegistry, Consumer<String> consoleWriter, Consumer<Exception> exceptionHandler, PromptManager promptManager) {
        this.consoleReader = consoleReader;
        this.commandRegistry = commandRegistry;
        this.consoleWriter = consoleWriter;
        this.exceptionHandler = exceptionHandler;
        this.promptManager = promptManager;
    }


    public void loop() {
        while(true){
            try{
                readInoutAndExecuteResult();
            } catch (Exception e){
                exceptionHandler.accept(e);
            }
        }
    }

    void readInoutAndExecuteResult() {
        consoleWriter.accept(promptManager.getPrompt());
        String userInput = consoleReader.get();
        String[] commandLine = userInput.split(" ");
        String commandName = commandLine[0];
        ShellCommand c = commandRegistry.getCommand(commandName);
        List<String> output = c.execute(commandLine);
        output.forEach(consoleWriter);
    }
}

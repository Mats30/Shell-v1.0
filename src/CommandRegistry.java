import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {


    private Map<String, ShellCommand> commandMap = new HashMap<>();

    public ShellCommand getCommand(String commandName) {
        return commandMap.getOrDefault(commandName, a -> Arrays.asList(a));
    }

    public void register(String commandName, ShellCommand command) {
        commandMap.put(commandName, command);
    }
}

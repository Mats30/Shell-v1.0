import java.util.Arrays;
import java.util.List;

public class PromptCommand implements ShellCommand {

    public PromptCommand(PromptManager promptManager) {
        this.promptManager = promptManager;
    }

    final PromptManager promptManager;

    @Override
    public List<String> execute(String[] commandLine) {

        promptManager.setPromptToCwd();

        return Arrays.asList("Command executed");
    }
}

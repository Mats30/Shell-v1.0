import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@ShellCommandName(commandName = "prompt")
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

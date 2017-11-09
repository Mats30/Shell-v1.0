import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.io.File;

@Component
@ShellCommandName(commandName = "cd")
public class CdCommand implements ShellCommand {
    final CwdManager cwdManager;

    public CdCommand(CwdManager cwdManager) {
        this.cwdManager = cwdManager;
    }

    @Override
    public List<String> execute(String[] commandLine) {

        File cwd = cwdManager.getCurrentDir();
        File parent = cwd.getParentFile();
        cwdManager.setCurrentDir(parent);


        return Arrays.asList("Directory was changed ");
    }
}

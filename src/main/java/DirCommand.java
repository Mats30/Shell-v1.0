import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;


import static java.util.stream.Collectors.toList;

@Component
@ShellCommandName(commandName = "dir")
public class DirCommand implements ShellCommand{

    public DirCommand(CwdManager cwdManager) {
        this.cwdManager = cwdManager;
    }

    final CwdManager cwdManager;

    public DirCommand() {
        cwdManager = null;
    }

    @Override
    public List<String> execute(String[] commandLine) {
        return Arrays.stream(getCwd().listFiles())
                .map(file -> (file.isDirectory() ? "DIR    " : "FILE    ") + file.getName())
                .collect(toList());
    }

    private File getCwd(){
        return cwdManager.getCurrentDir();
    }
}

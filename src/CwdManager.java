import java.io.File;

public class CwdManager {

    private File currentDir = new File(".").getAbsoluteFile();


    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File currentDir) {
        this.currentDir = currentDir;
    }
}

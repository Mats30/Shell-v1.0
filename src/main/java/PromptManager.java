
public class PromptManager {

    boolean shouldDisplayCwd = false;
    final CwdManager cwdManager;

    public PromptManager(CwdManager cwdManager) {
        this.cwdManager = cwdManager;
    }

    public void setPromptToCwd() {
        shouldDisplayCwd = true;
    }

    public String getPrompt() {
        return shouldDisplayCwd ? cwdManager.getCurrentDir().getAbsolutePath() : "?>";
    }

}

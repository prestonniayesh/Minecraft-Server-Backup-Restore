import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Restore {

    private String username;

    public Restore(String user) {
        username = user;
    }

    public void restore() throws IOException {
        File backup = new File("/Users/" + username + "/Desktop/backup");
        if (!backup.exists()) {
            System.out.println("Error: No backup exists. Backup server before restoring.");
            System.exit(0);
        }
        if (backup.list().length != 12) {
            System.out.println("Error: Backup missing files.");
            System.exit(0);
        }
        File mc = new File("/Users/" + username + "/Desktop/minecraft");
        FileUtils.cleanDirectory(mc);
        FileUtils.copyDirectory(backup, mc);
        File extra = new File("/Users/" + username + "/Desktop/minecraft/info.txt");
        extra.delete();
        System.out.println("Backup restored.");
    }
}

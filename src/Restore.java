import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Restore {
    public static void restore() throws IOException {
        File backup = new File("/Users/prestonniayesh/Desktop/backup");
        if (!backup.exists() || backup.list().length != 12) {
            System.out.println("No backup exists. Backup server before restoring.");
            System.exit(0);
        }
        File mc = new File("/Users/prestonniayesh/Desktop/minecraft");
        FileUtils.cleanDirectory(mc);
        FileUtils.copyDirectory(backup, mc);
        System.out.println("Backup restored.");
    }
}

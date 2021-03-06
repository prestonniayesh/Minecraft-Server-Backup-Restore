import org.apache.commons.io.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;

public class Backup {

    private String username;

    private String path;

    private String msg;

    private String timeStamp;

    public Backup(String user, String message) {
        username = user;
        path = "/Users/" + username + "/Desktop/backup";
        msg = message;
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    }

    public void prepare() throws IOException {
        File backup = new File(path);
        if (backup.exists()) {
            FileUtils.cleanDirectory(backup);
        } else {
            backup.mkdir();
        }
    }

    public void addInfo() throws IOException {
        File info = new File(path + "/info.txt");
        info.createNewFile();
        FileWriter fW = new FileWriter(path + "/info.txt");
        PrintWriter pW = new PrintWriter(fW);
        msg = "Time: " + timeStamp + "\nMessage: " + msg;
        pW.printf("%s" + "%n", msg);
        pW.close();
    }

    public void create() throws IOException {
        prepare();
        addInfo();
        File src = new File("/Users/" + username + "/Desktop/minecraft");
        File dest = new File(path);
        FileUtils.copyDirectory(src, dest);
        System.out.println("Backup complete.\n" + msg);
    }

}

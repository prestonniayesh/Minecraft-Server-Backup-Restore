import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.*;
import java.text.SimpleDateFormat;

public class Backup {

    private String path;

    private String msg;

    public Backup(String message) {
        path = "/Users/prestonniayesh/Desktop/minecraft/backup";
        msg = message;
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
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        msg = timeStamp + "\n" + msg;
        pW.printf("%s" + "%n", msg);
        pW.close();
    }

    public void create() throws IOException {
        prepare();
        addInfo();
        File src = new File("/Users/prestonniayesh/Desktop/minecraft");
        File dest = new File(path);
        IOFileFilter txtSuffixFilter = FileFilterUtils.suffixFileFilter(".jar");
        FileFilter filter = FileFilterUtils.notFileFilter(txtSuffixFilter);
        FileUtils.copyDirectory(src, dest, filter);
        File extra = new File(path + "/backup");
        FileUtils.deleteDirectory(extra);
    }

}

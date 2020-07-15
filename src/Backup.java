import java.io.File;
import java.io.IOException;

public class Backup {

    public static void listFiles() throws IOException {
        File mc = new File("/Users/prestonniayesh/Desktop/minecraft");
        for (String s: mc.list()) {
            System.out.println(s);
        }
        System.out.println("ran");
    }

}

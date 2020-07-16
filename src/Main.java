import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("backup")) {
            if (args.length == 1 || args[1].isEmpty()) {
                System.out.println("Please enter a backup message.");
                System.exit(0);
            } else {
                Backup backup = new Backup(args[1]);
                backup.create();
            }
        } else if (args[0].equals("restore")) {
            Restore.restore();
        }
    }
}

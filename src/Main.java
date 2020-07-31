import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("backup")) {
            if (args.length != 3) {
                System.out.println("Error: Incorrect operands.");
                System.exit(0);
            }
            if (args[1].isEmpty()) {
                System.out.println("Error: Please enter a backup message.");
                System.exit(0);
            }
            Backup backup = new Backup(args[2], args[1]);
            backup.create();
        } else if (args[0].equals("restore")) {
            if (args.length != 2) {
                System.out.println("Error: Incorrect operands.");
                System.exit(0);
            }
            Restore restore = new Restore(args[1]);
            restore.restore();
        } else {
            System.out.println("Error: Unrecognized command.");
            System.exit(0);
        }
    }
}

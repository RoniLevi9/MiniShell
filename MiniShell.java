import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler handler = new ShellCommandHandler();

   /// / printed manu with user supported operations
        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");
        System.out.println("Supported commands:");
        System.out.println("- pwd: Print working directory");
        System.out.println("- ls: List files in current directory (.. to go back)");
        System.out.println("- cd: Change directory");
        System.out.println("- mkdir: Create new directory");
        System.out.println("- touch: Create new file");
        System.out.println("- exit: Exit the program");

        /// / loop with all cases according to user action - linked to functions
        while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

        switch (command){
            case "pwd":
            handler.printWorkingDirectory();
            break;

            case "ls":
                handler.listDirectory();
                break;

            case "cd":
                handler.changeDirectory(argument);
                break;

            case "mkdir":
                handler.makeDirectory(argument);
                break;

            case "touch":
                handler.createFile(argument);
                break;

            case "help":
                handler.printHelp();
                break;

            case "exit":
                System.out.println("Goodbye!");
                return;

            default:
                System.out.println("Unknown command. Type 'help' to see available commands.");
            }
        }
    }
}
import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    /// / constractor for setting the current directory
    public ShellCommandHandler() {
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    /// / display the absolute path of the current directory
    public void printWorkingDirectory() {
        System.out.println(currentDirectory.getAbsolutePath());
    }

    /// / display the List with all files and directories in the current directory
    public void listDirectory() {
        File[] list = currentDirectory.listFiles();
        if(list != null) {
            for (File item : list) {
                if (item.isDirectory()) {
                    System.out.println("[DIR] " + item.getName());
                } else if (item.isFile()) {
                    System.out.println("[FILE] " + item.getName());
                } else {
                    System.out.println("unable to access");
                }
            }}
            else{
                System.out.println("The list is empty");
            }
        }

    /// / change the current directory
    public void changeDirectory(String name) {
    if (name == null || name.trim().isEmpty()){
        System.out.println("Usage: cd [directory_name]");
    }
    else if (name.equals("..")) {
        File parent = currentDirectory.getParentFile();
        if (parent != null) {
            try {
                currentDirectory = parent.getCanonicalFile();
            } catch (IOException e) {
                System.out.println("Failed to move path.");
            }
        }
            else {
                System.out.println("This is the main path");
            }
        }

    else {
        File newdir = new File(currentDirectory, name);
        if (newdir.exists() && newdir.isDirectory()) {
            currentDirectory = newdir;
        } else {
            System.out.println("Directory not found: " + name);
        }
    }}

    /// / make a new directory
    public void makeDirectory(String name) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Usage: mkdir [directory_name]");
        } else {
            File newF = new File(currentDirectory, name);
            if (newF.exists()) {
                System.out.println("Directory already exists.");
            }
            else {
                if(newF.mkdir()){
                    System.out.println("Directory created: " + name);
                }
                else{
                    System.out.println("Failed to create directory.");
            }
    }
    }}

    /// / make a new file
    public void createFile(String name) {
        // TODO: Implement the create file command
        // If name is null, show usage message: "Usage: touch [file_name]"
        // If file already exists, print: "File already exists."
        // If file creation is successful, print: "File created: [name]"
        // If file creation fails, print error message with exception details
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Usage: touch [file_name]");
            return;
        }
        File newF = new File(currentDirectory, name);
        try{
            if(newF.createNewFile()){
                System.out.println("File created: " +name);
            }
            else{
                System.out.println("File already exists.");
            }
        } catch (IOException r) {
            System.out.println("error");
            r.printStackTrace();
        }
    }

    /// / print the information about all available commands
    public void printHelp() {
        System.out.println("Supported commands:");
        System.out.println("pwd - Show current directory path");
        System.out.println("ls - List contents of the current directory");
        System.out.println("cd [dir] - Change directory (.. to go back)");
        System.out.println("mkdir [dir] - Create a new directory");
        System.out.println("- touch [file] - Create a new file");
        System.out.println("- help - Show this help message");
        System.out.println("- exit: Exit the shell");
    }

    /// / Return the current directory
    public File getCurrentDirectory() {
        return currentDirectory;
    }
}
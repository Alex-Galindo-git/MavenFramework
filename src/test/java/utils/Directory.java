package utils;

public class Directory {
    public  void getDirectory() {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("user.dir: " + currentDirectory);

        String  USER_HOME_DIR = System.getProperty("user.home");
        System.out.println("user home: " + USER_HOME_DIR);
    }
}
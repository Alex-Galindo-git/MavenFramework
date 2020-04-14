package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constants {

    public static final String APPNAME;
    public static final String VERSION;


    static {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("constants.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        APPNAME = p.getProperty("APPNAME");
        VERSION = p.getProperty("VERSION");

    }
}

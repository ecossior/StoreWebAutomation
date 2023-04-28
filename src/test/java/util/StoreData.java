package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreData {
    public static  String SData(String valor) throws IOException {
        Properties properties =new Properties();
        String path= "src/test/resources/SData.properties";
        properties.load(new FileInputStream(path));
        return properties.getProperty(valor);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(SData("user"));
        System.out.println(SData("pwd"));
    }
}

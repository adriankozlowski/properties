package pl.sda;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("ustawienia.properties"));
            String imieWlasciela = (String) properties.get("imie_wlasciela");

            properties.setProperty("property1","wartosc");
            properties.setProperty("property2","wartosc2");
            properties.setProperty("property3","wartosc3");
            properties.setProperty("property4","wartosc4");
            properties.store(new FileOutputStream("ustawienia.properties"),null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

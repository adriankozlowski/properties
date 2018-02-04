package pl.sda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Register {

    public static final String FILENAME = "ustawienia.properties";
    private static Register instance;
    private Properties properties;


    private Register() {
        properties = new Properties();
        File file = new File(FILENAME);
        if(file.exists()){
            load();
        } else{
            save();
        }
    }

    public void add(String key, String value){
        properties.setProperty(key, value);
    }

    public String get(String key){
        return  properties.getProperty(key);
    }

    public void save(){
        try {
            properties.store(new FileOutputStream(FILENAME),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        try {
            properties.load(new FileInputStream(FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

}

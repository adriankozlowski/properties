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


    /**
     * Tworzę instancję klasy Register
     */
    private Register() {
        //zapewniam sobie istnieje obiektu properties
        properties = new Properties();
        //tworzę uchwyt do pliku properties
        File file = new File(FILENAME);
        //sprawdzam czy plik istnieje
        if(file.exists()){
            //jezeli istnieje, to odczytuję go moją metodą do odczytu pliku.
            load();
        } else{
            //jezeli nie istnieje, to zapisujuę pusty plik wlasciwosci
            save();
        }
    }

    /**
     * Przyjmuje klucz i wartosc, ktore zostaną wpisane do instancji klasy
     * properties
     * @param key klucz typu string
     * @param value wartośc typu string
     */
    public void add(String key, String value){
        //tutaj jest wpisanie tych wartości
        properties.setProperty(key, value);
    }

    /**
     * analogicznie do mapy, properties trzymajac zestawy danych
     * udostępnia je na podstawie klucza podanego w metodzie add(klucz, wartosc)
     * Zatem podając klucz otrzymamy wartość zapisaną wcześniej
     * @param key
     * @return
     */
    public String get(String key){
        //odczyt
        return  properties.getProperty(key);
    }

    /**
     * zapisujemy do pliku gotowy zestaw danych (cały obiekt properties) używając
     * mechanizmów z tej klasy
     */
    public void save(){
        try {
            //uzywam metody store, ponieważ dba o spójność danych w pliku
            //podaję tylko strumien wejściowy i nazwę pliku
            properties.store(new FileOutputStream(FILENAME),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Odczyt danych z pliku
     */
    public void load(){
        try {
            //odczyt z pliku. Podaję tylko strumien.
            properties.load(new FileInputStream(FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Singleton. Sprawdzam czy istnieje już instancja tej klasy
     * i jeżeli nie, to ją tworzę, w przeciwynym wypadku zwracam
     * juz utworzoną wcześniej.
     * @return instancja klasy Register.
     */
    public static Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

}

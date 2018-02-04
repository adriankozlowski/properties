package pl.sda;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        String imie_wlasciciela = Register.getInstance().get("imie_wlasciciela");
        System.out.println(imie_wlasciciela);
    }
}

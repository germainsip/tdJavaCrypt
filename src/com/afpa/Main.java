package com.afpa;

import com.afpa.GUI.Menu;
import com.afpa.model.Message;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        String test = menu.init();
        String home = System.getProperty("user.dir");




        if (!test.equals("quit")){
            Path msgClearPath;
            Path msgEncodedPath;
            Path msgKeyPath;
            Message message;
            Map<String,String> choix = menu.pathChooser(test);
            //Path msgClearPath = Paths.get(home,"decoded.txt");
            switch (test) {
                case "decode" -> {
                    msgClearPath = Paths.get(home, "decoded.txt");
                    msgEncodedPath = Paths.get(home, choix.get("encodedFile") + ".txt");
                    msgKeyPath = Paths.get(home, choix.get("keyFile") + ".txt");
                    message = new Message(true, msgClearPath, msgEncodedPath, msgKeyPath);
                    message.readNwrite();
                }
                case "encode" -> {
                    msgClearPath = Paths.get(home, choix.get("clearFile") + ".txt");
                    msgEncodedPath = Paths.get(home, "encoded.txt");
                    msgKeyPath = Paths.get(home, choix.get("keyFile") + ".txt");
                    message = new Message(false, msgClearPath, msgEncodedPath, msgKeyPath);
                    message.readNwrite();
                }
            }
        }
    }
}

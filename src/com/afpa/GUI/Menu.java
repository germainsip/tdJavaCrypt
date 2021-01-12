package com.afpa.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    /**
     * Initialisation du menu
     * @return
     */
    public String init(){
        Scanner sc = new Scanner(System.in);
        String retour;
        String sortie = null;
        do {
            System.out.println("╔══════════════════════════════════════╗\n" +
                    "║   System d'encodage et de décodage   ║ \n" +
                    "║             de messages              ║ \n" +
                    "╠══════════════════════════════════════╣ \n" +
                    "║       1) Décoder un message          ║ \n" +
                    "║       2) Encode un message           ║ \n" +
                    "║       3) Quitter                     ║ \n" +
                    "╚══════════════════════════════════════╝");

            retour = sc.next();
            switch (retour){
                case "1": sortie = "decode";
                    break;
                case "2": sortie = "encode";
                    break;
                case "3": sortie = "quit";
                    break;

            }

        } while(sortie == null);

        return sortie;
    }

    public Map<String, String> pathChooser(String type){
        Scanner sc = new Scanner(System.in);
        Map<String, String> pathChoices = new HashMap<>();
        switch (type){
            case "decode":
                System.out.println("Entrez le nom du fichier à décoder (sans extension)");
                pathChoices.put("encodedFile",sc.next());
                System.out.println("Entrez le nom du fichier contenant la clé de décodage (sans extension)");
                pathChoices.put("keyFile", sc.next());
                break;
            case "encode":
                System.out.println("Entrez le nom du fichier à encoder (sans extension)");
                pathChoices.put("clearFile",sc.next());
                System.out.println("Entrez le nom du fichier contenant la clé de décodage (sans extension)");
                pathChoices.put("keyFile", sc.next());
                break;
        }

        return pathChoices;
    }

}

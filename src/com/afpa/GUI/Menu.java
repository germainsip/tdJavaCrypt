package com.afpa.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    /**
     * Initialisation du menu
     * @return choix utilisateur
     */
    public String init(){
        Scanner sc = new Scanner(System.in);
        String retour;
        String sortie = null;
        do {
            System.out.println("""
                    ╔══════════════════════════════════════╗
                    ║   System d'encodage et de décodage   ║\s
                    ║             de messages              ║\s
                    ╠══════════════════════════════════════╣\s
                    ║       1) Décoder un message          ║\s
                    ║       2) Encode un message           ║\s
                    ║       3) Quitter                     ║\s
                    ╚══════════════════════════════════════╝""");

            retour = sc.next();
            switch (retour) {
                case "1" -> sortie = "decode";
                case "2" -> sortie = "encode";
                case "3" -> sortie = "quit";
            }

        } while(sortie == null);

        return sortie;
    }

    public Map<String, String> pathChooser(String type){
        Scanner sc = new Scanner(System.in);
        Map<String, String> pathChoices = new HashMap<>();
        switch (type) {
            case "decode" -> {
                System.out.println("Entrez le nom du fichier à décoder (sans extension)");
                pathChoices.put("encodedFile", sc.next());
                System.out.println("Entrez le nom du fichier contenant la clé de décodage (sans extension)");
                pathChoices.put("keyFile", sc.next());
            }
            case "encode" -> {
                System.out.println("Entrez le nom du fichier à encoder (sans extension)");
                pathChoices.put("clearFile", sc.next());
                System.out.println("Entrez le nom du fichier contenant la clé de décodage (sans extension)");
                pathChoices.put("keyFile", sc.next());
            }
        }

        return pathChoices;
    }

}

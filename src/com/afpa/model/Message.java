package com.afpa.model;

import com.afpa.tools.Transcoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Message {
    private Boolean encoded;
    private List<String> msgClear;
    private List<String> msgEncodded;
    private Path msgClearPath;
    private Path msgEncodedPath;
    private Path keyPath;
    private String key;
    private Transcoder transCoder;

    //TODO: gérer le cas où le fichier n'existe pas !

    /**
     * Constructeur de l'objet message
     * @param encoded booléen pour savoir si le message est encodé ou non
     * @param msgClearPath chemin vers le fichier décodé
     * @param msgEncodedPath chemin vers le fichier codé
     * @param keyPath chemin vers la clé
     * @throws IOException
     */
    public Message(Boolean encoded, Path msgClearPath, Path msgEncodedPath, Path keyPath) throws IOException {
        this.encoded = encoded;
        this.msgClearPath = msgClearPath;
        this.msgEncodedPath = msgEncodedPath;
        this.keyPath = keyPath;
        this.key = Files.readString(keyPath);

        this.transCoder = new Transcoder(key);
    }

    public void readNwrite() {
        if (encoded) {
            try {
                this.msgEncodded = Files.readAllLines(msgEncodedPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("====== Décodage =====");
            for(String ligne : msgEncodded){
                //System.out.println(ligne);
                String ligneDecoded = transCoder.decode(ligne);
                System.out.println(ligneDecoded);
                try {
                    Files.writeString(msgClearPath, ligneDecoded + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Le message décodé se trouve: " + msgClearPath.toString());
        } else {
            try {
                this.msgClear = Files.readAllLines(msgClearPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String ligne : msgClear) {
                //System.out.println(ligne);
                String ligneEncoded = transCoder.encode(ligne);
                try {
                    Files.writeString(msgEncodedPath, (ligneEncoded + System.lineSeparator()), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Le message encodé se trouve: " + msgEncodedPath.toString());

        }
    }
}

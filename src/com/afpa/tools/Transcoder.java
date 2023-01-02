package com.afpa.tools;

import org.germain.tool.ManaBox;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.stripAccents;

public class Transcoder {
    private final Map<Character,String> encode = new HashMap<>();
    private final Map<String,Character> decode = new HashMap<>();

    public Map<Character, String> getEncode() {
        return encode;
    }

    public Map<String, Character> getDecode() {
        return decode;
    }

    /**
     * Constructeur de Transcoder
     * @param keyCrypted clé cryptée
     */
    public Transcoder(String keyCrypted) {
        String key = ManaBox.decrypt(keyCrypted);

        //boucles de génération de maps
        char[] code = key.toCharArray();
        char first = 'A';
        char second = 'A';
        for(char letter : code){
            this.encode.put(letter, Character.toString(first) + second);
            this.decode.put(Character.toString(first) + second,letter);
            if (second != 'Z'){
                second++;
            } else {
                first++;
                second = 'A';
            }


        }
    }

    /**
     * Méthode de codage de messages
     * @param message message à encoder
     * @return message encodé
     */
    public String encode(String message){
       //décodage
        message = stripAccents(message);
        //System.out.println(msgTest);
        char[] mesgTab = message.toCharArray();
        StringBuilder msgRetour = new StringBuilder();
        for(Character letter : mesgTab){
            msgRetour.append(encode.get(letter));
        }
        return msgRetour.toString();

    }

    /**
     * Méthode de décodage de messages
     * @param message message à décoder
     * @return message décodé
     */
    public String decode(String message){
       //décodage
        StringBuilder msgRetour = new StringBuilder();
        String[] mesgTab = new String[ message.length()/2];
        int j = 0;
        //System.out.println("msgTest to tab");
        for (int i = 0 ; i < message.length()-1 ; i=i+2){
            //System.out.println(msgTest.substring(i,i+2));
            mesgTab[j] = message.substring(i,i+2);
            j++;

        }

        for (String couple : mesgTab){
            msgRetour.append(decode.get(couple));
        }

        return msgRetour.toString();
    }
}

package com.afpa.tools;

import org.germain.tool.ManaBox;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.stripAccents;

public class Transcoder {
    private Map<Character,String> encode = new HashMap<Character, String>();
    private Map<String,Character> decode = new HashMap<String, Character>();

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
        Character first = 'A';
        Character second = 'A';
        for(char letter : code){
            //System.out.println(first.toString()+second.toString());
            this.encode.put(letter,first.toString()+second.toString());
            this.decode.put(first.toString()+second.toString(),letter);
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
     * @param message
     * @return
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
     * @param message
     * @return
     */
    public String decode(String message){
       //décodage
        StringBuilder msgRetour = new StringBuilder();
        String[] mesgTab = new String[ message.length()/2];
        int j = 0;
        //System.out.println("msgTest to tab");
        for (int i = 0 ; i < message.length()-1 ; i++){
            //System.out.println(msgTest.substring(i,i+2));
            mesgTab[j] = message.substring(i,i+2);
            j++;
            i++;
        }
        // System.out.println("=========================");
        //System.out.println("encodage");
        for (String couple : mesgTab){
            //System.out.println(couple);
            msgRetour.append(decode.get(couple));
        }

        return msgRetour.toString();
    }
}

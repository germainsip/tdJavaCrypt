package com.afpa.tools;

import org.germain.tool.ManaBox;

import java.util.HashMap;
import java.util.Map;

public class Transcoder {
    private Map<Character,String> encode = new HashMap<Character, String>();
    private Map<String,Character> decode = new HashMap<String, Character>();

    public Map<Character, String> getEncode() {
        return encode;
    }

    public Map<String, Character> getDecode() {
        return decode;
    }

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


    public String encode(String message){
       //décodage
        return message;
    }public String decode(String message){
       //décodage
        return message;
    }
}

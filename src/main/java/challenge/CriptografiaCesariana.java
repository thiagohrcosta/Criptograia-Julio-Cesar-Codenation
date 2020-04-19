package challenge;

import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    public String mainCode(String texto){
        String setLowerCase = texto.toLowerCase();
        return setLowerCase;
    }

    public int txtSize(String texto){
        int txtSize = texto.length();
        return txtSize;
    }

    @Override
    public String criptografar(String texto) {

        if (texto.isEmpty()) throw new IllegalArgumentException("Error! Texto can´t be empty");
        if (texto == null) throw new NullPointerException("Error! Texto can´t be null");

        String newCode = "";
        int encode = 3;

        for (int i=0; i < txtSize(texto); i++){
            char letter = (char) (mainCode(texto).charAt(i) + encode);

            if (Character.isWhitespace(mainCode(texto).charAt(i))){
                newCode += " ";
            }
            else if (Character.isDigit(mainCode(texto).charAt(i))){
                newCode += mainCode(texto).charAt(i);
            }
            else if (letter > 'z'){
                newCode += (char)(mainCode(texto).charAt(i) - (26 - encode));
            }
            else {
                newCode += (char)(mainCode(texto).charAt(i) + encode);
            }
        }

        return newCode;
    }

    @Override
    public String descriptografar(String texto) {

        if (texto.isEmpty()) throw new IllegalArgumentException("Error! Texto can´t be empty");
        if (texto == null) throw new NullPointerException("Error! Texto can´t be null");

        String newCode = "";
        int decode = -3;

        for (int i=0; i < txtSize(texto); i++){
            char letter = (char) (mainCode(texto).charAt(i) + decode);

            if (Character.isWhitespace(mainCode(texto).charAt(i))){
                newCode += " ";
            }
            else if (Character.isDigit(mainCode(texto).charAt(i))){
                newCode += mainCode(texto).charAt(i);
            }
            else if (letter > 'z'){
                newCode += (char)(mainCode(texto).charAt(i) - (26 - decode));
            }
            else {
                newCode += (char)(mainCode(texto).charAt(i) + decode);
            }
        }

        return newCode;
    }
}

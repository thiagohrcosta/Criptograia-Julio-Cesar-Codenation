package challenge;

import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    public String mainCode(String texto) {
        String setLowerCase = texto.toLowerCase();
        return setLowerCase;
    }

    public String checkTexto(String texto) {
        if (texto.isEmpty()) throw new IllegalArgumentException("Error! Texto can´t be empty");
        if (texto == null) throw new NullPointerException("Error! Texto can´t be null");

        return texto;
    }

    private String doCryptoOrDecrypto(String texto, int encodeOrDecode) {
        int txtSize = texto.length();
        String newCode = "";

        for (int i = 0; i < txtSize; i++) {

            char letter = (char) (mainCode(texto).charAt(i) + encodeOrDecode);

            if (Character.isWhitespace(mainCode(texto).charAt(i))) {
                newCode += " ";
            } else if (Character.isDigit(mainCode(texto).charAt(i))) {
                newCode += mainCode(texto).charAt(i);
            } else if (letter > 'z') {
                newCode += (char) (mainCode(texto).charAt(i) - (26 - encodeOrDecode));
            } else {
                newCode += (char) (mainCode(texto).charAt(i) + encodeOrDecode);
            }
        }
        return newCode;
    }

    @Override
    public String criptografar(String texto) {
        checkTexto(texto);
        return doCryptoOrDecrypto(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        checkTexto(texto);
        return doCryptoOrDecrypto(texto, -3);
    }
}


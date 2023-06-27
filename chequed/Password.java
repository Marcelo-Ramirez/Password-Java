package chequed;

public class Password {
    public static boolean containSigns(String password) {
        String[] simbolos = {
                "@", "#", "$", "%", "&", "*", "+", "-", "/", "!", "?",
                "(", ")", "[", "]", "{", "}", "<", ">", "=", "|", "~",
                ":", ";", ".", ",", "'"
        };
        for (int i = 0; i < password.length(); i++) {
            char element = password.charAt(i);
            String stringCaracter = new String(new char[] { element });
            for (int f = 0; f < simbolos.length; f++) {
                if (stringCaracter.equals(simbolos[f])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containCapitalLetters(String password) {
        String[] capitalLetters = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        for (int i = 0; i < password.length(); i++) {
            char element = password.charAt(i);
            String stringCaracter = new String(new char[] { element });
            for (int f = 0; f < capitalLetters.length; f++) {
                if (stringCaracter.equals(capitalLetters[f])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containSpaceInWhite(String password) {
        String spaceInBlanck = " ";
        for (int i = 0; i < password.length(); i++) {
            char element = password.charAt(i);
            String stringCaracter = new String(new char[] { element });
            if (spaceInBlanck.equals(stringCaracter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containNumbers(String password) {
        String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        for (int i = 0; i < password.length(); i++) {
            char element = password.charAt(i);
            String stringCaracter = new String(new char[] { element });
            for (int f = 0; f < numbers.length; f++) {
                if (stringCaracter.equals(numbers[f])) {
                    return true;
                }
            }
        }
        return false;
    }

}

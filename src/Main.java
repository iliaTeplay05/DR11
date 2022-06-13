import java.util.Scanner;

public class Main {

    static void printLnMassage (String massage) {
        System.out.println(massage);
    }

    static String Text() {
        Scanner scanner = new Scanner(System.in);
        String startText = scanner.nextLine();
        return startText;
    }

    static int index(int alphabetLength) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt() % alphabetLength;
        return index;
    }

    static char[] charArray(String startText) {
        char[] startSymbols = startText.toCharArray();
        return startSymbols;
    }

    static String result (char[] startSymbols, String startText) {
        String finishText = "";
        for (int i = 0; i < startText.length(); i++) {
            finishText = finishText + startSymbols[i];
        }
        return finishText;
    }

    static int back (int temp, int SymbolA, int SymbolB) {
        int tempA = temp - SymbolA;
        temp = SymbolB + tempA;
        return temp;
    }
    static char[] generalOperation(String startText, char[] startSymbols, int symbolWhitespace, int index, int lastSymbol, int firstSymbol) {
        for (int i = 0; i < startText.length(); i++) {
            int temp = startSymbols[i];
            if (temp != symbolWhitespace) {
                temp += index;
                if (temp > lastSymbol) {
                    temp = back(temp, lastSymbol, firstSymbol);
                }
                if (temp < firstSymbol) {
                    temp = back(temp, firstSymbol, lastSymbol);
                }
            }
            startSymbols[i] = (char) temp;
        }
        return  startSymbols;
    }

    public static void main(String[] args) {
        int alphabetLength = 33;
        int symbolWhitespace = 32;
        int lastSymbol = 1103;
        int firstSymbol = 1071;

        printLnMassage("Эта программа может зашифровать или расшифровать текст с помощью шифра Цезаря");

        boolean dr = false;
        do {
            printLnMassage("Выберите язык(Введите ru - Русский, en - Английский): ");
            String hell = Text();
            if (hell.equals("ru") || hell.equals("en")) {
                dr = true;
            }
            if (hell.equals("en")) {
                alphabetLength = 26;
                lastSymbol = 122;
                firstSymbol = 96;
            }
        } while (dr == false);

        printLnMassage("Введите текст, который хотите расшифровать или зашифровать: ");
        String startText = Text();

        char[] startSymbols =  charArray(startText);

        printLnMassage("Введите значение на которое произойдет смещение(можно использовать отрицательные значения): ");
        int index = index(alphabetLength);

        startSymbols = generalOperation(startText, startSymbols, symbolWhitespace, index, lastSymbol, firstSymbol);

        String result = result(startSymbols, startText);

        printLnMassage("Программа получила такой результат: " + result);

    }
}
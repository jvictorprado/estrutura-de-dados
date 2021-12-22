import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'mudancaBase' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER num
     *  2. INTEGER base
     */

    public static String mudancaBase(int num, int base) {
        if (num > 0) {
            if (num < base) {
                if(base > 10) {
                    return transformaNumEmLetra(num%base);
                }
                return (num%base + "");
            }
            return mudancaBase((num / base), base) + (base <= 10 ? Integer.toString(num % base) : transformaNumEmLetra(num%base));
        } else if (num == 0) {
            return "0";
        } else {
            return "";
        }
    }

    public static String transformaNumEmLetra(int num) {

        switch(num) {
            case 10:
                return ("A");
            case 11:
                return ("B");
            case 12:
                return ("C");
            case 13:
                return ("D");
            case 14:
                return ("E");
            case 15:
                return ("F");
        }
        return num + "";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int num = Integer.parseInt(bufferedReader.readLine().trim());

        int base = Integer.parseInt(bufferedReader.readLine().trim());

        String resultado = Result.mudancaBase(num, base);

        bufferedWriter.write(resultado);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

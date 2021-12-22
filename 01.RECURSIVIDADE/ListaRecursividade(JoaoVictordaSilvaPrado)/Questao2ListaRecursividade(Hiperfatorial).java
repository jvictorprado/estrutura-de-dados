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
     * Complete the 'hiperfatorial' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    
    public static long potencia(int n1, int n2) {
        if (n2 <= 0) {
            return 1;
        }else {
            return n1 * potencia(n1, n2 - 1);
        }
    }
    
    public static long hiperfatorial(int n) {
        if (n <= 1) {
            return 1; 
        }
        return potencia(n,n) * hiperfatorial(n-1);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        long fatorial = Result.hiperfatorial(n);

        bufferedWriter.write(String.valueOf(fatorial));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

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
     * Complete the 'dec2Bin' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER num as parameter.
     */

    public static String dec2Bin(int num) {
        if (num > 0) {
            if (num < 2) {
                return "1";
            }
            return dec2Bin(num / 2) + Integer.toString(num % 2);
        } else if(num==0){
            return "0";
        }else {
            return "";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int num = Integer.parseInt(bufferedReader.readLine().trim());

        String bin = Result.dec2Bin(num);

        bufferedWriter.write(bin);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

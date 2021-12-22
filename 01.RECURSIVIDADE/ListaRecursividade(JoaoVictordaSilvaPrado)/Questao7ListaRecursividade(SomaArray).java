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
     * Complete the 'somaArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY numbersList as parameter.
     */

    public static int somaArray(List<Integer> numbersList) {
        if(numbersList.size()<=0){
            return 0;
        }
        return numbersList.remove(0)+somaArray(numbersList);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> numbersList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int soma = Result.somaArray(numbersList);

        bufferedWriter.write(String.valueOf(soma));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
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
     * Complete the 'is_X_ISH' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. STRING frase1
     *  2. STRING frase2
     */

    public static boolean contains2(String s, char c) {
        if(!s.isEmpty()){
            if (s.charAt(0) == c){
                return true;
            }
            return contains2(s.substring(1),c);
            
        }
        return false;
    }
    
    public static boolean is_X_ISH(String frase1, String frase2) {
        if((frase1==null)||(frase2==null)){
            return false;
        }else if(frase1.length()==0){
            return true;
        }else{
            char pChar = frase1.charAt(0);
            if(contains2(frase2,pChar)){
                return is_X_ISH(frase1.substring(1),frase2);
            }
            return false;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String frase1 = bufferedReader.readLine();

        String frase2 = bufferedReader.readLine();

        boolean result = Result.is_X_ISH(frase1, frase2);

        bufferedWriter.write(String.valueOf(result ? 1 : 0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

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

class No<T> {
    private T info;
    private No<T> prox;

    public No(T e) {
        info = e;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }
}

class PilhaDinamica<T> {
    private No<T> topo;
    private int qtd;

    public void push(T e) {
        No<T> novo = new No<T>(e);
        novo.setProx(topo);
        topo = novo;
        qtd++;
    }

    public T pop() {
        T r = null;
        if (topo != null) {
            r = topo.getInfo();
            topo = topo.getProx();
            qtd--;
        } else {
            throw new RuntimeException("Pilha vazia");
        }
        return r;
    }

    public T top() {
        T r = null;
        if (topo != null) {
            r = topo.getInfo();
        }
        return r;
    }

    public int size() {
        return qtd;
    }

    public void print() {
        System.out.println(this.toString());
    }

    public String toString() {
        String s = "topo";
        No<T> p = topo;
        while (p != null) {
            s += (" -> " + p.getInfo());
            p = p.getProx();
        }
        return s;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING frase as parameter.
     */

    public static boolean isValid(String frase) {
       PilhaDinamica<Character> pilha = new PilhaDinamica<Character>();

        if(frase.length()>0){
            char c = frase.charAt(0);
            if (c == '(' || c == '{' || c=='[') {
                pilha.push(c);
            } else {
                if (pilha.isEmpty()) {
                    return false;
                }
                if ((c == ')' && pilha.top() != '(') || (c == '}' && pilha.top() != '{')||((c == ']' && pilha.top() != '['))) {
                    return false;
                }
                pilha.pop();
            }
            if(frase.length()>1){
                isValid(frase.substring(1));
            }else {
                isValid(frase);
            }
        }
        return pilha.isEmpty();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String frase = bufferedReader.readLine();

        boolean result = Result.isValid(frase);

        bufferedWriter.write(String.valueOf(result ? 1 : 0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

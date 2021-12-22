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

    No(T e) {
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

class Fila<T> {
    private No<T> inicio, fim;
    private int qtd;

    public void enqueue(T e) {
        No<T> novo = new No<T>(e);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.setProx(novo);
            fim = novo;
        }
        qtd++;
    }

    public T dequeue() {
        T resp = null;
        if (inicio != null) {
            resp = inicio.getInfo();
            inicio = inicio.getProx();
            if (inicio == null) {
                fim = null;
            }
            qtd--;
        }
        return resp;
    }

    public String toString() {
        String s = "";
        No<T> p = inicio;
        for (int i = 0; i < qtd; i++) {
            s += p.getInfo() + " ";
            p = p.getProx();
        }
        return s;
    }
    
    public String toStringNeg() {
        String s = "";
        No<T> p = inicio;
        for (int i = 0; i < qtd; i++) {
            s += "-"+ p.getInfo() + " ";
            p = p.getProx();
        }
        return s;
    }

    public void imprimeFila() {
        System.out.println(this.toString());
    }

    public Boolean isEmpty() {
        return (qtd == 0);
    }
    
    public int size(){
        return qtd;
    }

    public T top() {
        return inicio.getInfo();
    }
}


class Result {
    public static String fatoracao(int number) {
        Fila<Integer> f = new Fila<Integer>();
        String s = "";
        if ((number==0) || (number==1)) {
            s = number + "";
        } else if (number < 0) {
            number = number * -1;
            for (int i = 2; i < number; i++) {
                while (number % i == 0) {
                    f.enqueue(i);
                    number = number / i;
                }
            }
            if (number >= 2) {
                f.enqueue(number);
            }
            s = "-1 ";
            s += f.toString();
        } else {
            for (int i = 2; i < number; i++) {
                while (number % i == 0) {
                    f.enqueue(i);
                    number = number / i;
                }
            }
            if (number >= 2) {
                f.enqueue(number);
            }
            s = f.toString();
        }
        return s;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int number = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.fatoracao(number);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

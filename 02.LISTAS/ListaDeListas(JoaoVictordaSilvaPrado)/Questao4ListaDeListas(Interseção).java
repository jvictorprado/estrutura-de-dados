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
    T info;
    No<T> next;

    public No(T e) {
        info = e;
    }
}

class Lista<T> {

    private No<T> inicio, fim;
    private int qtd;

    public Lista() {
        inicio = fim = null;
        qtd = 0;
    }

    public void add(T e) {
        No<T> nova = new No<T>(e);
        if (inicio == null) {
            inicio = nova;
            fim = nova;
        } else {
            fim.next = nova;
            fim = nova;
        }
        qtd++;
    }

    public void remove(T e) {
        if (inicio != null) {
            if (inicio.info.equals(e)) {
                inicio = inicio.next;
                if (inicio == null) {
                    fim = null;
                }
                qtd--;
            } else {
                No<T> p = inicio;
                while (p.next != null) {
                    if (p.next.info.equals(e)) {
                        p.next = p.next.next;
                        if (p.next == null) {
                            fim = p;
                        }
                        qtd--;
                        break;
                    } else {
                        p = p.next;
                    }
                }
            }
        }
    }

    public boolean search(T e) {
        No<T> p = inicio;
        while (p != null) {
            if (p.info.equals(e)) {
                return true;
            } else {
                p = p.next;
            }
        }
        return false;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        String s = "";
        No<T> p = inicio;
        while (p != null) {
            s += (p.info + " ");
            p = p.next;
        }
        return s;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public No<T> getInicio() {
        return inicio;
    }

    public void setInicio(No<T> inicio) {
        this.inicio = inicio;
    }

    public No<T> getFim() {
        return fim;
    }

    public void setFim(No<T> fim) {
        this.fim = fim;
    }
}


class Result {
    public static String conjCalculator(String conjA, String conjB) {
        Lista<String> intersecao = new Lista<String>();
        String[] splitA = conjA.split(" ");
        String[] splitB = conjB.split(" ");
        
        if (splitA.length <= splitB.length) {
            for (int i = 0; i < splitA.length; i++) {
                for (int j = 0; j < splitB.length; j++) {
                    if (splitA[i].equals(splitB[j])) {
                        intersecao.add(splitA[i]);
                        break;
                    }
                }
            }
        } else if (splitB.length <= splitA.length) {
            for (int i = 0; i < splitB.length; i++) {
                for (int j = 0; j < splitA.length; j++) {
                    if (splitB[i].equals(splitA[j])) {
                        intersecao.add(splitB[i]);
                        break;
                    }
                }
            }
        }

        return intersecao.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String frase1 = bufferedReader.readLine();

        String frase2 = bufferedReader.readLine();

        String result = Result.conjCalculator(frase1, frase2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

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

class Pilha<T>{
    //Implemente os métodos da pilha para manipular o método
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
        String s = "" + top();
        No<T> p = topo.getProx();
        while (p != null) {
            s += (" - " + p.getInfo());
            p = p.getProx();
        }
        return s;
    }
}


public class Solution {
    public static void numPrim(int n){
        if (n >= 2) {
            Pilha<Integer> pilha = new Pilha<Integer>();
            for (int i = n; i >= 2; i--) {
                int cont = 0;
                for (int j = i; j >= 2; j--) {
                    if (i % j == 0)
                        cont++;
                }
                if (cont == 1)
                    pilha.push(i);
            }
            pilha.print();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        numPrim(n);

        bufferedReader.close();
    }
}
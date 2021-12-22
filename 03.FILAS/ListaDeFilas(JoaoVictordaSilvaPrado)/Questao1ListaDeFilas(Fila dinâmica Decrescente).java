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
    
    public void inverteFila() {
        if(qtd == 0){
            return;  
        } 
        Fila<T> fInversa = new Fila<T>();
        int tam = qtd;
        for(int i = tam; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(j == (i-1)) {
                    fInversa.enqueue(dequeue());
                }else {
                    enqueue(dequeue());
                }
            }         
        }
        for(int i = 0; i < tam; i++){
            enqueue(fInversa.dequeue());
        }  
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine().trim());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        int c = Integer.parseInt(bufferedReader.readLine().trim());

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int e = Integer.parseInt(bufferedReader.readLine().trim());

        int f = Integer.parseInt(bufferedReader.readLine().trim());

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int i = Integer.parseInt(bufferedReader.readLine().trim());

        int j = Integer.parseInt(bufferedReader.readLine().trim());

        Fila<Integer> fila1 = new Fila<Integer>();
    fila1.enqueue(a);
    fila1.enqueue(b);
    fila1.enqueue(c);
    fila1.enqueue(d);
    fila1.enqueue(e);
    fila1.enqueue(f);
    fila1.enqueue(g);
    fila1.enqueue(h);
    fila1.enqueue(i);
    fila1.enqueue(j);
    fila1.inverteFila();
    fila1.imprimeFila();

        bufferedReader.close();
    }
}   

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.io.IOException;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class No<T>{
    T info;
    No<T> prox;

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

class Fila<T>{
    No<T> inicio, fim;
    int qtd;
    
    
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
        No<T> res = inicio;
        if (inicio != null) {
            res.setInfo(inicio.getInfo());
            inicio = inicio.getProx();
            if (inicio == null) {
                fim = null;
            }
            qtd--;
        }
        return res.getInfo();
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

    public void imprimeFila() {
        System.out.println(this.toString());
    }   
    
    public Boolean isEmpty(){
        return (qtd==0);
    }

    public int getSize(){
        return qtd;
    }

    public T top() {
        if(qtd==0){
            return null;
        }
        return inicio.getInfo();
    }
}

public class Solution {
    
    public static Fila<Character> inverterFila(Fila<Character> fila) {
        if(fila.getSize() == 0){
            return null;
        }
        Fila<Character> filaDeRetorno = new Fila<Character>();
        int tamanhoInicial = fila.getSize();
        for(int i = tamanhoInicial; i > 0; i--) {
            
            for(int j = 0; j < i; j++) {
                if(j == i-1) {
                    filaDeRetorno.enqueue(fila.dequeue());
                }else {
                    fila.enqueue(fila.dequeue());
                }
            }         
        }
        return filaDeRetorno;
    }
    
    public static void preenche(Fila<Character> fila1, Fila<Character> fila2, Fila<Character> filaFinal) {
        int qtdF1 = fila1.getSize();
        int qtdF2 = fila2.getSize();
        
        Fila<Character> inversa1 = inverterFila(fila1);
        Fila<Character> inversa2 = inverterFila(fila2);

        int qtdFinal = qtdF1 + qtdF2;

        for (int i = 0; i < qtdFinal; i++) {
                if(inversa1.top() == null){
                     filaFinal.enqueue(inversa2.dequeue());
                }else if (inversa2.top() == null){
                    filaFinal.enqueue(inversa1.dequeue());
                }else if (inversa1.top().compareTo(inversa2.top()) > 0) {
                    filaFinal.enqueue(inversa2.dequeue());
                } else {
                    filaFinal.enqueue(inversa1.dequeue());
                }
        }

    
}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char a = bufferedReader.readLine().charAt(0);

        char b = bufferedReader.readLine().charAt(0);

        char c = bufferedReader.readLine().charAt(0);

        char d = bufferedReader.readLine().charAt(0);

        char e = bufferedReader.readLine().charAt(0);

        char f = bufferedReader.readLine().charAt(0);

        char g = bufferedReader.readLine().charAt(0);

        char h = bufferedReader.readLine().charAt(0);

        char i = bufferedReader.readLine().charAt(0);

        char j = bufferedReader.readLine().charAt(0);


    Fila<Character> fila1 = new Fila<Character>();
    Fila<Character> fila2 = new Fila<Character>();
    Fila<Character> filaFinal = new Fila<Character>();

    fila1.enqueue(a);
    fila1.enqueue(b);
    fila1.enqueue(c);
    fila1.enqueue(d);
    fila1.enqueue(e);
    fila2.enqueue(f);
    fila2.enqueue(g);
    fila2.enqueue(h);
    fila2.enqueue(i);
    fila2.enqueue(j);


        preenche(fila1, fila2, filaFinal);
    filaFinal.imprimeFila();

        bufferedReader.close();
    }
}
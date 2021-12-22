import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

interface TADFila<T>{
    public void inserir(T e);

    public T remover();

    public void imprimir();

    public int size();

    public boolean isEmpty();
}
class NoFila<T>{   
    T info;
    NoFila<T> prox;

    public NoFila(T e) {
        info = e;
    }
}
interface TADPilha<T>{
    public void push(T e);

    public T pop();

    public T top();

    public int size();

    public void imprime();

    public boolean isEmpty();

    public boolean isFull();
}
   
class FilaDinamica<T> implements TADFila<T>{
    private NoFila<T> inicio, fim;
    private int qtd;

    @Override
    public void inserir(T e) {
        NoFila novo = new NoFila(e);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
        qtd++;
    }

    @Override
    public T remover() {
        T resp = null;
        if (inicio != null) {
            resp = inicio.info;
            inicio = inicio.prox;
            if (inicio == null) {
                fim = null;
            }
            qtd--;
        }
        return resp;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public String toString() {
        String s = "[";
        NoFila p = inicio;
        while (p != null) {
            s += (p.prox == null ? p.info + "]" : (p.info + ","));
            p = p.prox;
        }
        return s;
    }

    public int size() {
        return qtd;
    }

    public boolean isEmpty() {
        return (qtd == 0);
    }
    
}

class PilhaDinamica<T> implements TADPilha<T>{
    private FilaDinamica<T> fila;

    public PilhaDinamica() {
        fila = new FilaDinamica<T>();
    }

    @Override
    public void push(T e) {
        String f = e.toString();
        f = f.substring(1, f.length() - 1);
        String[] g = f.split(",");
        for (int i = 0; i < g.length; i++) {
            fila.inserir((T)g[i]);
        }
    }

    @Override
    public T pop() {
        FilaDinamica<T> fAux = new FilaDinamica<T>();
        while (fila.size() > 1) {
            fAux.inserir(fila.remover());
        }
        T infoAux = fila.remover();
        while (fAux.size() > 0) {
            fila.inserir(fAux.remover());
        }

        return infoAux;
    }

    @Override
    public T top() {
        FilaDinamica<T> fAux = new FilaDinamica<T>();
        while (fila.size() > 1) {
            fAux.inserir(fila.remover());
        }
        T infoAux = fila.remover();
        while (fAux.size() > 0) {
            fila.inserir(fAux.remover());
        }
        fila.inserir(infoAux);

        return infoAux;
    }
    
    public String primeiro(){
        if (!fila.isEmpty()) {
            FilaDinamica<T> fAux = new FilaDinamica<T>();
            T infoAux = fila.remover();
            fAux.inserir(infoAux);
            while (fila.size() > 0) {
                fAux.inserir(fila.remover());
            }
            while (fAux.size() > 0) {
                fila.inserir(fAux.remover());
            }

            return "[" + infoAux + "]";
        } else {
            return "[]";
        }
    }


    @Override
    public int size() {
        return fila.size();
    }

    @Override
    public void imprime() {
        fila.imprimir();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }
    
    public boolean isFull() {
        return false;
    }
}
    


public class Solution {
          
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new                 InputStreamReader(System.in));
        
        String s = bufferedReader.readLine();
        
        PilhaDinamica p = new PilhaDinamica();
        p.push(s);
        p.pop();
        p.pop();
        p.pop();
        p.push(p.primeiro());
        p.imprime();
        
        bufferedReader.close();
    }
    
}
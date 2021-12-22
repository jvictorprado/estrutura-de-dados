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

class NoLista<T> {
    T info;
    NoLista<T> prox;

    public NoLista(T e) {
        info = e;
    }
}

class Lista<T> {
    NoLista<T> inicio, fim;
    int qtd;

    public void adicionar(T e) {
        NoLista<T> novo = new NoLista<T>(e);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.prox = inicio;
            inicio = novo;
        }
        qtd++;
    }

    
    public void remove(T e) {
        if (inicio != null) {
            if (inicio.info.equals(e)) {
                inicio = inicio.prox;
                if (inicio == null) {
                    fim = null;
                }
                qtd--;
            }else {
                NoLista<T> p = inicio;
                while (p.prox != null) {
                    if (p.prox.info.equals(e)) {
                        p.prox = p.prox.prox;
                        if (p.prox == null) {
                            fim = p;
                        }
                        qtd--;
                        break;
                    } else {
                        p = p.prox;
                    }
                }
            }
        }
    }

    public String toString() {
        String s = "";
        NoLista<T> p = inicio;
        while (p != null) {
            s += (p.info + " ");
            p = p.prox;
        }
        return s;
    }

}
public class Solution {
    public static void removerDivisor(Lista<Integer> a, int divisor){
        NoLista<Integer> p = a.inicio;
        while(p.prox!=null){
            if(p.info % divisor == 0){
                a.remove(p.info);
            }
            p = p.prox;
        }
        if((a.fim.info)%divisor==0){
            a.remove(a.fim.info);
        }
        System.out.println(a);
    }
           
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine().trim());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        int c = Integer.parseInt(bufferedReader.readLine().trim());

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int e = Integer.parseInt(bufferedReader.readLine().trim());

        int f = Integer.parseInt(bufferedReader.readLine().trim());

        int divisor = Integer.parseInt(bufferedReader.readLine().trim());
        
        Lista<Integer> lista = new Lista<Integer>();
        
        lista.adicionar(a);
        lista.adicionar(b);
        lista.adicionar(c);
        lista.adicionar(d);
        lista.adicionar(e);
        lista.adicionar(f);
        

        Solution.removerDivisor(lista, divisor);

        bufferedReader.close();
    }
}

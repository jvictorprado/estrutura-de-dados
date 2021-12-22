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
    No<T> prox;

    public No(T e) {
        info = e;
    }
}

class Lista<T>{
    private No<T> inicio, fim;
    private int qtd;

    public void adicionar(T e) {
        No<T> nova = new No<T>(e);
        if (inicio == null) {
            inicio = nova;
            fim = nova;
        } else {
            fim.prox = nova;
            fim = nova;
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
            } else {
                No<T> p = inicio;
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

    public void print(){
        System.out.println(this);
    }

    public String toString() {
        String s = "";
        No<T> p = inicio;
        while (p != null) {
            s += (p.info+ " ");
            p = p.prox;
        }
        return s;
    }

    public Integer concatenaElem(){
        String s = "";
        No<T> p = inicio;
        while (p != null) {
            s += ("" + p.info);
            p = p.prox;
        }
        String s2 = "";
        for (int i = 1; i < s.length(); i++) {
            s2 += s.charAt(s.length() - i);
        }
        s2 += s.charAt(0);
        
        return Integer.parseInt(s2);
    }
}



class Result {

    /*
     * Complete the 'somaListas' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY lista1
     *  2. INTEGER_ARRAY lista2
     */

   public static Lista<Integer> somaListas(Lista<Integer> lista1, Lista<Integer> lista2) {
        int soma = lista1.concatenaElem() + lista2.concatenaElem();
        String s = ""+soma;
        Lista<Integer> c = new Lista<Integer>();
               
       String s2 = "";
        for (int i = 1; i < s.length(); i++) {
            s2 += s.charAt(s.length() - i);
        }
        s2 += s.charAt(0); 
       
        for (int i = 0; i < s2.length(); i++) {
            int inteiro = Integer.parseInt(String.valueOf(s2.charAt(i)));
            c.adicionar(inteiro);
        }
            
        //c.add(Integer.parseInt(s2));
        //c.add(s2);
        return c;
        //return s2;
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

        
        Lista<Integer> lista1 = new Lista<Integer>();
        Lista<Integer> lista2 = new Lista<Integer>();
        //adicionar os valores nas listas
        lista1.adicionar(a);
        lista1.adicionar(b);
        lista1.adicionar(c);
        lista1.adicionar(d);
        lista1.adicionar(e);
        lista2.adicionar(f);
        lista2.adicionar(g);
        lista2.adicionar(h);
        lista2.adicionar(i);
        lista2.adicionar(j);
        
        //printar lista resultante do metodo somaLista
        Lista<Integer> listaFinal = Result.somaListas(lista1,lista2);
        listaFinal.print();

        bufferedReader.close();
    }
}
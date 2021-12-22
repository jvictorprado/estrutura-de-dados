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

class ListaEstatica {

    private int[] dados;
    private int qtd;

    public ListaEstatica() {
        dados = new int[10];
        qtd = 0;
    }

    public void add(int novo) {
        if ((dados.length > qtd)&&(novo>0)) {
            dados[qtd] = novo;
            qtd++;
        } else {
            throw new RuntimeException("Não foi possível adicionar o elemento!");
        }
    }

    public int indexOf(int e) {
        int p = -1;
        for (int i = 0; i < qtd; i++) {
            if (dados[i] == e) {
                p = i;
                break;
            }
        }
        return p;
    }

    public void remove(int e) {
        int p = indexOf(e);
        if (p != -1) {
            while (p < qtd - 1) {
                dados[p] = dados[p + 1];
                p++;
            }
            dados[p] = 0;
            qtd--;
        }
    }

    public boolean search(int e) {
        int p = indexOf(e);
        return (p != -1);
    }

    public void print() {
        for (int i = 0; i < qtd; i++) {
            System.out.print(dados[i]+" ");
        }
        System.out.println("");
    }

    public ListaEstatica inverte() {
        ListaEstatica invertida = new ListaEstatica();
        for (int i = 1; i < qtd + 1; i++) {
            invertida.add(this.dados[qtd - i]);
        }
        return invertida;
    }

    public ListaEstatica listaNova() {
            
            ListaEstatica invertida = new ListaEstatica();
            invertida = this.inverte();
            ListaEstatica aux = new ListaEstatica();

            if(qtd<=0){
                return this;
            }    
        
            for (int i = 0; i < invertida.qtd; i++) {
                if (!aux.search(invertida.dados[i])) {
                    aux.add(invertida.dados[i]);
                }
            }
                     
            return aux;
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
        
        ListaEstatica lista = new ListaEstatica();
        //adicionar os valores na lista
        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);
        lista.add(g);
        
        //printar nova lista
        lista.listaNova().print();

        bufferedReader.close();
    }
}
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class ListaEstatica<Integer>{
    private int[] dados;
    private int qtd;

    public ListaEstatica() {
        dados = new int[100];
        qtd = 0;
    }

    public void add(int novo) {
        if (dados.length > qtd) {
            dados[qtd] = novo;
            qtd++;
        } else {
            throw new RuntimeException("Não há espaço na lista!");
        }
    }

    public int indexOf(int e) {
        int p = -1;
        for (int i = 0; i < qtd; i++) {
            if (dados[i]==e) {
                p = i;
                break;
            }
        }
        return p;
    }

    public int nEzimo(int n) {
        int resp = 0;
        for (int i = 0; i < qtd; i++) {
            if (i == n) {
                resp = dados[i];
                break;
            }
        }
        return resp;
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
        return (p != -1); //se não existe retorna -1.
    }

    public void print() {
        for (int i = 0; i < qtd; i++) {
            System.out.print("->" + dados[i]);
        }
        System.out.println("");
    }

    public int[] getDados() {
        return dados;
    }

    public void setDados(int[] dados) {
        this.dados = dados;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ListaEstatica insertionSort() {
        int current, n = -1;
        for (int i = 1; i < this.getQtd(); i++) {
            current = this.nEzimo(i);
            n = i - 1;
            while (n >= 0 && this.nEzimo(n) > current) {
                this.dados[n + 1] = this.nEzimo(n);
                n -= 1;
            }
            this.dados[n + 1] = current;
        }
        return this;
    }
}



class Result {

    /*
     * Complete the 'question' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING lista as parameter.
     */

    public static int buscaBinariaIt(ListaEstatica<Integer> A, int x) {
        int inicio = 0;
        int fim = A.getQtd() - 1;
        int meio = (inicio + fim) / 2;

        while (x != A.nEzimo(meio)) {
            if (A.nEzimo(meio) < x) {
                inicio = meio + 1;
                meio = (fim + inicio) / 2;
            } else {
                fim = meio - 1;
                meio = (fim + inicio) / 2;
            }
            if (meio < 0 || meio > A.getQtd() - 1) {
                meio = -1;
                break;
            }
        }
        return meio;
    }

    public static String question(String lista) {
        String[] s = lista.split(" ");
        ListaEstatica<Integer> aux = new ListaEstatica<Integer>();
        for(int i = 0; i< s.length;i++){
            aux.add(Integer.parseInt(s[i]));
        }
        int primeiro = aux.nEzimo(0);
        int ultimo = aux.nEzimo(aux.getQtd()-1);
        aux.insertionSort();
        String s1 = buscaBinariaIt(aux,primeiro) + "";
        String s2 = buscaBinariaIt(aux,ultimo) + "";
        return s1 + " " + s2;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String lista = bufferedReader.readLine();

        String result = Result.question(lista);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

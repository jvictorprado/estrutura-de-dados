import java.io.*;
import java.util.*;

class Fila<T> {
    private No<T> inicio, fim;
    private int qtd;

    public void enqueue(T e) {
        No<T> novo = new No<T>(e);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
        qtd++;
    }

    public T dequeue() {
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

    public void print() {
        System.out.println(this.toString());
    }

    public String toString() {
        String s = "";
        No<T> p = inicio;
        while (p != null) {
            s += (p.info + "->");
            p = p.prox;
        }
        return s;
    }

    public Boolean isEmpty() {
        return (qtd == 0);
    }

    public T top() {
        return inicio.info;
    }

    public int size() {
        return qtd;
    }

    public No<T> getFim() {
        return fim;
    }

    public void setFim(No<T> fim) {
        this.fim = fim;
    }

}

class No<T> {
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

class Questoes<T> {
    public Fila<T> add(Fila<T> fila, T e, int k) {
        int tam = fila.size();
        Fila<T> aux = new Fila<T>();
        for (int i = 0; i < tam; i++) {
            T infoAux = fila.dequeue();
            aux.enqueue(infoAux);
            fila.enqueue(infoAux);
        }

        Fila<T> nova = new Fila<T>();
        if ((k >= 0) && (k <= (tam - 1))) {
            for (int i = 0; i < k; i++) {
                nova.enqueue(aux.dequeue());
            }
            nova.enqueue(e);
            for (int i = k + 1; i < tam + 1; i++) {
                nova.enqueue(aux.dequeue());
            }
        } else if (k < 0) {
            return add(fila, e, 0);
        } else if (k > (fila.size() - 1)) {
            for (int i = 0; i < tam; i++) {
                nova.enqueue(aux.dequeue());
            }
            nova.enqueue(e);
        }
        return nova;
    }

    public Fila<T> remove(Fila<T> fila, int k) {
        int tam = fila.size();
        Fila<T> aux = new Fila<T>();
        for (int i = 0; i < tam; i++) {
            T infoAux = fila.dequeue();
            aux.enqueue(infoAux);
            fila.enqueue(infoAux);
        }

        Fila<T> nova = new Fila<T>();
        if (k == 0) {
            aux.dequeue();
            for (int i = 0; i < tam - 1; i++) {
                nova.enqueue(aux.dequeue());
            }
        } else if ((k > 0) && (k < (tam - 1))) {
            for (int i = 0; i < k; i++) {
                nova.enqueue(aux.dequeue());
            }
            aux.dequeue();
            for (int i = k + 1; i < tam; i++) {
                nova.enqueue(aux.dequeue());
            }
        } else if (k == (tam - 1)) {
            for (int i = 0; i < tam - 1; i++) {
                nova.enqueue(aux.dequeue());
            }
        } else {
            nova = fila;
        }
        return nova;
    }

    public String toString(Fila<T> fila) {
        String s = "";
        int tam = fila.size();
        Fila<T> aux = new Fila<T>();
        for (int i = 0; i < tam; i++) {
            T infoAux = fila.dequeue();
            s+= infoAux +"->";
            aux.enqueue(infoAux);
            fila.enqueue(infoAux);
        }
        return s;
    }
}

public class Solution {
    public static void main(String[] args) {
        Questoes<Integer> q = new Questoes<Integer>();
        Fila<Integer> f = new Fila<Integer>();
        Fila<Integer> f2 = new Fila<Integer>();

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().trim().split(" ");
        String[] input2 = scan.nextLine().trim().split(" ");
        String[] input3 = scan.nextLine().trim().split(" ");
        String[] input4 = scan.nextLine().trim().split(" ");
        for (int i = 0; i < input.length; i++)
            f2.enqueue(Integer.parseInt(input[i]));
        for (int i = 0; i < input2.length; i++)
            if (i == 0)
                f = q.add(f2, Integer.parseInt(input2[i]), Integer.parseInt(input3[i]));
            else
                f = q.add(f, Integer.parseInt(input2[i]), Integer.parseInt(input3[i]));

        System.out.println(q.toString(f));
        System.out.println(q.toString(f2));

        for (int i = 0; i < input4.length; i++)
            f = q.remove(f, Integer.parseInt(input4[i]));

        System.out.println(q.toString(f));
        if (scan != null)
            scan.close();
    }
}
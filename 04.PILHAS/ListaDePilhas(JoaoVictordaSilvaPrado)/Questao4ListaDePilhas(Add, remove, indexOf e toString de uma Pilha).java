import java.io.*;
import java.util.*;

class Pilha<T> {
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
        String s = "";
        No<T> p = topo;
        while (p != null) {
            s += (p.getInfo() + "-> ");
            p = p.getProx();
        }
        return s;
    }
}

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

class Questoes<T> {
    public Pilha<T> add(Pilha<T> pilha, T e, int k) {
        int ind = pilha.size();
        Pilha<T> aux = new Pilha<T>();
        Pilha<T> nova = new Pilha<T>();

        while(pilha.size()>0) {
            aux.push(pilha.pop());
        }
        while(aux.size()>0){
            T infoAux = aux.top();
            pilha.push(infoAux);
            nova.push(infoAux);
            aux.pop();
        }

        if (k <= 0) {
            nova.push(e);
        } else if (k >= (nova.size())) {
            for (int i = 0; i < ind; i++) {
                aux.push(nova.pop());
            }
            nova.push(e);
            while (aux.size() > 0) {
                nova.push(aux.pop());
            }
        } else {
            for (int i = 0; i < k; i++) {
                aux.push(nova.pop());
            }
            nova.push(e);
            while (aux.size() > 0) {
                nova.push(aux.pop());
            }
        }
        return nova;
    }

    public Pilha<T> removePorIndex(Pilha<T> pilha, int k) {
        int ind = pilha.size();
        Pilha<T> aux = new Pilha<T>();
        Pilha<T> nova = new Pilha<T>();

        while(pilha.size()>0) {
            aux.push(pilha.pop());
        }
        while(aux.size()>0){
            T infoAux = aux.top();
            pilha.push(infoAux);
            nova.push(infoAux);
            aux.pop();
        }

        if (k == 0) {
            nova.pop();
        } else if ((k < nova.size()) && (k > 0)) {
            for (int i = 0; i < k; i++) {
                aux.push(nova.pop());
            }
            nova.pop();
            while (aux.size() > 0) {
                nova.push(aux.pop());
            }
        }
        return nova;
    }

    public Pilha<T> removePorValor(Pilha<T> pilha, T e) {
        int ind = pilha.size();
        Pilha<T> aux = new Pilha<T>();
        Pilha<T> nova = new Pilha<T>();

        while(pilha.size()>0) {
            aux.push(pilha.pop());
        }
        while(aux.size()>0){
            T infoAux = aux.top();
            pilha.push(infoAux);
            nova.push(infoAux);
            aux.pop();
        }

        while (nova.size() > 0) {
            if (nova.top() == e) {
                nova.pop();
            } else {
                aux.push(nova.pop());
            }
        }
        while (aux.size() > 0) {
            nova.push(aux.pop());
        }
        return nova;
    }

    public int indexOf(Pilha<T> pilha, T e) {
        int ind = pilha.size();
        Pilha<T> aux = new Pilha<T>();
        Pilha<T> nova = new Pilha<T>();

        while(pilha.size()>0) {
            aux.push(pilha.pop());
        }
        while(aux.size()>0){
            T infoAux = aux.top();
            pilha.push(infoAux);
            nova.push(infoAux);
            aux.pop();
        }
        
        int p = -1;
        for (int i = 0; i < ind; i++) {
            if (nova.top() == e) {
                nova.pop();
                p = i;
                break;
            } else {
                aux.push(nova.pop());
            }
        }
        while (aux.size() > 0) {
            nova.push(aux.pop());
        }

        return p;
    }

    public String toString(Pilha<T> pilha) {
        String s = "";
        int tam = pilha.size();
        Pilha<T> aux = new Pilha<T>();
        for (int i = 0; i < tam; i++) {
            T infoAux = pilha.pop();
            s += infoAux + "->";
            aux.push(infoAux);
        }
        while (aux.size() > 0) {
            pilha.push(aux.pop());
        }
        return s;
    }

}

public class Solution {
    public static void main(String[] args){
        Questoes<Integer> q = new Questoes<Integer>();
        Pilha<Integer> p2 = new Pilha<Integer>();
        Pilha<Integer> p1 = new Pilha<Integer>();

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().trim().split(" ");
        String[] input2 = scan.nextLine().trim().split(" ");
        String[] input3 = scan.nextLine().trim().split(" ");
        String[] input4 = scan.nextLine().trim().split(" ");
        String[] input5 = scan.nextLine().trim().split(" ");
        String[] input6 = scan.nextLine().trim().split(" ");

        for (int i = 0; i < input.length; i++)
            p1.push(Integer.parseInt(input[i]));
        for (int i = 0; i < input2.length; i++)
            if (i == 0)
                p2 = q.add(p1, Integer.parseInt(input2[i]), Integer.parseInt(input3[i]));
            else
                p2 = q.add(p2, Integer.parseInt(input2[i]), Integer.parseInt(input3[i]));

        System.out.println(q.toString(p2));

        for (int i = 0; i < input4.length; i++) {
            if (i == 0)
                p1 = q.removePorIndex(p2, Integer.parseInt(input4[i]));
            else
                p1 = q.removePorIndex(p1, Integer.parseInt(input4[i]));
        }
        System.out.println(q.toString(p1));
        System.out.println(q.indexOf(p2, Integer.parseInt(input5[0])));
        for (int i = 0; i < input6.length; i++)
            if (i == 0)
                p1 = q.removePorValor(p2, Integer.parseInt(input6[i]));
            else
                p1 = q.removePorValor(p1, Integer.parseInt(input6[i]));
        System.out.println(q.toString(p1));
        if (scan != null)
            scan.close();
    }
}
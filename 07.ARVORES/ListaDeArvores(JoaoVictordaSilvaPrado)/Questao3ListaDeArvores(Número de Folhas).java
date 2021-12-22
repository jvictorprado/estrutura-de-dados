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

class FilaDinamica<T>{
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
            s += (" -> " + p.info);
            p = p.prox;
        }
        return s;
    }
}

class BinaryNode<T extends Comparable> {
    private T info;
    private BinaryNode<T> left, right;

    public BinaryNode(T novo) {
        info = novo;
    }

    public int compare(T outroNo) {
        return info.compareTo(outroNo);
    }
    
    public boolean checaFolha(){
        if(left == null) return right == null;
        return false;
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}

class ArvoreBin <T extends Comparable>{
    private BinaryNode<T> raiz;
    
    public void add(T novo){
        raiz = insert(raiz, novo);
    }
    
    public BinaryNode<T> insert(BinaryNode<T> no, T novo){
        if(raiz!= null){
            FilaDinamica<BinaryNode> filaAux = new FilaDinamica<BinaryNode>();
            filaAux.enqueue(raiz);
            
            while (true) {
                no = filaAux.dequeue();
                if (no.getLeft() == null) {
                    no.setLeft(new BinaryNode(novo));
                    return raiz;
                }
                if (no.getRight() == null) {
                    no.setRight(new BinaryNode(novo));
                    return raiz;
                }
                filaAux.enqueue(no.getLeft());
                filaAux.enqueue(no.getRight());
            }
        }else{
            raiz = new BinaryNode<T>(novo);
            return raiz;
        }
    }
    
    public BinaryNode<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(BinaryNode<T> raiz) {
        this.raiz = raiz;
    }
}

class Result {

    public static int ContaFolha(String a,ArvoreBin<String>arvore) {
        String[] aux = a.split(",");
        for(int i = 0; i<aux.length; i++)
            arvore.add(aux[i]);
        
        return numFolhas(arvore.getRaiz());
    }
    
    public static int numFolhas(BinaryNode<String> e){
        if(e != null) 
            return (e.checaFolha()) ? 1 : numFolhas(e.getLeft()) + numFolhas(e.getRight());           
        
        return 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();
        ArvoreBin<String> b = new ArvoreBin<String>();
        int result = Result.ContaFolha(a,b);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
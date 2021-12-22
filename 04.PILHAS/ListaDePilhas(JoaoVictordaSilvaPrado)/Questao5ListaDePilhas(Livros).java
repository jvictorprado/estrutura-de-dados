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

class Pilha{
    private NoPilha topo;
    private int qtd;

    public void push(Livros e) {
        NoPilha novo = new NoPilha(e);
        novo.setProx(topo);
        topo = novo;
        qtd++;
    }

    public Livros pop() {
        Livros r = null;
        if (topo != null) {
            r = topo.getLivro();
            topo = topo.getProx();
            qtd--;
        } 
        return r;
    }

    public Livros top() {
        Livros r = null;
        if (topo != null) {
            r = topo.getLivro();
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
        System.out.println("");
        String s = "";
        NoPilha p = topo;
        while (p != null) {
            s += (p.getLivro().getNome() + " Ano: " + p.getLivro().getAno() + "\n");
            p = p.getProx();
        }
        return s;
    }
}

class NoPilha{    
    private Livros livro;
    private NoPilha prox;

    public NoPilha(Livros e) {
        livro = e;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public NoPilha getProx() {
        return prox;
    }

    public void setProx(NoPilha prox) {
        this.prox = prox;
    }
}

class Livros{
    private String nome;
    private int ano;

    public Livros(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }
    
    public boolean igual(Livros livro) {
        if ((this.getNome().equals(livro.getNome())) && (this.getAno() == livro.getAno())) {
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}


public class Solution {
    
    public static void RemoverLivro(Pilha pilha, Livros livro){
        int cont = pilha.size();
        Pilha aux = new Pilha();
        while (pilha.size()>0){
            if(pilha.top().igual(livro)){
                pilha.pop();
            }else{
                aux.push(pilha.pop());
            }
        }
        while (aux.size()>0){
            pilha.push(aux.pop());
        }
        if(pilha.size()==cont){
            System.out.println("Este Livro nao esta aqui");
        }
    }
    
    public static void imprimir(Pilha pilha){
        System.out.println(pilha.toString());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        String c = bufferedReader.readLine();

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        String e = bufferedReader.readLine();

        int f = Integer.parseInt(bufferedReader.readLine().trim());

        String g = bufferedReader.readLine();

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        Pilha pilha = new Pilha();
        Livros livro1 = new Livros(a,b);
        Livros livro2 = new Livros(c,d);
        Livros livro3 = new Livros(e,f);
        pilha.push(livro1);
        pilha.push(livro2);
        pilha.push(livro3);
        System.out.println("Pilha Antes");
        Solution.imprimir(pilha);
        Livros remove = new Livros(g,h);
        Solution.RemoverLivro(pilha,remove);
        System.out.println("Pilha Agora");
        Solution.imprimir(pilha);
        bufferedReader.close();
    }
}
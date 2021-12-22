import java.io.*;
import java.util.*;

class ArvoreBinaria<T extends Comparable>{
    private No<T> raiz;
    
    public void add(T novo) {
        No<T> novoNo = new No<T>(novo);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            No<T> p = raiz;
            int c;
            while ((c = p.compare(novo)) != 0) {
                if (c < 0) {
                    if (p.right != null) {
                        p = p.right;
                    } else {
                        p.right = novoNo;
                        break;
                    }
                } else {
                    if (p.left != null) {
                        p = p.left;
                    } else {
                        p.left = novoNo;
                        break;
                    }
                }
            }
        }
    }
    
    public void inverterArvore() {
        inverte(this.raiz);
    }
    
    public void percursoEmOrdem() {
        percurso(raiz);
    }
    
    public void inverte(No<T> e){
        if(e != null){
            troca(e);        
            inverte(e.right);
            inverte(e.left);
        }else{
            return;
        }
    }
    
    public void troca(No<T> e){
        No<T> aux;
        if(e != null){
            aux = e.right;
            e.right = e.left;
            e.left = aux;
        }else{
            return;
        }
    }
    
    public void percurso(No<T> e){
        if(e != null){
            percurso(e.left);
            System.out.print(e.info+" ");
            percurso(e.right);
        }else{
            return;
        }
    }
    
}

class No<T extends Comparable> {
    T info;
    No<T> left, right;

    public No(T novo) {
        info = novo;
    }

    public int compare(T outroNo) {
        return info.compareTo(outroNo);
    }

}


public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
        String[] input = scan.nextLine().split(" ");
        for (int i = 0; i < input.length; i++)
            arvore.add(Integer.parseInt(input[i]));
        arvore.percursoEmOrdem();
        arvore.inverterArvore();
        System.out.println();
        arvore.percursoEmOrdem();
        if(scan != null)
            scan.close();
    }
}
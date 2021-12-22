import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class No {
    String info;
    No next;

    public No(String e) {
        info = e;
    }
}

class ListaDinamica {

    private No inicio, fim;
    private int qtd;

    public ListaDinamica() {
        inicio = fim = null;
        qtd = 0;
    }

    public void add(String e) {
        No nova = new No(e);
        if (inicio == null) {
            inicio = nova;
            fim = nova;
        } else {
            fim.next = nova;
            fim = nova;
        }
        qtd++;
    }

    public void remove(String e) {
        if (inicio != null) {
            if (inicio.info.equals(e)) {
                inicio = inicio.next;
                if (inicio == null) {
                    fim = null;
                }
                qtd--;
            } else {
                No p = inicio;
                while (p.next != null) {
                    if (p.next.info.equals(e)) {
                        p.next = p.next.next;
                        if (p.next == null) {
                            fim = p;
                        }
                        qtd--;
                        break;
                    } else {
                        p = p.next;
                    }
                }
            }
        }
    }


    public boolean search(String e) {
        No p = inicio;
        while (p != null) {
            if (p.info.equals(e)) {
                return true;
            } else {
                p = p.next;
            }
        }
        return false;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        String s = "";
        No p = inicio;
        while (p != null) {
            s += (" -> " + p.info);
            p = p.next;
        }
        return s;
    }


    public boolean palindromo(String s) {
        ListaDinamica l1 = new ListaDinamica();
        ListaDinamica aux = new ListaDinamica();

        s = s.toLowerCase();
        s = s.replaceAll("\\s+", "");
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        for (int i = 0; i < s.length(); i++) {
            l1.add(s.charAt(i) + "");
        }
        for (int i = 1; i < s.length(); i++) {
            aux.add(s.charAt(s.length() - i) + "");
        }
        aux.add(s.charAt(s.length() - 1) + "");

        int j = 0;
        for (int i = 0; i < l1.qtd; i++){
            if(l1.inicio.info.equals(aux.inicio.info)) {
                j++;
            }
            l1.inicio = l1.inicio.next;
            aux.inicio = aux.inicio.next;
        }
        if((j)==l1.qtd){
            return true;
        }
        return false;

    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String s = bufferedReader.readLine();
        
        ListaDinamica resultado = new ListaDinamica();
       
        System.out.println(resultado.palindromo(s));
        
        bufferedReader.close();
    }
}
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

class No {
    private int info;
    private No prox;

    public No(int e) {
        info = e;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}

class LinkedListQueue {
    private No inicio, fim;
    private int qtd, qtdMax;

    public LinkedListQueue() {
        this.qtdMax = 5;
    }

    
    public int remove() {
        No resp = null;
        if (inicio != null) {
            resp = inicio;
            inicio = inicio.getProx();
            if (inicio == null) {
                fim = null;
            }
            qtd--;
        }
        return resp.getInfo();

    }
    
    public void insert(int e) {
        if (qtd < qtdMax) {
            No novo = new No(e);
            if (inicio == null) {
                inicio = fim = novo;
            } else {
                fim.setProx(novo);
                fim = novo;
            }
            qtd++;
        }
    }

    public String toString() {
        String s = "";
        No p = inicio;
        while (p != null) {
            s += (p.getInfo()+" ");
            p = p.getProx();
        }
        return s;
    }
    
    public void displayList() {
        System.out.print(this.toString());
    }
    
    public int peek() {
        return inicio.getInfo();
    }
    
}

class Result {

    /*
     * Complete the 'parseListElements' function below.
     *
     * The function accepts STRING_ARRAY operationsList as parameter.
     */

    public static void parseListElements(List<String> operationsList) {
    // Write your code here
        LinkedListQueue queue = new LinkedListQueue();
        
        
        for(Iterator<String> iter = operationsList.iterator();
                iter.hasNext();) {
            
            String s = iter.next();
//            match int inside parenthesis
            Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(s);
            Integer elem = null;
            
            if(m.find()) {
                elem = Integer.parseInt(m.group(1));
            }
                    
            String op = s.substring(0, 3);
            
            
            switch (op) {
                case "add":
                    queue.insert(elem);
                    queue.displayList();
                    break;
                
                case "pee":
                    System.out.print(queue.peek());
                    break;
                    
                case "rem":
                    System.out.print(queue.remove());
                    break;
                    
                default:
                    break;
            }
            
            if(iter.hasNext()) {
                System.out.println();
            }
        }
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> operationsList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.parseListElements(operationsList);

        bufferedReader.close();
    }
}

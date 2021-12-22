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


 class BinaryNode<T extends Comparable> {
    T info;
    BinaryNode<T> left, right;

    public BinaryNode(T novo) {
        info = novo;
    }

    public int compare(T outroNo) {
        return info.compareTo(outroNo);
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

class BinaryTree<T extends Comparable>{
    private BinaryNode<T> raiz;


    public void add(T novo) {
        BinaryNode<T> novoNo = new BinaryNode<T>(novo);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            BinaryNode<T> p = raiz;
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
    
    public BinaryNode<T> removeNo(BinaryNode<T> root, T valor) {
        if (root != null) {
            if (root.compare(valor) < 0) {
                root.setRight(removeNo(root.getRight(), valor));
            } else if (root.compare(valor) > 0) {
                root.setLeft(removeNo(root.getLeft(), valor));
            } else {
                if (root.getRight() != null) {
                    T next = menorE(root.getRight());
                    root.setInfo(next);
                    root.setRight(removeNo(root.getRight(), next));                    
                } else {
                    root = root.getLeft();
                }
            }
        }
        return root;
    }

    private T menorE(BinaryNode<T> t) {
        return (t.left != null) ? menorE(t.left) : t.getInfo();
    }
    
    public boolean search(T e) {
        boolean r = false;
        BinaryNode<T> p = raiz;
        while (p != null) {
            int c = p.compare(e);
            if (c == 0) {
                r = true;
                break;
            } else if (c < 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return r;
    }
    
    public BinaryNode<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(BinaryNode<T> raiz) {
        this.raiz = raiz;
    }
    
}


class Result {

    /*
     * Complete the 'resolve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. INTEGER b
     */

    public static int resolve(String a, int b) {
        BinaryTree<Integer> arvore = new BinaryTree<Integer>();
        String[] aux = a.split(" ");
        for(int i = 0; i<aux.length; i++)
            arvore.add(Integer.parseInt(aux[i]));
        
        return getDepth(b, arvore.getRaiz(), 0);
    }
    
    private static int getDepth(int element, BinaryNode<Integer> node, int depth) {
        if (node == null) {
            return 0;
        }
        if(node.compare(element) == 0) {
            return depth;
        }else {      
            return getDepth(element, node.getLeft(), depth + 1) + getDepth(element, node.getRight(), depth + 1);
        }
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.resolve(a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
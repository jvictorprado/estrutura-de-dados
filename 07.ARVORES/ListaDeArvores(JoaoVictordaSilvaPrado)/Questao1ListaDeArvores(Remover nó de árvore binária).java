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

class BinarySearchTreeNode {
    public int data;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;

    BinarySearchTreeNode (int nodeData) {
        this.data = nodeData;
        this.left = null;
        this.right = null;
    } 
    
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
}

class BinarySearchTree {
    public BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insertNode(int nodeData) {
        this.root = this.insertNode(this.root, nodeData);
    }

    private BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int nodeData) {
        if (root == null) {
            root = new BinarySearchTreeNode(nodeData);
        } else {
            if (nodeData <= root.data) {
                root.left = this.insertNode(root.left, nodeData);
            } else {
                root.right = this.insertNode(root.right, nodeData);
            }
        }

        return root;
    }
    public BinarySearchTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode root) {
        this.root = root;
    }
}

class BinarySearchTreePrintHelper {
    public static void printInorder(BinarySearchTreeNode root, String sep, BufferedWriter bufferedWriter) throws IOException {
        if (root == null) {
            return;
        }

        BinarySearchTreePrintHelper.printInorder(root.left, sep, bufferedWriter);

        if (root.left != null) {
            bufferedWriter.write(sep);
        }

        bufferedWriter.write(String.valueOf(root.data));

        if (root.right != null) {
            bufferedWriter.write(sep);
        }

        BinarySearchTreePrintHelper.printInorder(root.right, sep, bufferedWriter);
    }
}

class Result {

    /*
     * Complete the 'removeNo' function below.
     *
     * The function is expected to return an INTEGER_BINARY_SEARCH_TREE.
     * The function accepts following parameters:
     *  1. INTEGER_BINARY_SEARCH_TREE root
     *  2. INTEGER valor
     */

    /*
     * For your reference:
     *
     * BinarySearchTreeNode {
     *     int data;
     *     BinarySearchTreeNode left;
     *     BinarySearchTreeNode right;
     * }
     *
     */

    private static int menorE(BinarySearchTreeNode e) {
        return (e.left != null)? menorE(e.left) : e.getData() ;
    }
    
    public static BinarySearchTreeNode removeNo(BinarySearchTreeNode root, int valor) {
        if (root != null) {
            if (root.getData() < valor) {
                root.setRight(removeNo(root.getRight(), valor));
            } else if (root.getData() > valor) {
                root.setLeft(removeNo(root.getLeft(), valor));
            } else {
                if (root.getRight() != null) {
                    int next = menorE(root.getRight());
                    root.setData(next);
                    root.setRight(removeNo(root.getRight(), next));                    
                } else {
                    root = root.getLeft();
                }
            }
        }
        return root;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valor = Integer.parseInt(bufferedReader.readLine().trim());

        BinarySearchTree tree = new BinarySearchTree();

        int treeCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, treeCount).forEach(i -> {
            try {
                int treeItem = Integer.parseInt(bufferedReader.readLine().trim());

                tree.insertNode(treeItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        BinarySearchTreeNode treeAposRemocao = Result.removeNo(tree.root, valor);

        BinarySearchTreePrintHelper.printInorder(treeAposRemocao, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
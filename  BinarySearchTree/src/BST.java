import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<Element extends Comparable<Element>> {
    private class Node {
        public Element e;
        public Node left, right;

        public Node(Element e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Element e){
        root = add(root, e);
    }

    private Node add(Node node, Element e){
        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    public boolean contains(Element e){
        return contains(root, e);
    }

    private boolean contains(Node node, Element e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if(e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else
            return true;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node != null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrderNoRecursion(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    public Element minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public Element maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    public Element removeMin(){
        Element min = minimum();
        removeMin(root);
        return min;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public Element removeMax(){
        Element min = maximum();
        removeMax(root);
        return min;
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(Element e){
        root = remove(root, e);
    }

    private Node remove(Node node, Element e){
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }

    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private String generateBSTString(Node node, int index, StringBuilder res){
        if (node == null){
            res.append(generateDepthString(index) + "null\n");
            return res.toString();
        }

        res.append(generateDepthString(index) + node.e + "\n");
        generateBSTString(node.left, index + 1, res);
        generateBSTString(node.right, index + 1, res);
        return res.toString();
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++)
            res.append("--");
        return res.toString();
    }

}

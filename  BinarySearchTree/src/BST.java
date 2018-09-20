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


public class Main {

    public static void main(String[] args) {
	    BST<Integer> bst = new BST<>();
	    int[] nums = {5, 3, 6, 8, 4, 2};
	    for (int num: nums)
	        bst.add(num);

        System.out.println(bst);
        System.out.println("\n");

        bst.preOrder();
        System.out.println("\n");

        bst.preOrderNoRecursion();
        System.out.println("\n");

        bst.inOrder();
        System.out.println("\n");

        bst.postOrder();
        System.out.println("\n");

        bst.levelOrder();
        System.out.println("\n");

        System.out.println(bst.maximum());
        System.out.println(bst.minimum());
        System.out.println("\n");

        System.out.println(bst.removeMax());
        System.out.println(bst.removeMin());
        System.out.println("\n");

        System.out.println(bst);
    }
}
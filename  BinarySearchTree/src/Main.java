
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

        bst.inOrder();
        System.out.println("\n");

        bst.postOrder();
        System.out.println("\n");
    }
}
public class Main {

    // remove all Nodes are equals val
    public static Node removeElementsOne(Node head, int val){
        while (head != null && head.e == val){
            Node removeNode = head;
            head = head.next;
            removeNode.next = null;
        }

        if (head == null)
            return head;
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.e == val) {
                Node removeNode = prev.next;
                prev.next = removeNode.next;
                removeNode.next = null;
            }
            else
                prev = prev.next;
        }
        return head;
    }

    public static Node removeElementsTwo(Node head, int val){
        Node dummyHead = new Node();
        dummyHead.next = head;
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e == val) {
                Node removeNode = prev.next;
                prev.next = removeNode.next;
                removeNode = null;
            }
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public static Node removeElementThree(Node head, int val){
        if (head == null)
            return null;
        head.next = removeElementThree(head.next, val);
        return head.e == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] numsOne = {1, 2, 3, 4, 6, 7, 6};
        Node nodeOne = new Node(numsOne);
        System.out.println(nodeOne);
        System.out.println(removeElementsOne(nodeOne, 6));

        int[] numsThree = {1, 2, 3, 4, 6, 7, 6};
        Node nodeThree = new Node(numsThree);
        System.out.println(nodeThree);
        System.out.println(removeElementThree(nodeThree, 6));
    }
}

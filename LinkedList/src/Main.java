import javax.xml.bind.Element;

public class Main {

    public static int sum(int[] arr, int l){
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l +1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i ++){
            linkedList.addFirst(i);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2 );
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr, 0));


    }
}

public class Main {

    public static void main(String[] args) {
        Array arr = new Array( 20);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.set(11, 1);
        System.out.println(arr);

        System.out.println(arr.getCapacity());

        System.out.println(arr.contains(11));

        System.out.println(arr.find(11));

        System.out.println(arr.removeFirst());

        System.out.println(arr.removeLast());

    }
}

public class Main {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        System.out.println(queue.getFront());

        LoopQueue lQueue = new LoopQueue();
        for (int i = 0; i < 11; i ++)
            lQueue.enqueue(i);
        System.out.println(lQueue);

        lQueue.dequeue();
        System.out.println(lQueue);

        System.out.println(lQueue.getFront());
    }
}

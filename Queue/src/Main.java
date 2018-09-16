import java.util.Random;

public class Main {
    public static double performanceTest(Queue<Integer> queue, int operationCount){
        long nowTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operationCount; i ++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < operationCount; i ++)
            queue.dequeue();
        long endTime = System.nanoTime();
        return (endTime - nowTime) / 100000000.0;
    }
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

        int operationCount = 100000;

        ArrayQueue arrayQueue = new ArrayQueue();
        double arrayTime = performanceTest(arrayQueue, operationCount);
        System.out.println("ArrayQueue time is " + arrayTime);

        LoopQueue loopQueue = new LoopQueue();
        double loopTime = performanceTest(loopQueue, operationCount);
        System.out.println("LoopQueue time is " + loopTime);

        LinkedListQueue linkedListQueue = new LinkedListQueue();
        double linkedListTime = performanceTest(linkedListQueue, operationCount);
        System.out.println("LinkedListTime time is " + linkedListTime);

    }
}

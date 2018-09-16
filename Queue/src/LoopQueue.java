public class LoopQueue<Element> implements Queue<Element> {

    private Element[] data;
    private int front, tail;
    private int size;


    public LoopQueue(int capactity){
        data = (Element[]) new Object[capactity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void enqueue(Element e){
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public Element dequeue(){
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue Element from an empty dequeue!");
        Element ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public Element getFront(){
        if (isEmpty())
            throw new IllegalArgumentException("Cannot is empty!");
        return data[front];
    }


    private void resize(int newCapacity){
        Element[] newData = (Element[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i ++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: Size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(',');
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>(5);
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}

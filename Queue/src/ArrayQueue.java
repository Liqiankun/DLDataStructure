import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

public class ArrayQueue<Element> implements Queue<Element> {

    private Array<Element> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void enqueue(Element e){
        array.addLast(e);
    }

    @Override
    public Element dequeue(){
        return array.removeFirst();
    }

    @Override
    public Element getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: "));
        res.append("front [");
        for (int i = 0; i < array.getSize(); i ++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(',');
        }
        res.append("] tail");
        return res.toString();
    }
}

public class Array<Element> {

    private Element[] data;
    private int size;

    public Array(int capacity){
        data = (Element[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(Element e){
        add(size, e);
    }

    public void addFirst(Element e){
        add(0, e);
    }

    public void add(int index, Element e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast fail. Require index >=0 and index <= size");

        if (size == data.length)
            resize(data.length * 2);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }

    public Element removeFirst(){
        return remove(0);
    }

    public Element removeLast(){
        return remove(size - 1);
    }

    public Element remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast fail. Require index >=0 and index <= size");

        Element ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size --;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    public void removeElement(Element e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public boolean contains(Element e){
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(Element e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    Element get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get fail. Index is illegal!");
        return data[index];
    }

    void set(int index, Element e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set fail. Index is illegal!");
        data[index] = e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: Size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i ++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        Element[] newData = (Element[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
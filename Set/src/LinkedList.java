public class LinkedList<Element> {
    private class Node {
        public Element e;
        public Node next;

        public Node(Element e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(Element e){
            this(e,  null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(Element e){
        add(0, e);
    }

    public void add(int index, Element e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Index is illegal");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(Element e){
        add(size, e);
    }

    public Element get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Index is illegal");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    public Element getFirst(){
        return get(0);
    }

    public Element getLast(){
        return get(size - 1);
    }

    public void set(int index, Element e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Index is illegal");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    public boolean contains(Element e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public Element remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Index is illegal");

        Node prev = dummyHead.next;
        for (int i = 0; i < index - 1; i++)
            prev = prev.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        size --;
        return retNode.e;
    }

    public Element removeFirst(){
        return remove(0);
    }

    public Element removeLast(){
        return remove(size - 1);
    }

    public void removeElement(Element e){

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

public class LinkedListStack<Element> implements Stack<Element> {
    private LinkedList<Element> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(Element e){
        list.addFirst(e);
    }

    @Override
    public Element pop() {
        return list.removeFirst();
    }

    @Override
    public Element peek(){
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}

public class LinkedListSet<Element> implements Set<Element> {

    private LinkedList<Element> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(Element e){
        if (!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public boolean contains(Element e){
        return list.contains(e);
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
    public void remove(Element e){
        list.removeElement (e);
    }
}

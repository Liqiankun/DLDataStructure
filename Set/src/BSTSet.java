public class BSTSet<Element extends Comparable<Element>> implements Set<Element> {

    private BST<Element> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(Element e){
        bst.add(e);
    }

    @Override
    public boolean contains(Element e){
       return bst.contains(e);
    }

    @Override
    public int getSize(){
        return bst.getSize();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }


    @Override
    public void remove(Element e){
        bst.remove(e);
    }

}


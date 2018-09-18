public class Node {
    public int e;
    public Node next;

    public Node(int e, Node next){
        this.e = e;
        this.next = next;
    }

    public Node(int e){
        this(e,  null);
    }

    public Node(){
        this(0, null);
    }

    public Node (int[] arr){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.e = arr[0];
        Node cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
        cur.next = new Node(arr[i]);
        cur = cur.next;
    }
}

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        Node cur = this;
        while(cur != null){
            s.append(cur.e + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

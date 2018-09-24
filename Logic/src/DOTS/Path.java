package DOTS;


public class Path<T> {
    public Node<T> Startpoint;
    public Node<T> current;
    private Node<T> head;
    SimpleLinkedListLines<T> erased;

    public Path(Node Startpoint) {
        this.Startpoint = Startpoint;
    }

    public boolean in(SimpleLinkedListLines data){
        for (int i = 0; i < data.getSize(); i++) {
            ListNode<T> node = data.getListNode(i);
            for (int j = 0; j < erased.getSize(); j++) {
                if (node.getData()==erased.getListNode(i).getData()){
                    return true;
                }
            }
        }
        return false;
    }


    public void LinePath(Node Startpoint){
        current=Startpoint;
        Node<T> tmp=this.head;
        while (current!=Startpoint && Startpoint.lineas.getSize()>1){
            if (current==Startpoint){
                //Figures
            }
            else if (current.lineas.getSize()<=1) { //REVISAR
                tmp = current;
                current = current.prev;
                erased.append((T) tmp.getData());
            }
            else{
                if (in(current.lineas)) {
                    //current = current.lineas.getListNode(0);
                }
                else{
                    current.prev = current;
                    //current= current.lineas.getListNode(1);
                }

            }
        }
    }
}

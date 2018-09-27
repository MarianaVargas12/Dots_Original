package DOTS;

public class Path<T> {
    public Node<T> Startpoint;
    public Node<T> current;
    private Node<T> head;
    SimpleLinkedListLines<T> erased;
    VectorList<T> path;
    public int vertices;

    public Path(Node Startpoint) {
        this.Startpoint = Startpoint;
    }


    public void Vertices(Node Startpoint) {
        int contador=0;
        while (current != Startpoint || contador==0) {
            if (current.lineas.getListNode(contador).getData()==current.getRight()){
                path.append(current, current.getRight(), 0);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getRight();
            }
            else if (current.lineas.getListNode(contador).getData()==current.getDru()){
                path.append(current, current.getDru(), 1);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getDru();
            }
            if (current.lineas.getListNode(contador).getData()==current.getUp()){
                path.append(current, current.getUp(), 2);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getUp();
            }
            if (current.lineas.getListNode(contador).getData()==current.getDlu()){
                path.append(current, current.getDlu(), 3);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getDlu();
            }
            if (current.lineas.getListNode(contador).getData()==current.getLeft()){
                path.append(current, current.getLeft(), 4);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getLeft();
            }
            if (current.lineas.getListNode(contador).getData()==current.getDld()){
                path.append(current, current.getDld(), 5);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getDld();
            }
            if (current.lineas.getListNode(contador).getData()==current.getDown()){
                path.append(current, current.getDown(), 6);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getDown();
            }
            if (current.lineas.getListNode(contador).getData()==current.getDrd()){
                path.append(current, current.getDrd(), 7);
                if (contador==0){
                    contador++;
                }
                else{
                    if (path.getVectorNode(contador-1).getDir()==path.getVectorNode(contador).getDir()){
                        contador++;
                    }
                    else{
                        vertices++;
                    }
                }
                current=current.getDrd();
            }
        }
    }
}

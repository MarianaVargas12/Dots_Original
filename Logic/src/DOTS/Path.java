package DOTS;

public class Path<T> {
    public Node<T> Startpoint;
    public Node<T> current;
    private Node<T> head;
<<<<<<< HEAD
    public SimpleLinkedListLines<T> erased = new SimpleLinkedListLines<T>();
    public VectorList<T> path = new VectorList<T>();
=======
    SimpleLinkedListLines<T> erased;
    VectorList<T> path;
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
    public int vertices;

    public Path(Node Startpoint) {
        this.Startpoint = Startpoint;
    }


<<<<<<< HEAD
    public boolean search(Node nodelines, Node node2compare){
        for (int i = 0; i < nodelines.lineas.getSize(); i++) {
            if (node2compare == nodelines.lineas.getNode(i).getData()) {
                return true;
            }
        }
        return false;
    }

    public void Vertices(Node Startpoint) {
        try {
            current = Startpoint;
            int contador=0;
            while (current != Startpoint || contador==0) {
                if (current == null) {
                    System.out.println("failed");
                    break;
                } else {
                    if (search(current, current.getRight())) {
                        path.append(current, current.getRight(), 0);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getRight();
                        System.out.println(current = current.getRight());
                    } else if ((search(current, current.getDru()))) {
                        path.append(current, current.getDru(), 1);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getDru();
                    } else if ((search(current, current.getUp()))) {
                        path.append(current, current.getUp(), 2);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getUp();
                    } else if ((search(current, current.getDlu()))) {
                        path.append(current, current.getDlu(), 3);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getDlu();
                    } else if ((search(current, current.getLeft()))) {
                        path.append(current, current.getLeft(), 4);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getLeft();
                    } else if ((search(current, current.getDld()))) {
                        path.append(current, current.getDld(), 5);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getDld();
                    } else if ((search(current, current.getDown()))) {
                        path.append(current, current.getDown(), 6);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getDown();
                    } else if ((search(current, current.getDrd()))) {
                        path.append(current, current.getDrd(), 7);
                        if (contador == 0) {
                            contador++;
                        } else {
                            if (path.getVectorNode(contador - 1).getDir() == path.getVectorNode(contador).getDir()) {
                                contador++;
                            } else {
                                vertices++;
                                contador++;
                            }
                        }
                        current = current.getDrd();
                    }
                }
            }
            System.out.println("cerro");
        } catch (NullPointerException e){
            System.out.println("Hacer algo si no sirve");
=======
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
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
        }
    }
}

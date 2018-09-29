package DOTS;

public class Adjacent<T> {

    public void Seters (DoubleLinkedList<DoubleLinkedList<Integer>> malla){
        for (int i = 0; i < malla.getSize(); i++) {

            DoubleLinkedList<Integer> line = malla.getNode(i).getData();

            for (int j = 0; j < line.getSize(); j++) {
                Node<Integer> nodeset = line.getNode(j);
                if (i==0 && j==0) {
                    nodeset.setLeft(null);
                    nodeset.setUp(null);
                    nodeset.setDown(malla.getNode(i + 1).getData().getNode(j));
                    nodeset.setRight(line.getNode(j + 1));
                    nodeset.setDru(null);
                    nodeset.setDrd(malla.getNode(i + 1).getData().getNode(j+1));
                    nodeset.setDlu(null);
                    nodeset.setDld(null);
                }
                else if (j!=0 && j!=5 && i==0){
                    nodeset.setLeft(line.getNode(j-1));
                    nodeset.setUp(null);
                    nodeset.setDown(malla.getNode(i + 1).getData().getNode(j));
                    nodeset.setRight(line.getNode(j + 1));
                    nodeset.setDru(null);
                    nodeset.setDrd(malla.getNode(i + 1).getData().getNode(j+1));
                    nodeset.setDlu(null);
                    nodeset.setDld(malla.getNode(i + 1).getData().getNode(j-1));
                }
                else if (i==0 && j==5){
                    nodeset.setLeft(line.getNode(j-1));
                    nodeset.setUp(null);
                    nodeset.setDown(malla.getNode(i + 1).getData().getNode(j));
                    nodeset.setRight(null);
                    nodeset.setDru(null);
                    nodeset.setDrd(null);
                    nodeset.setDlu(null);
                    nodeset.setDld(malla.getNode(i + 1).getData().getNode(j-1));
                }
                else if (i!=0 && i!=5 && j==5){
                    nodeset.setLeft(line.getNode(j-1));
                    nodeset.setUp(malla.getNode(i - 1).getData().getNode(j));
                    nodeset.setDown(malla.getNode(i + 1).getData().getNode(j));
                    nodeset.setRight(null);
                    nodeset.setDru(null);
                    nodeset.setDrd(null);
                    nodeset.setDlu(malla.getNode(i - 1).getData().getNode(j-1));
                    nodeset.setDld(malla.getNode(i + 1).getData().getNode(j-1));
                }
                else if (i==5 && j==5){
                    nodeset.setLeft(line.getNode(j-1));
                    nodeset.setUp(malla.getNode(i - 1).getData().getNode(j));
                    nodeset.setDown(null);
                    nodeset.setRight(null);
                    nodeset.setDru(null);
                    nodeset.setDrd(null);
                    nodeset.setDlu(malla.getNode(i - 1).getData().getNode(j-1));
                    nodeset.setDld(null);
                }
                else if (i==5 && j!=0 && j!=5){
                    nodeset.setLeft(line.getNode(j-1));
                    nodeset.setUp(malla.getNode(i - 1).getData().getNode(j));
                    nodeset.setDown(null);
                    nodeset.setRight(line.getNode(j + 1));
                    nodeset.setDru(malla.getNode(i - 1).getData().getNode(j+1));
                    nodeset.setDrd(null);
                    nodeset.setDlu(malla.getNode(i - 1).getData().getNode(j-1));
                    nodeset.setDld(null);
                }
                else if (i==5 && j==0){
                    nodeset.setLeft(null);
                    nodeset.setUp(malla.getNode(i - 1).getData().getNode(j));
                    nodeset.setDown(null);
                    nodeset.setRight(line.getNode(j + 1));
                    nodeset.setDru( malla.getNode(i - 1).getData().getNode(j+1));
                    nodeset.setDrd(null);
                    nodeset.setDlu(null);
                    nodeset.setDld(null);
                }
                else if (i!=0 && i!=5 && j==0){
                    nodeset.setLeft(null);
                    nodeset.setUp(malla.getNode(i - 1).getData().getNode(j));
                    nodeset.setDown(malla.getNode(i + 1).getData().getNode(j));
                    nodeset.setRight(line.getNode(j + 1));
                    nodeset.setDru(malla.getNode(i - 1).getData().getNode(j+1));
                    nodeset.setDrd(malla.getNode(i + 1).getData().getNode(j+1));
                    nodeset.setDlu(null);
                    nodeset.setDld(null);
                }
                else{
                    nodeset.setLeft(line.getNode(j-1));
                    nodeset.setUp(malla.getNode(i - 1).getData().getNode(j));
                    nodeset.setDown(malla.getNode(i + 1).getData().getNode(j));
                    nodeset.setRight(line.getNode(j + 1));
                    nodeset.setDru(malla.getNode(i - 1).getData().getNode(j+1));
                    nodeset.setDrd(malla.getNode(i + 1).getData().getNode(j+1));
                    nodeset.setDlu(malla.getNode(i - 1).getData().getNode(j-1));
                    nodeset.setDld(malla.getNode(i + 1).getData().getNode(j-1));
                }
            }
        }
    }

}


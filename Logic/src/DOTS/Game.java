package DOTS;

public class Game {
    public DoubleLinkedList<DoubleLinkedList<Integer>> Malla;

    public Game(){
        DoubleLinkedList<Integer> L1 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer> L2 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer> L3 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer> L4 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer> L5 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<Integer> L6 = new DoubleLinkedList<Integer>();
        DoubleLinkedList<DoubleLinkedList<Integer>> Malla = new DoubleLinkedList<>();
        Malla.append(L1);
        Malla.append(L2);
        Malla.append(L3);
        Malla.append(L4);
        Malla.append(L5);
        Malla.append(L6);
        fillup(L1);
        fillup(L2);
        fillup(L3);
        fillup(L4);
        fillup(L5);
        fillup(L6);
        naming(Malla);
        Adjacent ad = new Adjacent();
        ad.Seters(Malla);
        this.Malla = Malla;
    }

    public void fillup(DoubleLinkedList list){
        for (int i = 0; i < 6; i++) {

            list.append(new Node<Integer>(null));
        }
        return;
    }

    public void naming(DoubleLinkedList<DoubleLinkedList<Integer>> malla){
        for (int i = 0; i < malla.getSize(); i++) {

            DoubleLinkedList<Integer> line = malla.getNode(i).getData();

            for (int j = 0; j < line.getSize(); j++) {
                Node<Integer> Nodo = malla.getNode(i).getData().getNode(j);
                Nodo.setData(j + (6 * i));
            }
        }

    }

    public void display(DoubleLinkedList<DoubleLinkedList<Integer>> malla){

        for (int i = 0; i < malla.getSize(); i++) {

            DoubleLinkedList<Integer> line = malla.getNode(i).getData();

            for (int j = 0; j < line.getSize(); j++) {

                System.out.print("Node x: "); System.out.print(j);

                System.out.print(" y: "); System.out.println(i);

                System.out.print("Right: "); System.out.println(line.getNode(j).getRight());

                System.out.print("Left: "); System.out.println(line.getNode(j).getLeft());

                System.out.print("Up: "); System.out.println(line.getNode(j).getUp());

                System.out.print("Down: "); System.out.println(line.getNode(j).getDown());

                System.out.print("Drd: "); System.out.println(line.getNode(j).getDrd());

                System.out.print("Dru: "); System.out.println(line.getNode(j).getDru());

                System.out.print("Dld: "); System.out.println(line.getNode(j).getDld());

                System.out.print("Dlu: "); System.out.println(line.getNode(j).getDlu());

                System.out.println("-------------------------------------------------------------------");


            }

        }
    }
}

package DOTS;

public class Figures<T> {
    Game game = new Game();

    public Figures(){}

    public int identify(int vertices, int segmentos){
        if (vertices == 3){
            return (3*(segmentos*2));
        }else if (vertices==4){
            System.out.println(4*(segmentos*2));
            return (4*(segmentos*2));
        }else if (vertices==5){
            return (5*(segmentos*2));
        }else if (vertices==6){
            return (6*(segmentos*2));
        }
        else{return (7*(segmentos*2));}
    }


    public Node<T> NodeToCoords(Node node){
        int list=0;
        int nodenum=0;
        for (int i = 0; i < game.Malla.getSize(); i++) {
            node.y=i;
            for (int j = 0; j < game.Malla.getNode(i).getData().getSize(); j++) {
                node.x=j;
                if (node == game.Malla.getNode(i).getData().getNode(j)){
                    return node;
                }
            }
        }return null;
    }
}

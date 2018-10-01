package DOTS;

import DOTS.server.gameStart;

public class Figures<T> {
    Game game = new Game();

    public Figures(){}

    /**
     * asigna puntos segun su figura formada
     * @param vertices
     * @param segmentos
     * @return puntaje
     */
    public int identify(int vertices, int segmentos){
        if (vertices == 3){
            gameStart.setScore(3*(segmentos*2));
            return (3*(segmentos*2));
        }else if (vertices==4){
            gameStart.setScore(4*(segmentos*2));
            return (4*(segmentos*2));
        }else if (vertices==5){
            gameStart.setScore(5*(segmentos*2));
            return (5*(segmentos*2));
        }else if (vertices==6){
            gameStart.setScore(6*(segmentos*2));
            return (6*(segmentos*2));
        }
        else{
            gameStart.setScore(7*(segmentos*2));
            return (7*(segmentos*2));}
    }


    /**
     *
     * @param node
     * @return malla
     */
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

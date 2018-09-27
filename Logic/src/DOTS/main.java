package DOTS;

public class main {

    public static void main(String args[]) {
        Game game = new Game();
        Path prueba = new Path(game.Malla.getNode(0));
        game.Malla.getNode(0).setLineas(game.Malla.getNode(1));
        game.Malla.getNode(1).setLineas(game.Malla.getNode(7));
        game.Malla.getNode(7).setLineas(game.Malla.getNode(6));
        game.Malla.getNode(6).setLineas(game.Malla.getNode(0));
        prueba.Vertices(game.Malla.getNode(0));


    }



}

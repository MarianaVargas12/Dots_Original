package DOTS;

public class main {

    public static void main(String args[]) {
        Game game = new Game();
<<<<<<< HEAD
        Node cero = game.Malla.getNode(0).getData().getNode(0);
        Node uno = game.Malla.getNode(0).getData().getNode(1);
        Node seis = game.Malla.getNode(1).getData().getNode(0);
        Node siete = game.Malla.getNode(1).getData().getNode(1);
        System.out.println(siete);
        cero.lineas.append(uno);
        uno.lineas.append(siete);
        siete.lineas.append(seis);
        seis.lineas.append(cero);
        Path prueba = new Path(uno);
        prueba.Vertices(cero);

=======
        Path prueba = new Path(game.Malla.getNode(0));
        game.Malla.getNode(0).getData().getNode(0).setLineas(game.Malla.getNode(0).getData().getNode(1));
        game.Malla.getNode(0).getData().getNode(1).setLineas(game.Malla.getNode(1).getData().getNode(7));
        game.Malla.getNode(1).getData().getNode(7).setLineas(game.Malla.getNode(1).getData().getNode(6));
        game.Malla.getNode(1).getData().getNode(6).setLineas(game.Malla.getNode(0).getData().getNode(0));
        prueba.Vertices(game.Malla.getNode(0).getData().getNode(0));
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc

    }



}

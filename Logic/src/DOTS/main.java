package DOTS;

public class main {

    public static void main(String args[]) {
        Game game = new Game();
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


    }



}

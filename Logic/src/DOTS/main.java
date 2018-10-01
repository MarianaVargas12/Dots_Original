package DOTS;

public class main {

    public static void main(String args[]) {
        Game game = new Game();
        Node cero = game.Malla.getNode(0).getData().getNode(0);
        Node uno = game.Malla.getNode(0).getData().getNode(1);
        Node seis = game.Malla.getNode(1).getData().getNode(0);
        Node siete = game.Malla.getNode(1).getData().getNode(1);
        cero.lineas.append(uno);
        uno.lineas.append(cero);

        uno.lineas.append(siete);
        siete.lineas.append(uno);

        siete.lineas.append(seis);
        seis.lineas.append(siete);

        seis.lineas.append(cero);
        cero.lineas.append(seis);

        System.out.println("------------------------------");
        System.out.println(uno.lineas.getNode(1).getData());
        System.out.println(siete);
        System.out.println("------------------------------");

        Path trial = new Path(cero);
        trial.Vertices(cero);

    }



}

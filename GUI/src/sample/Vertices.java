package sample;

public class Vertices {
    /**
     * creacion de array con los puntos
     * @return array de los puntos
     */
    public int[][] Vertices(){
        int [][] matrixVert= new int[38][6];
        int fil= 0;
        int col=0;
        int filNum=66;
        int colNum=66;
        while(fil<36) {
            while (col < 6 && fil<36) {
                matrixVert[fil][0] = filNum;
                matrixVert[fil][1] = filNum + 30;
                matrixVert[fil][2] = colNum + 30;
                matrixVert[fil][3] = colNum;
                matrixVert[fil][4] = filNum + 15;
                matrixVert[fil][5] = colNum + 15;
                col++;
                fil++;
                filNum += 81;
            }
            filNum= 66;
            col=0;
            colNum+=81;
        }
        return matrixVert;
    }
}

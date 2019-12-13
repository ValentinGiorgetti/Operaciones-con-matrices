package matrices;

public abstract class Matriz {
    
    public static void imprimirMatriz (double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static double calcularDeterminante (double matriz[][]) {
        double determinante;
        if (matriz.length == 2) {
            determinante = ((matriz[0][0] * matriz[1][1]) - (matriz[0][1]) * (matriz[1][0]));
        } else {
            determinante = 0;
            for (int i = 0; i < matriz.length; i++) {
                double [][]matrizReducida = calcularMatrizReducida(matriz, i, 0);
                determinante += matriz[i][0] * Math.pow(-1, (i + 2)) * calcularDeterminante(matrizReducida);
            } 
        }
        return determinante;        
    }
    
    public static double[][] calcularMatrizReducida (double matriz[][], int filaASacar, int columnaASacar) {
        double [][]matrizReducida = new double [matriz.length - 1][matriz.length - 1];
        int fila = 0, columna = 0;
        for (int i = 0; i < matriz.length; i ++) {
            if (filaASacar != i) {
                for (int j = 0; j < matriz.length; j ++) {
                    if (columnaASacar != j) {
                        matrizReducida[fila][columna] = matriz[i][j];
                        columna++;
                    }
                }
                fila++;
                columna = 0;
            }
        }
        return matrizReducida;
    }
    
    public static double[][] calcularSumaResta (double matriz1[][], double matriz2[][], int operacion) {
        double [][]resultado = new double [matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                resultado[i][j] = matriz1[i][j] + (operacion * matriz2[i][j]);
            }
        }
        return resultado;
    }
    
    public static double[][] calcularTraspuesta (double matriz[][]) {
        double [][]traspuesta = new double [matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                traspuesta[i][j] = matriz[j][i];
            }
        }
        return traspuesta;
    }
    
    public static double[][] calcularProducto (double matriz1[][], double matriz2[][]) {
        double [][]resultado = new double [matriz1.length][matriz2[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                double aux = 0;
                for (int i2 = 0; i2 < matriz1[0].length; i2 ++) {
                    aux = aux + (matriz1[i][i2] * matriz2[i2][j]);
                }
                resultado[i][j] = aux;
            }
        }
        return resultado;
    }
    
}

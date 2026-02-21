import java.util.*;

public class GrafoMatriz {
    private List<String> vertices;
    private int[][] matriz;
    private int maxVertices;

    public GrafoMatriz(int maxVertices) {
        this.maxVertices = maxVertices;
        this.vertices = new ArrayList<>();
        this.matriz = new int[maxVertices][maxVertices];
    }

    public void agregarVertice(String vertice) {
        if (!vertices.contains(vertice) && vertices.size() < maxVertices) {
            vertices.add(vertice);
        }
    }

    public void agregarArista(String origen, String destino) {
        agregarVertice(origen);
        agregarVertice(destino);

        int i = vertices.indexOf(origen);
        int j = vertices.indexOf(destino);

        if (i != -1 && j != -1) {
            matriz[i][j] = 1;
            matriz[j][i] = 1; 
        }
    }

    public void mostrarMatriz() {
        // Encabezado de columnas
        System.out.print("  ");
        for (String v : vertices) {
            System.out.printf("%3s", v);
        }
        System.out.println();

        // Filas de la matriz
        for (int i = 0; i < vertices.size(); i++) {
            System.out.printf("%2s", vertices.get(i));
            for (int j = 0; j < vertices.size(); j++) {
                System.out.printf("%3d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz(10);

    
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "A");


        grafo.mostrarMatriz();
    }
}
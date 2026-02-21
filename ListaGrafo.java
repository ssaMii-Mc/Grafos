import java.util.*;

public class ListaGrafo {
    private HashMap<String, List<String>> mapa;

    public ListaGrafo() {
        this.mapa = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        // Si el vertice no existe, lo agrega con una lista vacia
        mapa.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino) {
        // Agregar vertices si no existen
        agregarVertice(origen);
        agregarVertice(destino);

        // Conectar en ambas direcciones (grafo no dirigido)
        mapa.get(origen).add(destino);
        mapa.get(destino).add(origen);
    }

    public void mostrarGrafo() {
        // Ordenar vertices alfabeticamente para salida consistente
        List<String> listaVertices = new ArrayList<>(mapa.keySet());
        Collections.sort(listaVertices);

        for (String vertice : listaVertices) {
            List<String> vecinos = mapa.get(vertice);
            Collections.sort(vecinos);
            System.out.println(vertice + " -> " + vecinos);
        }
    }

    public static void main(String[] args) {
        ListaGrafo grafo = new ListaGrafo();

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");

       
        grafo.mostrarGrafo();
    }
}
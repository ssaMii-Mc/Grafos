import java.util.*;

public class ListaGrafo {
    private HashMap<String, List<String>> mapa;

    public ListaGrafo() {
        this.mapa = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        
        mapa.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino) {
       
        agregarVertice(origen);
        agregarVertice(destino);

        mapa.get(origen).add(destino);
        mapa.get(destino).add(origen);
    }

    public void mostrarGrafo() {
      
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
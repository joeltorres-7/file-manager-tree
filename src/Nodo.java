import java.util.ArrayList;
import java.util.List;

// Clase Nodo que representa una carpeta o archivo
class Nodo {
    String nombre;
    boolean esArchivo; // Determina si es archivo o carpeta
    List<Nodo> hijos; // Lista de subcarpetas o archivos

    public Nodo(String nombre, boolean esArchivo) {
        this.nombre = nombre;
        this.esArchivo = esArchivo;
        if (!esArchivo) {
            hijos = new ArrayList<>(); // Solo carpetas pueden tener hijos
        }
    }

    // Agrega un subelemento (archivo o carpeta)
    public void agregarHijo(Nodo nodo) {
        if (!esArchivo) { // Solo las carpetas pueden tener hijos
            hijos.add(nodo);
        }
    }
}
import java.util.ArrayList;
import java.util.List;

// Clase NavegadorDeArchivos para manejar la estructura de archivos
class NavegadorDeArchivos {
    Nodo raiz; // Carpeta raíz

    public NavegadorDeArchivos(String nombreRaiz) {
        raiz = new Nodo(nombreRaiz, false); // Inicializa la carpeta raíz
    }

    // Método para listar el contenido de una carpeta
    public void listarContenido(Nodo nodo, String nivel) {
        System.out.println(nivel + (nodo.esArchivo ? "Archivo: " : "Carpeta: ") + nodo.nombre);
        if (!nodo.esArchivo) {
            for (Nodo hijo : nodo.hijos) {
                listarContenido(hijo, nivel + "  "); // Lista el contenido con sangría
            }
        }
    }

    // Método principal para probar la estructura
    public static void main(String[] args) {
        // Crear la estructura del sistema de archivos
        NavegadorDeArchivos sistema = new NavegadorDeArchivos("Proyectos");

        // Crear carpetas y archivos
        Nodo carpetaTI = new Nodo("TI", false);
        Nodo carpetaDesarrollo = new Nodo("Desarrollo", false);
        Nodo archivoReporte = new Nodo("Reporte.pdf", true);
        Nodo carpetaBackend = new Nodo("Backend", false);
        Nodo archivoAPI = new Nodo("API_Documentation.docx", true);
        Nodo archivoFrontend = new Nodo("Frontend_Guide.txt", true);

        // Construir la estructura
        sistema.raiz.agregarHijo(carpetaTI);
        carpetaTI.agregarHijo(carpetaDesarrollo);
        carpetaDesarrollo.agregarHijo(carpetaBackend);
        carpetaDesarrollo.agregarHijo(archivoFrontend);
        carpetaTI.agregarHijo(archivoReporte);
        carpetaBackend.agregarHijo(archivoAPI);

        // Listar todo el contenido desde la raíz
        System.out.println("Contenido del sistema de archivos:");
        sistema.listarContenido(sistema.raiz, "  ");
    }
}

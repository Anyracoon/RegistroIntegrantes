import controller.IntegranteController;
import view.FormularioIntegrante;
import javax.swing.SwingUtilities;

/**
 * Clase principal que contiene el punto de entrada de la aplicación.
 * Inicializa la Vista y el Controlador dentro del hilo de eventos de Swing.
 *
 * @author Cristian Camilo Velosa Ortiz
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que arranca la ejecución del sistema de registro.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioIntegrante vista = new FormularioIntegrante();
            new IntegranteController(vista);
            vista.setVisible(true);
        });
    }
}
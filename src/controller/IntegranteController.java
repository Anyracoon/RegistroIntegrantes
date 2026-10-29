package controller;

import model.Integrante;
import view.FormularioIntegrante;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Controlador dentro de la arquitectura MVC que coordina las interacciones
 * entre la vista {@link FormularioIntegrante} y el modelo {@link Integrante}.
 * Gestiona las validaciones, el almacenamiento en memoria con ArrayList y los eventos.
 *
 * @author Cristian Camilo Velosa Ortiz
 * @version 1.0
 */
public class IntegranteController {

    /** Referencia a la ventana del formulario (Vista). */
    private final FormularioIntegrante vista;

    /** Estructura de datos dinámica para almacenar los integrantes en memoria. */
    private final List<Integrante> listaIntegrantes;

    /** Patrón de expresión regular para verificar el formato básico de una URL http/https. */
    private static final Pattern PATRON_URL = Pattern.compile(
        "^(https?://)[\\w.-]+(\\.[a-zA-Z]{2,})+(/[\\w._~:/?#\\[\\]@!$&'()*+,;=-]*)?$"
    );

    /**
     * Constructor que inicializa la lista en memoria y enlaza los eventos de la vista.
     *
     * @param vista Instancia de la interfaz gráfica {@link FormularioIntegrante}.
     */
    public IntegranteController(FormularioIntegrante vista) {
        this.vista = vista;
        this.listaIntegrantes = new ArrayList<>();

        this.vista.setRegistrarListener(e -> registrarIntegrante());
        this.vista.setConsultarListener(e -> consultarIntegrantes());
        this.vista.setLimpiarListener(e -> this.vista.limpiarFormulario());
    }

    /**
     * Captura los datos ingresados en la vista, valida que todos los campos obligatorios
     * y la URL sean correctos, almacena el nuevo objeto {@link Integrante} en el ArrayList
     * y actualiza la tabla de registros.
     */
    private void registrarIntegrante() {
        String nombres = vista.getNombresInput();
        String apellidos = vista.getApellidosInput();
        String repositorio = vista.getRepositorioInput();
        String tipoEstudiante = vista.getTipoEstudianteSeleccionado();
        String proyecto = vista.getProyectoSeleccionado();

        if (nombres.isEmpty()) {
            vista.mostrarMensajeError("El campo 'Nombres' es obligatorio.");
            return;
        }
        if (apellidos.isEmpty()) {
            vista.mostrarMensajeError("El campo 'Apellidos' es obligatorio.");
            return;
        }
        if (repositorio.isEmpty()) {
            vista.mostrarMensajeError("El campo 'Repositorio del trabajo' es obligatorio.");
            return;
        }
        if (tipoEstudiante.isEmpty()) {
            vista.mostrarMensajeError("Debe seleccionar un 'Tipo de estudiante' (Nuevo o Antiguo).");
            return;
        }
        if (proyecto.isEmpty()) {
            vista.mostrarMensajeError("Debe seleccionar un 'Proyecto educativo' válido de la lista.");
            return;
        }

        if (!esUrlValida(repositorio)) {
            vista.mostrarMensajeError(
                "La URL del repositorio no tiene un formato válido.\n" +
                "Debe iniciar con http:// o https:// (Ej: https://github.com/usuario/proyecto)."
            );
            return;
        }

        Integrante nuevoIntegrante = new Integrante(
            nombres, apellidos, repositorio, tipoEstudiante, proyecto
        );
        listaIntegrantes.add(nuevoIntegrante);

        vista.mostrarMensajeExito("Integrante registrado exitosamente:\n" + nuevoIntegrante.toString());
        vista.limpiarFormulario();
        vista.actualizarTabla(listaIntegrantes);
    }

    /**
     * Verifica si existen registros almacenados en memoria y solicita a la vista
     * refrescar la tabla con la lista actual de integrantes.
     */
    private void consultarIntegrantes() {
        if (listaIntegrantes.isEmpty()) {
            vista.mostrarMensajeError("Aún no hay integrantes registrados en memoria.");
            return;
        }
        vista.actualizarTabla(listaIntegrantes);
    }

    /**
     * Evalúa si una cadena de texto cumple con el formato básico de una URL web.
     *
     * @param url Cadena de texto a validar.
     * @return {@code true} si el formato es válido; {@code false} en caso contrario.
     */
    private boolean esUrlValida(String url) {
        return PATRON_URL.matcher(url).matches();
    }
}
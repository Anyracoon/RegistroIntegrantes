package model;

/**
 * Representa a un integrante que participa en un proyecto educativo.
 * Esta clase actúa como la capa de Modelo dentro de la arquitectura MVC,
 * manteniendo sus atributos encapsulados.
 *
 * @author Cristian Camilo Velosa Ortiz
 * @version 1.0
 */
public class Integrante {

    /** Nombres del integrante (obligatorio). */
    private String nombres;

    /** Apellidos del integrante (obligatorio). */
    private String apellidos;

    /** Dirección URL del repositorio de GitHub del trabajo. */
    private String repositorioUrl;

    /** Tipo de estudiante: "Nuevo" o "Antiguo". */
    private String tipoEstudiante;

    /** Programa o proyecto educativo al que pertenece el integrante. */
    private String proyectoEducativo;

    /**
     * Constructor que inicializa un nuevo objeto Integrante con todos sus datos.
     *
     * @param nombres           Nombres del estudiante.
     * @param apellidos         Apellidos del estudiante.
     * @param repositorioUrl    URL válida del repositorio en GitHub.
     * @param tipoEstudiante    Clasificación del estudiante (Nuevo o Antiguo).
     * @param proyectoEducativo Nombre del proyecto curricular seleccionado.
     */
    public Integrante(String nombres, String apellidos, String repositorioUrl,
                      String tipoEstudiante, String proyectoEducativo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.repositorioUrl = repositorioUrl;
        this.tipoEstudiante = tipoEstudiante;
        this.proyectoEducativo = proyectoEducativo;
    }

    /**
     * Obtiene los nombres del integrante.
     *
     * @return Cadena de texto con los nombres.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece o modifica los nombres del integrante.
     *
     * @param nombres Nuevos nombres a asignar.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene los apellidos del integrante.
     *
     * @return Cadena de texto con los apellidos.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece o modifica los apellidos del integrante.
     *
     * @param apellidos Nuevos apellidos a asignar.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la URL del repositorio de GitHub del integrante.
     *
     * @return Cadena de texto con la URL del repositorio.
     */
    public String getRepositorioUrl() {
        return repositorioUrl;
    }

    /**
     * Establece o modifica la URL del repositorio de GitHub.
     *
     * @param repositorioUrl Nueva URL del repositorio.
     */
    public void setRepositorioUrl(String repositorioUrl) {
        this.repositorioUrl = repositorioUrl;
    }

    /**
     * Obtiene el tipo de estudiante (Nuevo o Antiguo).
     *
     * @return Cadena de texto con el tipo de estudiante.
     */
    public String getTipoEstudiante() {
        return tipoEstudiante;
    }

    /**
     * Establece o modifica el tipo de estudiante.
     *
     * @param tipoEstudiante Nuevo tipo de estudiante ("Nuevo" o "Antiguo").
     */
    public void setTipoEstudiante(String tipoEstudiante) {
        this.tipoEstudiante = tipoEstudiante;
    }

    /**
     * Obtiene el proyecto educativo o carrera del integrante.
     *
     * @return Cadena de texto con el proyecto educativo.
     */
    public String getProyectoEducativo() {
        return proyectoEducativo;
    }

    /**
     * Establece o modifica el proyecto educativo del integrante.
     *
     * @param proyectoEducativo Nuevo proyecto educativo a asignar.
     */
    public void setProyectoEducativo(String proyectoEducativo) {
        this.proyectoEducativo = proyectoEducativo;
    }

    /**
     * Devuelve una representación textual resumida de los datos del integrante.
     *
     * @return Cadena formateada con nombre completo, tipo, proyecto y repositorio.
     */
    @Override
    public String toString() {
        return nombres + " " + apellidos + " | " + tipoEstudiante +
               " | " + proyectoEducativo + " | Repo: " + repositorioUrl;
    }
}
package view;

import model.Integrante;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Representa la interfaz gráfica de usuario (Vista en el patrón MVC) construida con Java Swing.
 * Permite capturar los datos del formulario y visualizar los registros almacenados en una tabla.
 *
 * @author Cristian Camilo Velosa Ortiz
 * @version 1.0
 */
public class FormularioIntegrante extends JFrame {

    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtRepositorio;
    private JRadioButton rbNuevo;
    private JRadioButton rbAntiguo;
    private ButtonGroup grupoTipoEstudiante;
    private JComboBox<String> cbProyecto;
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnLimpiar;
    private JTable tablaIntegrantes;
    private DefaultTableModel modeloTabla;

    /**
     * Constructor que configura las propiedades principales de la ventana
     * e inicializa los componentes gráficos de Java Swing.
     */
    public FormularioIntegrante() {
        setTitle("Registro de Integrantes - Proyectos Educativos (MVC)");
        setSize(750, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        inicializarComponentes();
    }

    /**
     * Crea, configura y distribuye visualmente todos los paneles, campos,
     * botones y la tabla de consulta dentro del JFrame.
     */
    private void inicializarComponentes() {
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Integrante"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nombres
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.2;
        panelFormulario.add(new JLabel("Nombres *:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.8;
        txtNombres = new JTextField(25);
        panelFormulario.add(txtNombres, gbc);

        // Apellidos
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.2;
        panelFormulario.add(new JLabel("Apellidos *:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.8;
        txtApellidos = new JTextField(25);
        panelFormulario.add(txtApellidos, gbc);

        // Repositorio
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.2;
        panelFormulario.add(new JLabel("URL Repositorio GitHub *:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.8;
        txtRepositorio = new JTextField(25);
        txtRepositorio.setToolTipText("Ejemplo: https://github.com/usuario/repositorio");
        panelFormulario.add(txtRepositorio, gbc);

        // Tipo de estudiante
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.2;
        panelFormulario.add(new JLabel("Tipo de estudiante *:"), gbc);

        JPanel panelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        rbNuevo = new JRadioButton("Nuevo");
        rbAntiguo = new JRadioButton("Antiguo");
        grupoTipoEstudiante = new ButtonGroup();
        grupoTipoEstudiante.add(rbNuevo);
        grupoTipoEstudiante.add(rbAntiguo);
        panelRadio.add(rbNuevo);
        panelRadio.add(rbAntiguo);

        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.8;
        panelFormulario.add(panelRadio, gbc);

        // Proyecto educativo
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.2;
        panelFormulario.add(new JLabel("Proyecto educativo *:"), gbc);

        String[] opcionesProyectos = {
            "Seleccione un proyecto...",
            "Ingeniería de Sistemas",
            "Ingeniería Electrónica",
            "Ingeniería Industrial",
            "Ingeniería Civil"
        };
        cbProyecto = new JComboBox<>(opcionesProyectos);
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 0.8;
        panelFormulario.add(cbProyecto, gbc);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnRegistrar = new JButton("Registrar Integrante");
        btnConsultar = new JButton("Consultar / Actualizar Tabla");
        btnLimpiar = new JButton("Limpiar Campos");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnLimpiar);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panelFormulario.add(panelBotones, gbc);

        add(panelFormulario, BorderLayout.NORTH);

        // Tabla de consulta
        String[] columnas = {"Nombres", "Apellidos", "Repositorio GitHub", "Tipo Estudiante", "Proyecto Educativo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaIntegrantes = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaIntegrantes);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Integrantes Registrados en Memoria"));

        add(scrollTabla, BorderLayout.CENTER);
    }

    /**
     * Obtiene el valor ingresado en el campo de nombres sin espacios extremos.
     *
     * @return Texto ingresado en el campo Nombres.
     */
    public String getNombresInput() {
        return txtNombres.getText().trim();
    }

    /**
     * Obtiene el valor ingresado en el campo de apellidos sin espacios extremos.
     *
     * @return Texto ingresado en el campo Apellidos.
     */
    public String getApellidosInput() {
        return txtApellidos.getText().trim();
    }

    /**
     * Obtiene la URL ingresada en el campo del repositorio sin espacios extremos.
     *
     * @return Texto ingresado en el campo Repositorio.
     */
    public String getRepositorioInput() {
        return txtRepositorio.getText().trim();
    }

    /**
     * Determina cuál opción de tipo de estudiante fue seleccionada en los RadioButtons.
     *
     * @return "Nuevo", "Antiguo", o cadena vacía "" si no se ha seleccionado ninguno.
     */
    public String getTipoEstudianteSeleccionado() {
        if (rbNuevo.isSelected()) {
            return "Nuevo";
        } else if (rbAntiguo.isSelected()) {
            return "Antiguo";
        }
        return "";
    }

    /**
     * Obtiene el proyecto educativo seleccionado en la lista desplegable.
     *
     * @return Nombre de la carrera seleccionada, o cadena vacía "" si sigue en la opción por defecto.
     */
    public String getProyectoSeleccionado() {
        if (cbProyecto.getSelectedIndex() <= 0) {
            return "";
        }
        return cbProyecto.getSelectedItem().toString();
    }

    /**
     * Restablece todos los campos del formulario a su estado vacío inicial
     * y devuelve el foco al campo de nombres.
     */
    public void limpiarFormulario() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtRepositorio.setText("");
        grupoTipoEstudiante.clearSelection();
        cbProyecto.setSelectedIndex(0);
        txtNombres.requestFocus();
    }

    /**
     * Refresca el contenido de la tabla visual con la lista de integrantes en memoria.
     *
     * @param listaIntegrantes Lista de objetos {@link Integrante} a mostrar.
     */
    public void actualizarTabla(List<Integrante> listaIntegrantes) {
        modeloTabla.setRowCount(0);
        for (Integrante i : listaIntegrantes) {
            Object[] fila = {
                i.getNombres(),
                i.getApellidos(),
                i.getRepositorioUrl(),
                i.getTipoEstudiante(),
                i.getProyectoEducativo()
            };
            modeloTabla.addRow(fila);
        }
    }

    /**
     * Muestra un cuadro de diálogo emergente confirmando una operación exitosa.
     *
     * @param mensaje Texto informativo a mostrar al usuario.
     */
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo emergente alertando sobre un error de validación.
     *
     * @param mensaje Descripción del error ocurrido.
     */
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Asigna el escuchador de eventos para el botón de Registrar.
     *
     * @param listener Objeto ActionListener manejado por el controlador.
     */
    public void setRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    /**
     * Asigna el escuchador de eventos para el botón de Consultar.
     *
     * @param listener Objeto ActionListener manejado por el controlador.
     */
    public void setConsultarListener(ActionListener listener) {
        btnConsultar.addActionListener(listener);
    }

    /**
     * Asigna el escuchador de eventos para el botón de Limpiar.
     *
     * @param listener Objeto ActionListener manejado por el controlador.
     */
    public void setLimpiarListener(ActionListener listener) {
        btnLimpiar.addActionListener(listener);
    }
}
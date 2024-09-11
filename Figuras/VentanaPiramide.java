package actividad5.Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase denominada VentanaPiramide define una ventana para
 * ingresar los datos de una pirámide y calcular su volumen y superficie.
 * @version 1.2/2020
 */
public class VentanaPiramide extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    // Etiquetas estáticas para identificar los campos de texto a ingresar y calcular
    private JLabel base, altura, apotema, volumen, superficie;
    // Campos de texto a ingresar
    private JTextField campoBase, campoAltura, campoApotema;
    // Botón para realizar los cálculos numéricos
    private JButton calcular;

    /**
     * Constructor de la clase VentanaPiramide
     */
    public VentanaPiramide() {
        inicio();
        setTitle("Pirámide"); // Establece el título de la ventana
        setSize(280, 240); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // La ventana se posiciona en el centro de la pantalla
        setResizable(false); // Establece que la ventana no se puede redimensionar
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicio() {
        contenedor = getContentPane(); // Obtiene el panel de contenidos de la ventana
        contenedor.setLayout(null); // Establece que el contenedor no tiene un layout

        // Establece la etiqueta y campo de texto para la base de la pirámide
        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 135, 23);

        // Establece la etiqueta y campo de texto para la altura de la pirámide
        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 135, 23);

        // Establece la etiqueta y campo de texto para el apotema de la pirámide
        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 135, 23);

        // Establece el botón para calcular el volumen y superficie de la pirámide
        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 135, 23);
        calcular.addActionListener(this); // Agrega el ActionListener para gestionar eventos

        // Establece la etiqueta y el valor del volumen de la pirámide
        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 140, 135, 23);

        // Establece la etiqueta y el valor de la superficie de la pirámide
        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 170, 135, 23);

        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana de la pirámide
     * throws Exception Excepción al ingresar un campo nulo o error en formato de número
     */
    public void actionPerformed(ActionEvent event) {
        Piramide piramide;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double apotema = 0;
        try {
            // Se obtiene y convierte el valor numérico de la base
            base = Double.parseDouble(campoBase.getText());
            // Se obtiene y convierte el valor numérico de la altura
            altura = Double.parseDouble(campoAltura.getText());
            // Se obtiene y convierte el valor numérico del apotema
            apotema = Double.parseDouble(campoApotema.getText());
            // Se crea un objeto Piramide
            piramide = new Piramide(base, altura, apotema);

            // Se muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f", piramide.calcularVolumen()));
            // Se muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f", piramide.calcularSuperficie()));
        } catch (Exception e) {
            error = true; // Si ocurre una excepción
        } finally {
            if (error) { // Si ocurre una excepción, se muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

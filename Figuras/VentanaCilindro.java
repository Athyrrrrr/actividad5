package actividad5.Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase denominada VentanaCilindro define una ventana para
 * ingresar los datos de un cilindro y calcular su volumen y superficie.
 * @version 1.2/2020
 */
public class VentanaCilindro extends JFrame implements ActionListener {

    // Un contenedor de elementos gráficos
    private Container contenedor;
    // Etiquetas estáticas para identificar los campos de texto a ingresar y calcular
    private JLabel radio, altura, volumen, superficie;
    // Campos de texto a ingresar
    private JTextField campoRadio, campoAltura;
    // Botón para realizar los cálculos numéricos
    private JButton calcular;

    /**
     * Constructor de la clase VentanaCilindro
     */
    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro"); // Establece el título de la ventana
        setSize(280, 210); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // La ventana se posiciona en el centro de la pantalla
        setResizable(false); // Establece que el botón de cerrar permitirá salir de la aplicación
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicio() {
        contenedor = getContentPane(); // Obtiene el panel de contenidos de la ventana
        contenedor.setLayout(null); // Establece que el contenedor no tiene un layout

        // Establece la etiqueta y campo de texto para el radio del cilindro
        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        // Establece la etiqueta y campo de texto para la altura del cilindro
        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        // Establece el botón para calcular el volumen y superficie del cilindro
        calcular = new JButton("Calcular");
        calcular.setBounds(100, 80, 135, 23);
        calcular.addActionListener(this); // Agrega el ActionListener para gestionar eventos

        // Establece la etiqueta y el valor del volumen del cilindro
        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 110, 135, 23);

        // Establece la etiqueta y el valor de la superficie del cilindro
        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 140, 135, 23);

        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del cilindro
     * throws Exception Excepción al ingresar un campo nulo o error en formato de número
     */
    public void actionPerformed(ActionEvent event) {
        boolean error = false; // Variable para detectar errores
        double radio = 0;
        double altura = 0;
        try {
            // Obtiene el radio y la altura del cilindro ingresado
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura); // Crea un objeto Cilindro

            // Calcula y muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            // Calcula y muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));
        } catch (Exception e) {
            error = true; // Si ocurre una excepción
        } finally {
            if (error) { // Si ocurre una excepción, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

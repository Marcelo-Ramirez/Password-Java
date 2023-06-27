import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chequed.Password;

public class InterfazGrafica {
    public static void main(String[] args) {
        // Crear una instancia de JFrame (ventana)
        JFrame ventana = new JFrame("Interfaz Gráfica");

        // Crear un panel para contener los componentes
        JPanel panel = new JPanel(new GridBagLayout());

        // Crear una etiqueta para el título
        JLabel etiquetaTitulo = new JLabel("Secure password");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 24));

        // Crear un campo de texto para ingresar datos
        JPasswordField campoTexto = new JPasswordField(20);

        // Crear un botón para mostrar los datos
        JButton botonMostrar = new JButton("Check");

        // Crear una etiqueta para mostrar los datos ingresados
        JLabel etiquetaDatos = new JLabel();
        JLabel etiquetaDatos2 = new JLabel();

        // Establecer el tamaño de fuente y tipo de letra para los componentes
        Font font = new Font("Arial", Font.PLAIN, 20);
        campoTexto.setFont(font);
        botonMostrar.setFont(font);
        etiquetaDatos.setFont(font);
        etiquetaDatos2.setFont(font);

        // Establecer el tamaño preferido para los componentes
        campoTexto.setPreferredSize(new Dimension(300, 40));
        botonMostrar.setPreferredSize(new Dimension(200, 40));

        // Configurar el botón para manejar el evento de clic
        botonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatos(new String(campoTexto.getPassword()), etiquetaDatos);
            }
        });

        // Configurar el campo de texto para manejar el evento de presionar Enter
        campoTexto.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                String password = new String(campoTexto.getPassword());
                Boolean sw = Password.containSigns(password);
                Boolean sw2 = Password.containCapitalLetters(password);
                boolean sw3 = Password.containSpaceInWhite(password);
                boolean sw4 = Password.containNumbers(password);
                boolean sw5 = password.length() >= 8;
                if (!sw && !sw3 && !sw5) {
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.RED);
                    mostrarDatos("Recommendation #, !, ?, *...", etiquetaDatos);
                } else if (!sw2 && !sw3 && !sw5) {
                    mostrarDatos("", etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.ORANGE);
                    mostrarDatos("Recommendation capital letters A, B, C ...", etiquetaDatos);
                } else if (!sw4 && !sw3 && !sw5) {
                    mostrarDatos("", etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.ORANGE);
                    mostrarDatos("Recommendation numbers 1, 2, 3 ...", etiquetaDatos);
                } else if (sw3 && !sw5) {
                    mostrarDatos("", etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos("Not blank space ' '", etiquetaDatos);
                } else if (!sw5) {
                    mostrarDatos("", etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.RED);
                    mostrarDatos("Minimum 8 characters", etiquetaDatos);
                } else if(sw && sw2 && !sw3 && sw5) {
                    mostrarDatos("", etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.GREEN);
                    mostrarDatos("Secure password!!", etiquetaDatos);
                }else{
                    mostrarDatos("", etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.BLACK);
                    mostrarDatos(password, etiquetaDatos2);
                    etiquetaDatos.setForeground(Color.RED);
                    mostrarDatos("Error", etiquetaDatos);
                }
            }
        });

        // Configurar las restricciones para el posicionamiento de los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        panel.add(etiquetaTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(campoTexto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(botonMostrar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(etiquetaDatos2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(etiquetaDatos, gbc);

        // Agregar el panel a la ventana
        ventana.getContentPane().add(panel);

        // Configurar la acción por defecto al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana en la pantalla
        ventana.setLocationRelativeTo(null);

        // Establecer el tamaño preferido de la ventana
        ventana.setPreferredSize(new Dimension(600, 500)); // Dimensiones personalizadas (ancho: 800, alto: 700)

        // Hacer visible la ventana
        ventana.pack();
        ventana.setVisible(true);
    }

    private static void mostrarDatos(String datos, JLabel etiquetaDatos) {
        etiquetaDatos.setText("<html><div style='text-align: center;'>" + datos + "</div></html>");
    }
}

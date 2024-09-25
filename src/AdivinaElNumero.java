import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AdivinaElNumero extends JFrame {
    private JTextField textField;
    private JButton botonAdivinar;
    private JLabel labelResultado;
    private int numeroSecreto;
    private boolean juegoTerminado;

    public AdivinaElNumero() {
        setTitle("Adivina el número");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        botonAdivinar = new JButton("Adivinar");
        labelResultado = new JLabel("");

        add(new JLabel("Introduce un número entre 1 y 50:"));
        add(textField);
        add(botonAdivinar);
        add(labelResultado);

        Random random = new Random();
        numeroSecreto = random.nextInt(50) + 1;

        botonAdivinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!juegoTerminado) {
                    try {
                        int numeroUsuario = Integer.parseInt(textField.getText());
                        if (numeroUsuario < numeroSecreto) {
                            labelResultado.setText("Número muy pequeño");
                            getContentPane().setBackground(Color.YELLOW);
                        } else if (numeroUsuario > numeroSecreto) {
                            labelResultado.setText("Número muy grande");
                            getContentPane().setBackground(Color.YELLOW);
                        } else {
                            labelResultado.setText("¡Ganaste!");
                            getContentPane().setBackground(Color.GREEN);
                            juegoTerminado = true;
                            textField.setEditable(false);
                        }
                    } catch (NumberFormatException ex) {
                        labelResultado.setText("Por favor, introduce un número válido");
                    }
                } else {
                    labelResultado.setText("El juego ha terminado. ¿Quieres volver a jugar?");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdivinaElNumero().setVisible(true);
            }
        });
    }
}

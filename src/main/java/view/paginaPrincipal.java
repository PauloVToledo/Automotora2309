package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paginaPrincipal extends JFrame {
    private JButton agregarClienteButton;
    private JPanel panel1;
    private JButton agregarVehiculoButton;
    private JButton buscarVehiculoButton;

    public paginaPrincipal() {
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450, 300);
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pagina principal");
        actionListeners();
    }
    public void actionListeners(){
        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientRegistrationView clientRegistrationView=new clientRegistrationView();
                dispose();
            }
        });
        agregarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculoView agregarVehiculoView=new agregarVehiculoView();
                dispose();
            }
        });
        buscarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarVehiculoView buscarVehiculoView=new buscarVehiculoView();
                dispose();
            }
        });

    }


}
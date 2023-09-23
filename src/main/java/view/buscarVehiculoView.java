package view;

import controller.vehiculoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class buscarVehiculoView extends JFrame{
    private JPanel panel1;
    private JTextField modeloTextField;
    private JComboBox marcaComboBox;
    private JButton buscarVehiculoButton;
    private JButton regresarButton;
    public buscarVehiculoView(){
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450, 300);
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Buscar vehiculo");
        actionListeners();
        jComboOpcionesInicializadas();
    }
    public void jComboOpcionesInicializadas(){
        String[] marcas={"","Nissan","Chevrolet","Mazda"};
        for (int i = 0; i < marcas.length; i++) {
            marcaComboBox.addItem(marcas[i]);
        }

    }
    public void actionListeners(){
        buscarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo=modeloTextField.getText();
                String marca= Objects.requireNonNull(marcaComboBox.getSelectedItem()).toString();
                if(!modelo.isEmpty() && !marca.isEmpty()){
                    vehiculoController vehiculoController= new vehiculoController();
                    vehiculoController.buscarVehiculos(marca,modelo);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"Todos los datos deben ser rellenados");
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipal();
            }
        });
    }
}

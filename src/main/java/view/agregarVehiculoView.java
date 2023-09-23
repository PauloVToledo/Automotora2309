package view;

import controller.vehiculoController;
import model.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class agregarVehiculoView extends JFrame {
    private JPanel panel1;
    private JTextField modeloTextField;
    private JComboBox colorComboBox;
    private JComboBox marcaComboBox;
    private JTextField anhoTextField;
    private JTextField kilometrosTextField;
    private JButton registrarVehiculoButton;
    private JButton cancelarButton;
    private JLabel precioLabel;
    private JTextField precioTextField;

    public agregarVehiculoView(){
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450, 300);
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Regsitrar Vehiculo");
        actionListeners();
        jComboOpcionesInicializadas();
    }
    public void jComboOpcionesInicializadas(){
        String[] marcas={"","Nissan","Chevrolet","Mazda"};
        String [] colores={"","Rojo","Verde","Azul"};
        for (int i = 0; i < marcas.length; i++) {
            marcaComboBox.addItem(marcas[i]);
        }
        for (int i = 0; i <colores.length ; i++) {
            colorComboBox.addItem(colores[i]);
        }
    }
    public void actionListeners(){
        registrarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String modelo=modeloTextField.getText();
                    String marca= Objects.requireNonNull(marcaComboBox.getSelectedItem()).toString();
                    String color= Objects.requireNonNull(colorComboBox.getSelectedItem()).toString();
                    int kilometraje=Integer.parseInt((kilometrosTextField.getText().isEmpty()
                    || !kilometrosTextField.getText().matches("[0-9]+"))?"0":kilometrosTextField.getText());
                    int anho=Integer.parseInt((anhoTextField.getText().isEmpty()
                    || !anhoTextField.getText().matches("[0-9]+"))?"0":anhoTextField.getText());
                    int precio=Integer.parseInt((precioTextField.getText().isEmpty()||
                            !precioTextField.getText().matches("[0-9]+"))?"0":precioTextField.getText());
                    System.out.println(kilometraje);
                    System.out.println(anho);
                    System.out.println(precio);
                    if(!modelo.isEmpty() && !marca.isEmpty() && !color.isEmpty()
                    && kilometraje!=0 && anho!=0 && precio!=0){
                        vehiculoController  vehiculoController=new vehiculoController();
                        boolean results=vehiculoController.agregarVehiculo(
                                new Vehiculo(modelo,marca,color,anho,precio,kilometraje));
                        if(results){
                            JOptionPane.showMessageDialog(null,"El vehiculo pudo registrarse" +
                                    "correctamente");
                        }else{
                            JOptionPane.showMessageDialog(null,"Hubo un error interno," +
                                    " intente nuevamente");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Revice los datos ingresados");
                    }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipal();
                dispose();
            }
        });
    }
}

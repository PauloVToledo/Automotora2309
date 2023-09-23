package view;

import controller.clienteController;
import model.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientRegistrationView extends JFrame {
    private JTextField direccionTextField;
    private JTextField rutTextField;
    private JTextField nombreTextField;
    private JTextField emailTextField;
    private JTextField telefonoTextField;
    private JButton registrarClienteButton;
    private JButton cancelarButton;
    private JPanel jpanel1;
    private JLabel textNombre;
    private JLabel textRut;
    private JLabel textDireccion;
    private JLabel textEmail;
    private JLabel textTelefono;
    private JLabel textTitle;

    public clientRegistrationView(){
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450,300);
        setContentPane(jpanel1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registrar Clientes");
        actionListeners();
    }
    public void actionListeners(){
        registrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=nombreTextField.getText();
                String rut=rutTextField.getText();
                String direccion=direccionTextField.getText();
                String correoElectronico=emailTextField.getText();
                String telefono=telefonoTextField.getText();
                if(!nombre.isEmpty() && !rut.isEmpty() && !direccion.isEmpty()
                        && !correoElectronico.isEmpty() && !telefono.isEmpty() && correoElectronico.contains("@")) {
                    clienteController clienteController = new clienteController();
                    boolean results=clienteController.agregarCliente(new Cliente(nombre, rut, direccion, correoElectronico, telefono));
                    if(!results){
                        JOptionPane.showMessageDialog(null,"El usuario ya esta registrado");
                    }else{
                        JOptionPane.showMessageDialog(null,"El usuario fue registrado correctamente");
                    }
                }else if(!correoElectronico.contains("@")){
                    JOptionPane.showMessageDialog(null,"Ingrese un correo valido");
                }else{
                    JOptionPane.showMessageDialog(null,"Asegurese de ingresar todos los" +
                            "campos");
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

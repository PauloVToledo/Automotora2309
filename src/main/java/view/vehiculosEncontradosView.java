package view;

import model.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class vehiculosEncontradosView extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton irLaPaginaPrincipalButton;
    private JButton regresarARealizarOtraButton;
    public vehiculosEncontradosView(ArrayList<Vehiculo> vehiculosEncontrados){
        setContentPane(panel1);
        setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        setSize(450,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registrar Clientes");
        actionListeners();
        crearTabla(vehiculosEncontrados);
    }
    public void actionListeners(){
        irLaPaginaPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipal();
                dispose();
            }
        });
        regresarARealizarOtraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new buscarVehiculoView();
                dispose();
            }
        });
    }
    public void crearTabla(ArrayList<Vehiculo> vehiculosEcontrados){
        //String modelo, String marca, String color, int anho, int precio, int kilometraje
        Object[][] datos = new Object[vehiculosEcontrados.size()][6];
        for (int i = 0; i <vehiculosEcontrados.size(); i++) {
            Vehiculo vehiculo=vehiculosEcontrados.get(i);
            datos[i][0]=vehiculo.getModelo();
            datos[i][1]=vehiculo.getMarca();
            datos[i][2]=vehiculo.getColor();
            datos[i][3]=vehiculo.getAnho();
            datos[i][4]=vehiculo.getPrecio();
            datos[i][5]=vehiculo.getKilometraje();
        }

        table1.setModel(new DefaultTableModel(
                datos,
                new String[]{"Modelo","Marca","Color","Año","Precio","Kilometraje"}
        ));
    }

}

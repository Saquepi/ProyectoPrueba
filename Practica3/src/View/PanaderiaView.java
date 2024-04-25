package View;

import Controller.ComprasController;
import Controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanaderiaView {
    LoginController log = new LoginController();
    ComprasController com = new ComprasController();
    
    

    JFrame frame = new JFrame("Panaderia");
    JPanel login = new JPanel();
    JPanel comprar = new JPanel();

    JTextField userLogin = new JTextField();
    JTextField passwordLogin = new JTextField();
    JLabel userLabel = new JLabel("Usuario:");
    JLabel passwordLabel = new JLabel("Contraseña:");
    JButton aceptarLogin = new JButton("Iniciar Sesion");

    JTextField producto = new JTextField();
    JLabel productoLbl = new JLabel("Producto");
    JTextField cantidad = new JTextField();
    JLabel cantidadLbl = new JLabel("Cantidad");
    JTextField fecha = new JTextField();
    JLabel fechaLbl = new JLabel("Fecha");
    JTextField hora = new JTextField();
    JLabel horaLbl = new JLabel("Hora");
    JButton terminar = new JButton("Terminar");
    JButton agregar = new JButton("Agregar");
    JLabel producto1 = new JLabel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    JLabel producto2 = new JLabel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    JLabel producto3 = new JLabel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    public void start() {

        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);

        //login
        login.setLayout(null);

        userLabel.setBounds(200, 50, 200, 40);
        userLogin.setBounds(200, 100, 200, 40);
        passwordLogin.setBounds(200, 200, 200, 40);
        passwordLabel.setBounds(200, 150, 200, 40);
        aceptarLogin.setBounds(200, 300, 200, 40);
        aceptarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(log.checkCredentials(userLogin.getText(), passwordLogin.getText())){
                    frame.setVisible(false);
                    frame.remove(login);
                    frame.add(comprar);
                    frame.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                }
            }
        });

        login.add(userLogin);
        login.add(userLabel);
        login.add(passwordLogin);
        login.add(passwordLabel);
        login.add(aceptarLogin);

        //
        comprar.setLayout(null);
        
        producto.setBounds(50, 250, 200, 40);
        productoLbl.setBounds(50, 200, 500, 40);
        cantidad.setBounds(300, 250, 200, 40);
        cantidadLbl.setBounds(300, 200, 500, 40);
        fecha.setBounds(50, 350, 200, 40);
        fechaLbl.setBounds(50, 300, 500, 40);
        hora.setBounds(300, 350, 200, 40);
        horaLbl.setBounds(300, 300, 500, 40);
        terminar.setBounds(50, 400, 500, 40);
        terminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.terminarCompra();
                producto.setText("");
                cantidad.setText("");
                fecha.setText("");
                hora.setText("");
            }
        });
        agregar.setBounds(50, 450, 500, 40);
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String date = fecha.getText();
                String hour = hora.getText();
                String prod = producto.getText();
                String cant = cantidad.getText();
                
                
                if(com.actualizarCompra(date, hour, prod, cant)){
                    JOptionPane.showMessageDialog(null, "Producto agregado");
                }else{
                    JOptionPane.showMessageDialog(null, "Datos invalidos");
                }
                
                
                producto.setText("");
                cantidad.setText("");
                
            }
        });
        producto1.setBounds(50, 50, 500, 40);
        producto1.setText(com.getInfoProd(1));
        producto2.setBounds(50, 100, 500, 40);
        producto2.setText(com.getInfoProd(2));
        producto3.setBounds(50, 150, 500, 40);
        producto3.setText(com.getInfoProd(3));
        
        comprar.add(producto);
        comprar.add(productoLbl);
        comprar.add(cantidad);
        comprar.add(cantidadLbl);
        comprar.add(fecha);
        comprar.add(fechaLbl);
        comprar.add(hora);
        comprar.add(horaLbl);
        comprar.add(terminar);
        comprar.add(agregar);
        comprar.add(producto1);
        comprar.add(producto2);
        comprar.add(producto3);

        frame.add(login);
        frame.setVisible(true);

    }

}

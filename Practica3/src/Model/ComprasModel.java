package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComprasModel {

    Conectar con = new Conectar();

    Compra comp = new Compra();

    Producto prod1;
    Producto prod2;
    Producto prod3;

    public void initProds() {

        Connection c = con.Conectar();

        if (c != null) {
            try {
                Statement stmt = c.createStatement();
                String sql = "Select * from producto";
                ResultSet rs = stmt.executeQuery(sql);

                rs.next();
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                int precio = rs.getInt("precio_producto");
                System.out.println(id + " " + nombre + " " + precio);
                prod1 = new Producto(id, nombre, precio);

                rs.next();
                id = rs.getInt("id_producto");
                nombre = rs.getString("nombre_producto");
                precio = rs.getInt("precio_producto");
                System.out.println(id + " " + nombre + " " + precio);
                prod2 = new Producto(id, nombre, precio);

                rs.next();
                id = rs.getInt("id_producto");
                nombre = rs.getString("nombre_producto");
                precio = rs.getInt("precio_producto");
                System.out.println(id + " " + nombre + " " + precio);
                prod3 = new Producto(id, nombre, precio);
                
                con.CerrarConeccion();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public Compra getComp() {
        return comp;
    }

    public Producto getProd1() {
        return prod1;
    }

    public Producto getProd2() {
        return prod2;
    }

    public Producto getProd3() {
        return prod3;
    }

    public void insertCompra(String fecha, String hora, int cantidad, int total) {

        Connection c = con.Conectar();

        if (c != null) {
            try {
                Statement stmt = c.createStatement();
                String sql = "insert into compra(fecha_compra, hora_compra, productos_compra, total_compra) values ('" + fecha + "', '" + hora + "', " + cantidad + "," + total + ");";
                stmt.execute(sql);
                con.CerrarConeccion();

            } catch (SQLException ex) {
                Logger.getLogger(ComprasModel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        comp = new Compra();

    }
}

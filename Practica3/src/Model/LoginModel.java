
package Model;

import java.sql.*;




public class LoginModel {
    Conectar con = new Conectar();
    
    
    public boolean login(String user, String password){
        
        Connection c = con.Conectar();
        
        if(c!=null){
            
            try {
                boolean r = false;
                Statement stm = c.createStatement();
                String sql = "Select * from funcionario where usuario_funcionario= '" + user + "' and contrasena_funcionario= '" + password + "'";
                ResultSet rs = stm.executeQuery(sql);
                
                if(rs.next()){
                    r = true;
                }
                

                con.CerrarConeccion();
                return r;
            } catch (SQLException ex) {
                return false;
            }
  
        }else{
            return false;
        }

    }
    
    
    
}

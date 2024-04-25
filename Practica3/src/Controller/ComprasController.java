
package Controller;

import Model.Compra;
import Model.ComprasModel;
import Model.Producto;


public class ComprasController {
    ComprasModel compras = new ComprasModel();

    public ComprasController() {
        compras.initProds();
    }
    
    public boolean actualizarCompra(String fecha, String hora, String idProducto, String cantProd){
        Producto pTemp;
        Compra cTemp = compras.getComp();
        try {
            if(idProducto.equals("1")){
                pTemp = compras.getProd1();
            }else if(idProducto.equals("2")){
                pTemp = compras.getProd2();
            }else{
                pTemp = compras.getProd3();
            }
            
            int cantInt = Integer.parseInt(cantProd);
            
            
            cTemp.setFecha(fecha);
            cTemp.setHora(hora);
            cTemp.setCantProds(cantInt);
            cTemp.setTotal(pTemp.getPrecio());
            
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

        
    }
    
    public void terminarCompra(){
        Compra ctemp = compras.getComp();
        
        compras.insertCompra(ctemp.getFecha(), ctemp.getHora(), ctemp.getCantProds(), ctemp.getTotal());
    }
    
    public String getInfoProd(int id){
        if(id==1){
            return compras.getProd1().getInfo();
        }else if(id==2){
            return compras.getProd2().getInfo();
        }else{
            return compras.getProd3().getInfo();
        }
    }
    
}

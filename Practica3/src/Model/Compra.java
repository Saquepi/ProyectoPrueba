
package Model;


public class Compra {
    
    private String fecha ="";
    private String hora ="";
    private int cantProds = 0;
    private int total= 0;

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getCantProds() {
        return cantProds;
    }

    public int getTotal() {
        return total;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCantProds(int cantProds) {
        this.cantProds= this.cantProds + cantProds;
    }

    public void setTotal(int total) {
        this.total = this.total + total;
    }
    
    
    
    
}

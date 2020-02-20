
package objetosNegocio;

import java.sql.Date;
import java.util.Objects;


public class Salida {
    private Integer id;
    private Date fechaHora;
    private String destino;
    private Barco barco;

    public Salida() {
    }

    public Salida(Integer idSalida) {
        this.id = idSalida;
    }

    public Salida(Integer idSalida, Date fechaHora, String destino, Barco barco) {
        this.id = idSalida;
        this.fechaHora = fechaHora;
        this.destino = destino;
        this.barco = barco;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer idSalida) {
        this.id = idSalida;
    }

    public Date getFechaHora() {
        return fechaHora;
    }
//simpleDateFormat sirve para formatear dates
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }



    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }
    
    public Object[] toArray(){
        return new Object[]{
            this.getId(),
            this.getFechaHora(),
            this.getDestino(),
            this.getBarco().getId(),
            this.getBarco().toString()
           
        };
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salida other = (Salida) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salida{" + "idSalida=" + id + ", fechaHora=" + fechaHora + ", destino=" + destino +  ", barco=" + barco + '}';
    }
    
    
}

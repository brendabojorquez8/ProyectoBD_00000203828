
package objetosNegocio;

import java.util.Objects;


public class Barco {
    private Integer id;
    private String matricula;
    private String nombre;
    private Integer numAmarre;
    private Float cuota;
    private Socio socio;

    public Barco() {
    }

    public Barco(Integer id) {
        this.id = id;
    }

    public Barco(Integer id, String matricula, String nombre, Integer numAmarre, Float cuota, Socio socio) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.numAmarre = numAmarre;
        this.cuota = cuota;
        this.socio = socio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumAmarre() {
        return numAmarre;
    }

    public void setNumAmarre(Integer numAmarre) {
        this.numAmarre = numAmarre;
    }

    public Float getCuota() {
        return cuota;
    }

    public void setCuota(Float cuota) {
        this.cuota = cuota;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    
    public Object[] toArray(){
        return new Object[]{
            this.getId(),
            this.getMatricula(),
            this.getNombre(),
            this.getNumAmarre(),
            this.getCuota(),
            this.socio.getNombre(),
            this.socio.getId()
        };
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Barco other = (Barco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNombre() +(this.getSocio() == null? "":  "("+this.getSocio().getNombre()+")");
    }
    
    
    
    
}

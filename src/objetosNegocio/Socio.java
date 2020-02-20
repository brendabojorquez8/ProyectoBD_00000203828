
package objetosNegocio;

import java.util.Objects;


public class Socio {
    private Integer id;
    private String nombre;
    private String CURP;

    public Socio() {
    }

    public Socio(Integer id) {
        this.id = id;
    }
    
    public Socio(Integer id, String nombre, String CURP) {
        this.id = id;
        this.nombre = nombre;
        this.CURP = CURP;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }
    
    public Object[] toArray(){
        return new Object[]{
            this.getId(),
            this.getNombre(),
            this.getCURP()
        };
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Socio other = (Socio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
    
    
}

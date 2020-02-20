package negocios;

import datos.BarcosDAO;
import datos.SalidasDAO;
import datos.SociosDAO;
import java.util.List;
import objetosNegocio.Barco;
import objetosNegocio.Salida;
import objetosNegocio.Socio;

public class Control {

    private SociosDAO sociosDAO;
    private BarcosDAO barcosDAO;
    private SalidasDAO salidasDAO;

    public Control() {
        sociosDAO = new SociosDAO();
        barcosDAO = new BarcosDAO();
        salidasDAO = new SalidasDAO();
    }

    public List<Socio> obtenerSocios(String textoBusqueda) {
        return this.sociosDAO.obtenerSocios(textoBusqueda);
    }

    public void guardarSocio(Socio socio) {
        this.sociosDAO.guardarSocio(socio);
    }

    public Socio consultarPorId(Integer id) {
        return this.sociosDAO.consultarPorId(id);
    }

    public void actualizarSocio(Socio socio) {
        this.sociosDAO.actualizarSocio(socio);
    }

    public boolean eliminarSocio(Integer id) {
        return this.sociosDAO.eliminarSocio(id);
    }

    public List<Barco> obtenerBarcos(String textoBusqueda) {
        return this.barcosDAO.obtenerBarcos(textoBusqueda);
    }

    public void guardarBarco(Barco barco) {
        this.barcosDAO.guardarBarco(barco);
    }

    public void actualizarBarco(Barco barco) {
        this.barcosDAO.actualizarBarco(barco);
    }

    public Barco consultarBarcoPorId(Integer id) {
        return this.barcosDAO.consultarPorId(id);
    }

    public boolean eliminarBarco(Integer id) {
        return this.barcosDAO.eliminarBarco(id);
    }

    public List<Salida> obtenerSalidas(String textoBusqueda) {
        return this.salidasDAO.obtenerSalidas(textoBusqueda);
    }

    public void guardarSalida(Salida salida) {
        this.salidasDAO.guardarSalida(salida);
    }

    public void actualizarSalida(Salida salida) {
        this.salidasDAO.actualizarSalida(salida);
    }
    public Salida consultarSalidaPorId(Integer id) {
        return this.salidasDAO.consultarPorId(id);
    }
    
    public boolean eliminarSalida(Integer id) {
        return this.salidasDAO.eliminarSalida(id);
    }
}

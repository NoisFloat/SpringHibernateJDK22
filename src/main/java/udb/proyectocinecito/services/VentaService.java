package udb.proyectocinecito.services;

import udb.proyectocinecito.entity.Usuario;
import udb.proyectocinecito.entity.Venta;

import java.util.List;

public interface VentaService {
    public List<Venta> listarVentas();
    public void guardarVenta(Venta venta);
    public void eliminarVenta(Venta venta);
    public Venta encontrarVenta(Usuario usuario);

}

package udb.proyectocinecito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udb.proyectocinecito.entity.Usuario;
import udb.proyectocinecito.entity.Venta;
import udb.proyectocinecito.repository.VentaDAO;
import udb.proyectocinecito.services.VentaService;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaDAO ventaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarVentas() {
        return (List<Venta>) ventaDAO.findAll();
    }

    @Override
    public void guardarVenta(Venta venta) {
        ventaDAO.save(venta);
    }

    @Override
    public void eliminarVenta(Venta venta) {
        ventaDAO.delete(venta);
    }

    @Override
    public Venta encontrarVenta(Usuario usuario) {
        return ventaDAO.findById(usuario.getUsuarioId()).orElse(null);
    }
}

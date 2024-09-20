package udb.proyectocinecito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udb.proyectocinecito.entity.Boleto;
import udb.proyectocinecito.repository.BoletoDAO;
import udb.proyectocinecito.services.BoletoService;

import java.util.List;
@Service
public class BoletoServiceImpl implements BoletoService {

    @Autowired
    BoletoDAO boletoDAO;

    @Override
    public List<Boleto> listarBoletos() {
        return (List<Boleto>) boletoDAO.findAll();
    }

    @Override
    public void guardarBoleto(Boleto boleto) {
        boletoDAO.save(boleto);
    }

    @Override
    public void eliminarBoleto(Boleto boleto) {
        boletoDAO.delete(boleto);
    }

    @Override
    public Boleto encontrarBoleto(Boleto boleto) {
        return boletoDAO.findById(boleto.getBoleto_id()).orElse(null);
    }
}

package udb.proyectocinecito.services;
import udb.proyectocinecito.entity.Boleto;

import java.util.List;

public interface BoletoService {

    public List<Boleto> listarBoletos();

    public void guardarBoleto(Boleto boleto);

    public void eliminarBoleto(Boleto boleto);

    public Boleto encontrarBoleto(Boleto boleto);
}

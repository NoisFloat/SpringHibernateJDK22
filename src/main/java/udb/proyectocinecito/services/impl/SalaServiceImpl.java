package udb.proyectocinecito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udb.proyectocinecito.entity.Sala;
import udb.proyectocinecito.repository.SalaDAO;
import udb.proyectocinecito.services.SalaService;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {
    @Autowired
    private SalaDAO salaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Sala> listarSalas() {
        return (List<Sala>) salaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void guardarSala(Sala sala) {
        salaDAO.save(sala);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarSala(Sala sala) {
        salaDAO.deleteById(sala.getSala_id());
    }

    @Override
    @Transactional(readOnly = true)
    public Sala encontrarSala(Sala sala) {
        return salaDAO.findById(sala.getSala_id()).orElse(null);
    }
}

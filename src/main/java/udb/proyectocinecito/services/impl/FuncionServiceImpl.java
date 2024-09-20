package udb.proyectocinecito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udb.proyectocinecito.entity.Funcion;
import udb.proyectocinecito.entity.Usuario;
import udb.proyectocinecito.repository.FuncionDAO;
import udb.proyectocinecito.services.FuncionService;

import java.util.List;
@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionDAO funcionDAO;

    @Override
    public List<Funcion> listarFunciones() {
        return (List<Funcion>) funcionDAO.findAll();
    }

    @Override
    public void guardarFuncion(Funcion funcion) {
        funcionDAO.save(funcion);
    }

    @Override
    public void eliminarFuncion(Funcion funcion) {
        funcionDAO.deleteById(funcion.getFuncion_id());
    }

    @Override
    public Funcion encontrarFuncion(Usuario usuario) {
        return funcionDAO.findById(usuario.getUsuarioId()).orElse(null);
    }
}

package udb.proyectocinecito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udb.proyectocinecito.entity.Pelicula;
import udb.proyectocinecito.repository.PeliculaDAO;
import udb.proyectocinecito.services.PeliculaService;

import java.util.List;
@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> listarPeliculas() {
        return (List<Pelicula>) peliculaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula encontrarPelicula(Pelicula pelicula) {
        return peliculaDAO.findById(pelicula.getPelicula_id()).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void guardarPelicula(Pelicula pelicula) {
        peliculaDAO.save(pelicula);

    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarPelicula(Pelicula pelicula) {
        peliculaDAO.delete(pelicula);
    }
}

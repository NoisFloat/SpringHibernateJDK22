package udb.proyectocinecito.dao;

import org.springframework.data.repository.CrudRepository;
import udb.proyectocinecito.model.Pelicula;

public interface PeliculaDAO extends CrudRepository<Pelicula,Integer> {
    //Terminado
}

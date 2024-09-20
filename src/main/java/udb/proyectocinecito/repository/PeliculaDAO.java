package udb.proyectocinecito.repository;

import org.springframework.data.repository.CrudRepository;
import udb.proyectocinecito.entity.Pelicula;

public interface PeliculaDAO extends CrudRepository<Pelicula,Integer> {
    //Terminado
}

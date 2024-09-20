package udb.proyectocinecito.services;

import udb.proyectocinecito.entity.Pelicula;

import java.util.List;

public interface PeliculaService {
    public List<Pelicula> listarPeliculas();
    public Pelicula encontrarPelicula(Pelicula pelicula);
    public void guardarPelicula(Pelicula pelicula);
    public void eliminarPelicula(Pelicula pelicula);
}

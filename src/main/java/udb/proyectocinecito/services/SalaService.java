package udb.proyectocinecito.services;

import udb.proyectocinecito.entity.Sala;

import java.util.List;

public interface SalaService {
    public List<Sala> listarSalas();
    public void guardarSala(Sala sala);
    public void eliminarSala(Sala sala);
    public Sala encontrarSala(Sala sala);
}

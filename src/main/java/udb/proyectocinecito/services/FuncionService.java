package udb.proyectocinecito.services;

import udb.proyectocinecito.entity.Funcion;

import java.util.List;

public interface FuncionService {
    public List<Funcion> listarFunciones();
    public void guardarFuncion(Funcion funcion);
    public void eliminarFuncion(Funcion funcion);
    public Funcion encontrarFuncion(Funcion funcion);
}

package udb.proyectocinecito.services;

import udb.proyectocinecito.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    //Que son las interfaces???
    //Ya se, se podria decir que es para definir el comportamiento de una clase que lo implemente,
    //En otras palabras es para definir un comportamiento comun para un conjunto diferente de clases,
    //Pero con una logica distinta

    public List<Usuario> listarUsuarios();

    public void guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public Usuario encontrarUsuario(Usuario usuario);
}

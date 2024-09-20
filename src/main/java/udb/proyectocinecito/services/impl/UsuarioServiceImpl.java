package udb.proyectocinecito.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udb.proyectocinecito.entity.Usuario;
import udb.proyectocinecito.repository.UsuarioDAO;
import udb.proyectocinecito.services.UsuarioService;

import java.util.List;
//Esto se ocupara para que el contenedor principal de Spring pueda reconocer a Service, y que pueda ser Injectado como DAO
@Service
public class UsuarioServiceImpl implements UsuarioService {
    //Los servicios como tal, son para no modificar la persistencia de DAO, cuando no es necesario, lo que separa
    //el codigo y lo hace mas flexible a cambios, todos utilizando el mismo DAO

    @Autowired//Palabra especial que instancia objectos solo cuando los necesitas y los cierra cuando los necesitas
    UsuarioDAO usuarioDAO;//La tipica frase, es parte de framework

    @Override
    @Transactional(readOnly = true) //Como tal solo mejora el rendimiento //Ya que es un ORM, le estas diciendo que
    //Este metodo no hara cambio en los datos de DB, lo que conlleva a evitar bloqueos innecesarios de inseguridad,
    //para casos de solo lectura
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void guardarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(Usuario usuario) {
        Usuario user = usuarioDAO.findById(usuario.getUsuarioId()).orElse(null);
        System.out.println(user.toString());
        return user;
    }
}

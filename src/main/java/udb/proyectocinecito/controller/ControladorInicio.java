package udb.proyectocinecito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import udb.proyectocinecito.entity.Usuario;
import udb.proyectocinecito.services.*;
import jakarta.validation.*;


@Controller
public class ControladorInicio {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private FuncionService funcionService;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private BoletoService boletoService;


    @GetMapping("/")
    public String inicio(Model model) {
        String mensaje = "Hola mundo con Thymeleaf, Usando Objeto Model para manejar HttpServletRequest y Response (Implementacion propia de Spring)";
        var usuarios = usuarioService.listarUsuarios();
        var peliculas = peliculaService.listarPeliculas();
        var salas = salaService.listarSalas();
        var funciones = funcionService.listarFunciones();
        var ventas = ventaService.listarVentas();
        var boletos = boletoService.listarBoletos();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("salas", salas);
        model.addAttribute("funciones", funciones);
        model.addAttribute("ventas", ventas);
        model.addAttribute("boletos", boletos);

        return "index"; //Se encuenta en resources/templates/index.html
    }

    // Este método maneja las solicitudes GET a la ruta "/agregar".
    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {
        // Spring automáticamente inyecta un objeto Usuario vacío en este método.
        // Esto permite que se pueda usar en la vista para crear un nuevo usuario.
        return "modificar"; // Retorna la vista "modificar" para que se muestre el formulario.
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Error de validacion");
            return "modificar"; // Retorna a la vista con errores
        }
        usuarioService.guardarUsuario(usuario);
        return "redirect:/"; // O donde desees redirigir después de guardar
    }


    /*

    // Este método maneja las solicitudes GET a la ruta "/editar/{usuario_id}".
    @GetMapping("/editar/{usuario_id}")
    public String editar(Usuario usuario, Model model, @PathVariable int usuario_id) {
        // Se utiliza el servicio para encontrar al usuario basado en el ID que se pasa en la URL.
        usuario.setUsuarioId(usuario_id);
        usuario = usuarioService.encontrarUsuario(usuario);

        // Se añade el objeto usuario al modelo, para que esté disponible en la vista.
        model.addAttribute("usuario", usuario);

        // Retorna la vista "modificar", donde se mostrará el formulario con los datos del usuario.
        return "modificar";
    }


     */


    // Este método maneja las solicitudes GET a la ruta "/editar/{usuario_id}".
    @GetMapping("/editar/{usuarioId}")
    public String editar(Usuario usuario, Model model) {
        // Se utiliza el servicio para encontrar al usuario basado en el ID que se pasa en la URL.

        usuario = usuarioService.encontrarUsuario(usuario);

        // Se añade el objeto usuario al modelo, para que esté disponible en la vista.
        model.addAttribute("usuario", usuario);

        // Retorna la vista "modificar", donde se mostrará el formulario con los datos del usuario.
        return "modificar";
    }


    // Este método maneja las solicitudes GET a la ruta "/eliminar/{usuario_id}".
    @GetMapping("/eliminar/{usuario_id}")
    public String eliminar(Usuario usuario, Model model, @PathVariable int usuario_id) {
        // Se utiliza el servicio para encontrar al usuario basado en el ID que se pasa en la URL.
        // Aquí se está configurando el ID del usuario a eliminar.
        usuario.setUsuarioId(usuario_id);

        // Llama al servicio para eliminar el usuario correspondiente al ID proporcionado.
        usuarioService.eliminarUsuario(usuario);

        // Se añade el objeto usuario al modelo, para que esté disponible en la vista.
        // Este paso es opcional en este contexto, ya que estamos redirigiendo a otra vista.
        // model.addAttribute("usuario", usuario);

        // Retorna la vista "index", lo que indica que el usuario ha sido eliminado.
        return "redirect:/";
    }


    /*

    @GetMapping("/borrarFila3")
    public String borrarFila3(HttpServletRequest request, HttpServletResponse response){
        String mensaje = "Hola mundo con Rodrigo";
        peliculaService.eliminarPelicula(new Pelicula(1,"SA",s));
        //Esto es un controlador de tipo Spring MVC
        response.setContentType("text/html");
        request.setAttribute("mensaje", mensaje);
        return "index"; //Se encuenta en resources/templates/index.html
    }

    */


    /*
    @GetMapping("/")
    public String inicio(HttpServletRequest request, HttpServletResponse response){
        String mensaje = "Hola mundo con Thymeleaf, Objetos Padre de Servlet base";
        //Esto es un controlador de tipo Spring MVC
        response.setContentType("text/html");
        request.setAttribute("mensaje", mensaje);
        return "index"; //Se encuenta en resources/templates/index.html
    }*/

}
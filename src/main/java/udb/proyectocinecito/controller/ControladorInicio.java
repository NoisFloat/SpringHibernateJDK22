package udb.proyectocinecito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udb.proyectocinecito.services.*;


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
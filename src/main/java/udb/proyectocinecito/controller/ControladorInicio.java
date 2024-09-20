package udb.proyectocinecito.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udb.proyectocinecito.repository.*;
import udb.proyectocinecito.services.UsuarioService;


@Controller
public class ControladorInicio {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PeliculaDAO peliculaDAO;
    @Autowired
    private SalaDAO salaDAO;
    @Autowired
    private FuncionDAO funcionDAO;
    @Autowired
    private VentaDAO ventaDAO;
    @Autowired
    private BoletoDAO boletoDAO;



    @GetMapping("/")
    public String inicio(Model model) {
        String mensaje = "Hola mundo con Thymeleaf, Usando Objeto Model para manejar HttpServletRequest y Response (Implementacion propia de Spring)";
        var usuarios = usuarioService.listarUsuarios();
        var peliculas = peliculaDAO.findAll();
        var salas = salaDAO.findAll();
        var funciones = funcionDAO.findAll();
        var ventas = ventaDAO.findAll();
        var boletos = boletoDAO.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("salas", salas);
        model.addAttribute("funciones", funciones);
        model.addAttribute("ventas", ventas);
        model.addAttribute("boletos", boletos);

        return "index"; //Se encuenta en resources/templates/index.html
    }
    @GetMapping("/borrarFila3")
    public String borrarFila3(HttpServletRequest request, HttpServletResponse response){
        String mensaje = "Hola mundo con Rodrigo";
        peliculaDAO.deleteById(3);
        //Esto es un controlador de tipo Spring MVC
        response.setContentType("text/html");
        request.setAttribute("mensaje", mensaje);
        return "index"; //Se encuenta en resources/templates/index.html
    }

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
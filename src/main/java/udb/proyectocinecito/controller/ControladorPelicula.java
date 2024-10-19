package udb.proyectocinecito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import udb.proyectocinecito.entity.Pelicula;
import udb.proyectocinecito.services.PeliculaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pelicula")
public class ControladorPelicula {

    @Autowired
    private PeliculaService peliculaService;

    // Mostrar la lista de películas
    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("pelicula", peliculaService.listarPeliculas());
        return "pelicula/listar";// Nombre de la vista para la lista de películas (listar.html)
    }

    // Mostrar el formulario para agregar una nueva película
    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "pelicula/agregar"; // Nombre de la vista para el formulario (agregar.html)
    }

    // Guardar una nueva película o actualizar una existente
    @PostMapping("/guardar")
    public String guardarPelicula(@Valid @ModelAttribute Pelicula pelicula, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "pelicula/agregar";
        }
        peliculaService.guardarPelicula(pelicula);
        return "pelicula/listar";
    }

    // Mostrar el formulario para editar una película existente
    @GetMapping("/editar/{peliculaId}")
    public String mostrarFormularioEditar(@PathVariable("peliculaId") int peliculaId, Model model) {
        Pelicula pelicula = peliculaService.encontrarPelicula(new Pelicula(peliculaId, null, 0, null, null, null));
        if (pelicula == null) {
            return "pelicula/agregar";
        }
        model.addAttribute("pelicula", pelicula);
        return "pelicula/agregar";
    }

    // Eliminar una película
    @GetMapping("/eliminar/{peliculaId}")
    public String eliminarPelicula(@PathVariable("peliculaId") int peliculaId) {
        Pelicula pelicula = peliculaService.encontrarPelicula(new Pelicula(peliculaId, null, 0, null, null, null));
        if (pelicula != null) {
            peliculaService.eliminarPelicula(pelicula);
        }
        return "pelicula/listar";
    }
}

package udb.proyectocinecito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import udb.proyectocinecito.entity.Pelicula;
import udb.proyectocinecito.services.PeliculaService;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listarPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "peliculas/listar"; // Cambia esta ruta a vista de listado
    }

    @GetMapping("/agregar")
    public String agregarPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/agregar"; // Cambia esta ruta a vista de agregar
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas"; // Redirige a la lista después de guardar
    }

    @GetMapping("/editar/{peliculaId}")
    public String editarPelicula(@PathVariable int peliculaId, Model model) {
        Pelicula pelicula = peliculaService.encontrarPelicula(new Pelicula(peliculaId, null, 0, null, null, null));
        model.addAttribute("pelicula", pelicula);
        return "peliculas/agregar"; // Cambia esta ruta a vista de agregar
    }

    @GetMapping("/eliminar/{peliculaId}")
    public String eliminarPelicula(@PathVariable int peliculaId) {
        peliculaService.eliminarPelicula(new Pelicula(peliculaId, null, 0, null, null, null));
        return "redirect:/peliculas"; // Redirige a la lista después de eliminar
    }
}

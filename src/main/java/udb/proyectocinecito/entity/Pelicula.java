package udb.proyectocinecito.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "peliculas")//Terminado
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pelicula_id")
    private int pelicula_id;

    @Column(name = "titulo",nullable = false)
    private String titulo;

    @Column(name = "duracion",nullable = false)
    private int duracion;

    @Column(name = "clasificacion",nullable = false,length = 10)
    private String clasificacion;

    @Column(name = "descripcion",nullable = false,length = 65535)
    private String descripcion;

    @Column(name = "fecha_estreno",nullable = false)
    private Date fecha_estreno;

    public Pelicula(int pelicula_id, String titulo, int duracion, String clasificacion, String descripcion, Date fecha_estreno) {
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
        this.fecha_estreno = fecha_estreno;
    }

    public Pelicula() {

    }

    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "pelicula_id=" + pelicula_id +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_estreno=" + fecha_estreno +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return pelicula_id == pelicula.pelicula_id && duracion == pelicula.duracion && Objects.equals(titulo, pelicula.titulo) && Objects.equals(clasificacion, pelicula.clasificacion) && Objects.equals(descripcion, pelicula.descripcion) && Objects.equals(fecha_estreno, pelicula.fecha_estreno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pelicula_id, titulo, duracion, clasificacion, descripcion, fecha_estreno);
    }
}

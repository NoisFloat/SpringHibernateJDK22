package udb.proyectocinecito.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "funciones")
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "funcion_id")
    private int funcion_id;

    @ManyToOne
    @JoinColumn(name="pelicula_id", nullable=false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name="sala_id", nullable=false)
    private Sala sala;


    @Column(name = "fecha_funcion",nullable = false)
    private Date fecha_funcion;

    @Column(name = "hora_funcion",nullable = false)
    private Date hora_funcion;

    @Column(name = "precio",nullable = false)
    private double precio;

    @Column(name = "asientos_disponibles",nullable = false)
    private int asientos_disponibles;

    public Funcion() {
    }

    public Funcion(int funcion_id, Pelicula pelicula, Sala sala, Date fecha_funcion, Date hora_funcion, double precio, int asientos_disponibles) {
        this.funcion_id = funcion_id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha_funcion = fecha_funcion;
        this.hora_funcion = hora_funcion;
        this.precio = precio;
        this.asientos_disponibles = asientos_disponibles;
    }

    public int getFuncion_id() {
        return funcion_id;
    }

    public void setFuncion_id(int funcion_id) {
        this.funcion_id = funcion_id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(Date fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public Date getHora_funcion() {
        return hora_funcion;
    }

    public void setHora_funcion(Date hora_funcion) {
        this.hora_funcion = hora_funcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public void setAsientos_disponibles(int asientos_disponibles) {
        this.asientos_disponibles = asientos_disponibles;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "funcion_id=" + funcion_id +
                ", pelicula=" + pelicula +
                ", sala=" + sala +
                ", fecha_funcion=" + fecha_funcion +
                ", hora_funcion=" + hora_funcion +
                ", precio=" + precio +
                ", asientos_disponibles=" + asientos_disponibles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcion funcion = (Funcion) o;
        return funcion_id == funcion.funcion_id && Double.compare(precio, funcion.precio) == 0 && asientos_disponibles == funcion.asientos_disponibles && Objects.equals(pelicula, funcion.pelicula) && Objects.equals(sala, funcion.sala) && Objects.equals(fecha_funcion, funcion.fecha_funcion) && Objects.equals(hora_funcion, funcion.hora_funcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcion_id, pelicula, sala, fecha_funcion, hora_funcion, precio, asientos_disponibles);
    }
}

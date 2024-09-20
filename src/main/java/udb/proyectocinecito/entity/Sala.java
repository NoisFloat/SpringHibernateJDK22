package udb.proyectocinecito.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "salas")//Terminado
public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sala_id")
    private int sala_id;

    @Column(name = "num_sala",nullable = false)
    private int num_sala;

    @Column(name = "capacidad",nullable = false)
    private int capacidad;

    public Sala() {
    }

    public Sala(int sala_id, int num_sala, int capacidad) {
        this.sala_id = sala_id;
        this.num_sala = num_sala;
        this.capacidad = capacidad;
    }

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    public int getNum_sala() {
        return num_sala;
    }

    public void setNum_sala(int num_sala) {
        this.num_sala = num_sala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "sala_id=" + sala_id +
                ", num_sala=" + num_sala +
                ", capacidad=" + capacidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return sala_id == sala.sala_id && num_sala == sala.num_sala && capacidad == sala.capacidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sala_id, num_sala, capacidad);
    }
}

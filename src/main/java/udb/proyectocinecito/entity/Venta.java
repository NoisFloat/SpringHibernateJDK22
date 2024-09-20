package udb.proyectocinecito.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private int venta_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "funcion_id",nullable = false)
    private Funcion funcion;

    @Column(name = "cantidad_boletos",nullable = false)
    private int boletos;

    @Column(name = "total",nullable = false)
    private double total;
    public Venta() {

    }

    public Venta(int venta_id, Usuario usuario, Funcion funcion, int boletos, double total) {
        this.venta_id = venta_id;
        this.usuario = usuario;
        this.funcion = funcion;
        this.boletos = boletos;
        this.total = total;
    }

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public int getBoletos() {
        return boletos;
    }

    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "venta_id=" + venta_id +
                ", usuario=" + usuario +
                ", funcion=" + funcion +
                ", boletos=" + boletos +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return venta_id == venta.venta_id && boletos == venta.boletos && Double.compare(total, venta.total) == 0 && Objects.equals(usuario, venta.usuario) && Objects.equals(funcion, venta.funcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venta_id, usuario, funcion, boletos, total);
    }
}

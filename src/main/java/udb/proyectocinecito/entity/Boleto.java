package udb.proyectocinecito.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "boletos")
public class Boleto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boleto_id")
    private int boleto_id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @Column(name = "asiento_numero",nullable = false)
    private int asiento_numero;

    public Boleto() {
    }

    public Boleto(int boleto_id, Venta venta, int asiento_numero) {
        this.boleto_id = boleto_id;
        this.venta = venta;
        this.asiento_numero = asiento_numero;
    }

    public int getBoleto_id() {
        return boleto_id;
    }

    public void setBoleto_id(int boleto_id) {
        this.boleto_id = boleto_id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getAsiento_numero() {
        return asiento_numero;
    }

    public void setAsiento_numero(int asiento_numero) {
        this.asiento_numero = asiento_numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return boleto_id == boleto.boleto_id && asiento_numero == boleto.asiento_numero && Objects.equals(venta, boleto.venta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boleto_id, venta, asiento_numero);
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "boleto_id=" + boleto_id +
                ", venta=" + venta +
                ", asiento_numero=" + asiento_numero +
                '}';
    }
}

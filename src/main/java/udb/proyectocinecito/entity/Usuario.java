package udb.proyectocinecito.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Usuarios") //Terminado
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @NotEmpty(message = "Username no Valido, tiene que tener mas de 4 caracteres.")
    @NotBlank(message = "El email no puede estar vacío")
    @Size(min = 4,message = "Username muy corto, debe de tener mas de 4 caracteres")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Email(message = "Email no Valido")
    @NotBlank(message = "El email no puede estar vacío")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres")
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @NotBlank(message = "El rol no puede estar vacio")
    @Size(min = 3, message = "El rol debe de tener al menos 3 Caracteres")
    @Column(name = "rol", nullable = false)
    private String rol;


    // Getters y Setters
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "usuarioId=" + usuarioId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario persona = (Usuario) o;
        return Objects.equals(usuarioId, persona.usuarioId) &&
                Objects.equals(username, persona.username) &&
                Objects.equals(email, persona.email) &&
                Objects.equals(password, persona.password) &&
                Objects.equals(nombre, persona.nombre) &&
                Objects.equals(apellido, persona.apellido) &&
                Objects.equals(rol, persona.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, username, email, password, nombre, apellido, rol);
    }
}

package udb.proyectocinecito.util;

import org.springframework.security.crypto.bcrypt.*;

public class EncriptarPassword {
    public static void main(String[] args) {
        System.out.println(encriptarPassword("123456"));
    }
    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Contraseña sin encriptar : " + password);
        String encodedPassword = encoder.encode(password);
        System.out.println("Contraseña Encriptada : " + encodedPassword);
        return encodedPassword;
    }

}

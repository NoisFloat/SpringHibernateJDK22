package udb.proyectocinecito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoCinecitoApplication {

    public static void main(String[] args) {
        //Esto inicializa el ServerDistpatcher, que se encarga de todas las peticiones segun URL, solicitada, tipo
        //get,put,post etc
        SpringApplication.run(ProyectoCinecitoApplication.class, args);
    }

}

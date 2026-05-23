package com.example.hellolab8;

import com.example.hellolab8.enums.Status;
import com.example.hellolab8.model.Association;
import com.example.hellolab8.model.Division;
import com.example.hellolab8.model.Member;
import com.example.hellolab8.repository.AssociationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class PrSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoAssociation(AssociationRepository repository) {
        return (args) -> {
            // 1. Creamos la Asociación principal
            Association association = new Association("Nurse Association of Spain");

            // Nombres de las 7 regiones/divisiones de ejemplo
            String[] regions = {"Madrid", "Cataluña", "Andalucía", "Valencia", "País Vasco", "Galicia", "Canarias"};

            for (int i = 0; i < regions.length; i++) {
                // 2. Creamos la División
                Division division = new Division("Division " + regions[i], "District " + (i + 1));

                // 3. Creamos al menos un miembro para esta división
                Member member = new Member("Nurse " + regions[i] + " One", Status.ACTIVE, LocalDate.now().plusYears(1));

                // 4. Establecemos las relaciones usando los métodos helper y asignamos presidente
                division.addMember(member);
                division.setPresident(member); // El miembro también actúa como presidente de su división

                // 5. Añadimos la división a la asociación
                association.addDivision(division);
            }

            // 6. Al guardar la Asociación, CascadeType.ALL guardará las 7 divisiones y sus respectivos miembros en cascada.
            repository.save(association);

            System.out.println("¡Modelo de Asociación de Enfermería con 7 divisiones guardado con éxito en MySQL!");
        };
    }
}
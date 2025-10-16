package fr.dawan.gestionprojet.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class ProjectDTO {
    private Long id;

    @NotBlank(message = "Le nom du projet ne peut pas être vide.")
    private String name;

    @NotBlank(message = "La description du projet ne peut pas être vide.")
    private String description;
    private LocalDate startDate;
    private LocalDate  endDate;
    private Set<Long>  memberIds;
    // private Long taskIds;
}

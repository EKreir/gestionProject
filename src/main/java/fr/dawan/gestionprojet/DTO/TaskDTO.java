package fr.dawan.gestionprojet.DTO;

import fr.dawan.gestionprojet.model.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO {
    private Long id;

    @NotBlank(message = "Le titre de la tâche est obligatoire.")
    private String title;
    private String description;

    @NotNull(message = "Le statut de la tâche est obligatoire.")
    private TaskStatus  status;
    private LocalDate  dueDate;

    @NotNull(message = "L’identifiant du projet est obligatoire.")
    private Long  projectId;
    private Long assignedUserId;
}

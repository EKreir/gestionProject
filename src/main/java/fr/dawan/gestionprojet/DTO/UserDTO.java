package fr.dawan.gestionprojet.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank(message = "Le nom d’utilisateur est obligatoire.")
    private String username;

    @Email(message = "L’adresse e-mail n’est pas valide.")
    @NotBlank(message = "L’e-mail est obligatoire.")
    private String email;

    // roles names (ex: "CHIEF", "MEMBER)
    private Set<String> roles;
   // private Long taskIds;


}

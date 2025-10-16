package fr.dawan.gestionprojet.controller;

import fr.dawan.gestionprojet.DTO.ProjectDTO;
import fr.dawan.gestionprojet.DTO.TaskDTO;
import fr.dawan.gestionprojet.DTO.UserDTO;
import fr.dawan.gestionprojet.service.ProjectService;
import fr.dawan.gestionprojet.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/projects")
//@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProject() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.findById(id));
    }

    @GetMapping("/{projectId}/members")
    public ResponseEntity<Set<UserDTO>> getProjectMembers(@PathVariable Long projectId) {
        Set<UserDTO> members = projectService.getMembers(projectId);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{projectId}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksForProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(taskService.findByProjectId(projectId));
    }


    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO dto) {
        ProjectDTO created = projectService.create(dto);
        return ResponseEntity.created(URI.create("/api/projects/" +
                created.getId())).body(created);
    }

    @PostMapping("/{projectId}/members/{userId}")
    public ResponseEntity<ProjectDTO> addMember(@PathVariable Long projectId,@Valid @PathVariable Long userId) {
        return ResponseEntity.ok(projectService.addMember(projectId, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectDTO dto) {
        return ResponseEntity.ok(projectService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{projectId}/members/{userId}")
    public ResponseEntity<Void> removeProjectMember(@PathVariable Long projectId, @PathVariable Long userId) {
        projectService.removeMember(projectId, userId);
        return ResponseEntity.noContent().build(); // 204 NO CONTENT
    }


}

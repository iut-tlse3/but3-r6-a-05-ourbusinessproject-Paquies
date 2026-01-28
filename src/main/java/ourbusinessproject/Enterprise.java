package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;

    @NotBlank
    private String contactName;

    @NotBlank
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    /**
     * return the all the projects associate to an enterprise
     * @return
     */
    public Collection<Project> getProjects() {
        return projects;
    }

    /**
     * create the project collection
     * @param projects
     */
    public void setProjects(Collection<Project> projects){
        this.projects=projects;
    }

    /**
     * add a project to the collection
     * @param project
     */
    public void addProject(Project project) {
        if (this.projects == null) {
            this.projects = new HashSet<>();
        }
        projects.add(project);
    }

    public Enterprise(){
        this.name= null;
        this.description=null;
        this.contactEmail=null;
        this.contactName=null;
    }

    /**
     * Set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the ContactName
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Set the ContactEmail
     * @param contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Return the Id of the enterprise
     * @return
     */
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

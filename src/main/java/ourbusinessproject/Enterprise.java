package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "enterprises")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    @Size(min = 10)
    private String description;

    @Column
    @NotBlank
    private String contactName;

    @Column
    @NotBlank
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
    private Collection<Project> projects;


    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects){
        this.projects=projects;
    }

    public void addProject(Project project) {

        projects.add(project);
        project.setEnterprise(this);
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
}

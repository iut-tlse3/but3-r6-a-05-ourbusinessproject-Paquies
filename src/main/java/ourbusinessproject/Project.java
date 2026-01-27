package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank(message = "tiltle ne doit pas être vide")
    private String title;
    @Column
    private String description;

    public Project (){
        this.title=null;
        this.description=null;
    }

    /**
     * Set a title
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Set a description
     * @param description
     */
    public void setDescription(String description){
        this.description=description;
    }

    /**
     * Return the Id of the project
     * @return
     */
    public Long getId() {
        return this.id;
    }
}

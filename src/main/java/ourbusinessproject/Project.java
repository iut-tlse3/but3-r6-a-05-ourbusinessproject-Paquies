package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "tiltle ne doit pas être vide")
    private String title;
    private String description;


    @ManyToOne
    @NotNull
    private Enterprise enterprise;


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

    /**
     * Set the enterprise
     * @param enterprise
     */
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise=enterprise;
    }

    /**
     * return the enterprise of the project
     * @return
     */
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public String getTitle() {
        return this.title;
    }
}

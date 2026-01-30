package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date creationDate;
    @ManyToOne
    @NotNull
    private Enterprise enterprise;
    @ManyToOne
    @NotNull
    private Project project;

    /**
     * Set a date for the creation of the partnership
     * @param date
     */
    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    /**
     * Set an enterprise for the partnership
     * @param enterprise
     */
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise=enterprise;
    }

    /**
     * Set the project of the partnership
     * @param project
     */
    public void setProject(Project project) {
        this.project=project;
    }


    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Project getProject() {
        return project;
    }

    public Long getId() {
        return id;
    }
}

package ourbusinessproject;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Partnership {

    @NotNull
    private Date date;
    @NotNull
    private Enterprise enterprise;
    @NotNull
    private Project project;

    /**
     * Set a date for the creation of the partnership
     * @param date
     */
    public void setCreationDate(Date date) {
        this.date = date;
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
}

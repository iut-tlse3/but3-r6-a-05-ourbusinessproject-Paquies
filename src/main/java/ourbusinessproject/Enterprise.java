package ourbusinessproject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Enterprise {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 10)
    private String description;

    @NotBlank
    @NotNull
    private String contactName;

    @NotBlank
    @NotNull
    @Email
    private String contactEmail;

    public Enterprise(){
        this.name= null;
        this.description=null;
        this.contactEmail=null;
        this.contactName=null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}

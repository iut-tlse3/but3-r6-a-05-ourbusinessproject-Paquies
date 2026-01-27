package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

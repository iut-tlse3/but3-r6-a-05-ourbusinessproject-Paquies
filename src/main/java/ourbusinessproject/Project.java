package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Project {
    @NotBlank(message = "tiltle ne doit pas être vide")
    @NotNull(message = "title ne doit pas être null")
    private String title;
    private String description;

    public Project (){
        this.title=null;
        this.description=null;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description=description;
    }


}

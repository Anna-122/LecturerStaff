package edu.goncharova.entities;

import lombok.*;
import net.sf.oval.constraint.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lecturer", schema = "quiz")
public class Lecturer  extends Base {

    @Column(name = "name")
    @MinLength(value = 4, message = "Your name need minimum 4")
    @MaxLength(value = 20, message = "Your name need maximum 20 letters")
    @NotBlank(message = "Your name can't be empty")
    private String name;

    @Column(name = "surname")
    @MinLength(value = 4, message = "Your surname need minimum 4")
    @MaxLength(value = 20, message = "Your surname need maximum 20 letters")
    @NotBlank(message = "Your surname can't be empty")
    private String surname;

//    @OneToMany
//    private List<Question> questions;
//
//    @OneToMany
//    private List<Answer> answers;
}



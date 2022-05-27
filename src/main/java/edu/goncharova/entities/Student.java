package edu.goncharova.entities;

import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MinLength;
import net.sf.oval.constraint.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "student", schema = "quiz")
public class Student extends Base {

    @Column(name = "name")
    @MinLength(value = 4, message = "Your name need minimum 4")
    @MaxLength(value = 20, message = "Your name need maximum 20 letters")
    @NotBlank(message = "Your name can't be empty")
    private  String name;

    @Column(name = "surname")
    @MinLength(value = 4, message = "Your surname need minimum 4")
    @MaxLength(value = 20, message = "Your surname need maximum 20 letters")
    @NotBlank(message = "Your surname can't be empty")
    private  String surname;
}

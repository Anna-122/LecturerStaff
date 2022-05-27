package edu.goncharova.entities;

import edu.goncharova.validator.UniqueQuestion;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MinLength;
import net.sf.oval.constraint.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "questions", schema = "quiz")
public class Question extends Base{

    @Column(name = "question")
    @MinLength(value = 4, message = "Your question need minimum 4")
    @MaxLength(value = 500, message = "Your question need maximum 500 letters")
    @NotBlank(message = "Your question can't be empty")
    @CheckWith(value = UniqueQuestion.class, message = "Field is exist in database")
    private String question;

//    @ManyToOne
//    private Lecturer lecturer;
}

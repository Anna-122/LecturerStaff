package edu.goncharova.entities;

import edu.goncharova.validator.UniqueAnswer;
import edu.goncharova.validator.UniqueQuestion;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString
@Table(name = "answers", schema = "quiz")
public class Answer extends Base {

    @Column(name = "answer")
    @MinLength(value = 2, message = "Your answer need minimum 2")
    @MaxLength(value = 100, message = "Your answer need maximum 100 letters")
    @NotBlank(message = "Your answer can't be empty")
    @CheckWith(value = UniqueAnswer.class, message = "Field is exist in database")
    private String answer;

    @Column(name = "answer_boolean")
    private Boolean answerBoolean;

    @Column(name = "question_id")
    private Integer questionId;
//
//    @ManyToOne
//    private Lecturer lecturer;
}

package edu.goncharova.validator;

import edu.goncharova.entities.Answer;
import edu.goncharova.entities.Question;
import edu.goncharova.services.AnswerService;
import edu.goncharova.services.QuestionService;
import net.sf.oval.Validator;
import net.sf.oval.constraint.CheckWithCheck;
import net.sf.oval.context.OValContext;

public class UniqueAnswer implements CheckWithCheck.SimpleCheck {

    private final AnswerService answerService = new AnswerService();

    @Override
    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator) {
        Answer answer = (Answer) validatedObject;
        String answerName = answer.getAnswer();
        Answer name = answerService.getByAnswer(answerName);
        return name == null || name.getId().equals(answer.getId());
    }
}

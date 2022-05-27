package edu.goncharova.validator;

import edu.goncharova.entities.Question;
import edu.goncharova.services.QuestionService;
import net.sf.oval.Validator;
import net.sf.oval.constraint.CheckWithCheck;
import net.sf.oval.context.OValContext;

public class UniqueQuestion implements CheckWithCheck.SimpleCheck {

    private final QuestionService questionService = new QuestionService();

    @Override
    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator) {
        Question question = (Question) validatedObject;
        String questionName = question.getQuestion();
        Question name = questionService.getByQuestion(questionName);
        return name == null || name.getId().equals(question.getId());
    }
}

package edu.goncharova.services;

import edu.goncharova.dao.AnswerDAO;
import edu.goncharova.entities.Answer;
import edu.goncharova.entities.Question;
import edu.goncharova.exceptions.ValidateException;

import java.util.List;

public class AnswerService implements ServiceFactory<Answer, Integer> {

    private final AnswerDAO answerDAO = new AnswerDAO();

    @Override
    public void saveOrUpdate(Answer answer) throws ValidateException {
        validator.validate(answer);
        answerDAO.saveOrUpdate(answer);
    }

    @Override
    public void delete(Answer answer) {
        answerDAO.delete(answer);
    }

    @Override
    public Answer getById(Integer id) {
        return answerDAO.find(id);
    }

    @Override
    public List<Answer> getAllRecords() {
        return answerDAO.findAll();
    }

    public List<Answer> getAllAnswersByQuestionId(Integer id) {
        return answerDAO.findAll(id);
    }

    public Answer getByAnswer(String name) {
        return answerDAO.getByField(name);
    }
}

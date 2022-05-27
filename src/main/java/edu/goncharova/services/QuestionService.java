package edu.goncharova.services;

import edu.goncharova.dao.QuestionDAO;
import edu.goncharova.entities.Question;
import edu.goncharova.exceptions.ValidateException;

import java.util.List;

public class QuestionService implements ServiceFactory<Question, Integer> {

    private final QuestionDAO questionDAO = new QuestionDAO();

    @Override
    public void saveOrUpdate(Question question) throws ValidateException   {
        validator.validate(question);
        questionDAO.saveOrUpdate(question);
    }

    @Override
    public void delete(Question question) {
        questionDAO.delete(question);
    }

    @Override
    public Question getById(Integer questionId) {
        return questionDAO.find(questionId);
    }

    @Override
    public List<Question> getAllRecords() {
        return questionDAO.findAll();
    }

    public Question getByQuestion(String name) {
        return questionDAO.getByField(name);
    }
}



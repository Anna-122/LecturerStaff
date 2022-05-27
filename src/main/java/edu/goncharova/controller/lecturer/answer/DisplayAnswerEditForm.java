package edu.goncharova.controller.lecturer.answer;

import edu.goncharova.entities.Answer;
import edu.goncharova.exceptions.ValidateException;
import edu.goncharova.services.AnswerService;
import edu.goncharova.services.QuestionService;
import edu.goncharova.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "answer_edit", urlPatterns = {"/answer/edit"})
public class DisplayAnswerEditForm extends HttpServlet {
    private final AnswerService answerService = new AnswerService();
    private final QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));
        Integer questionId = NumberUtils.parseNumber(req.getParameter("questionId"));

        if (id != null && questionId != null) {
            req.setAttribute("answer", answerService.getById(id));
            req.setAttribute("questionId", questionId);
        }
        req.setAttribute("questions", questionService.getAllRecords());
        req.getRequestDispatcher("/WEB-INF/jsp/lecturer/answerForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId = NumberUtils.parseNumber(req.getParameter("questionId"));
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));

        Answer answer = new Answer();
        answer.setId(id);
        answer.setQuestionId(questionId);
        answer.setAnswer(req.getParameter("answer"));
        answer.setAnswerBoolean(Boolean.valueOf(req.getParameter("radioAnswer")));

        try {
            answerService.saveOrUpdate(answer);
            resp.sendRedirect("/question/answers?id=" + questionId);
        } catch (ValidateException e) {
            req.setAttribute("errors", e.getErrors());
            req.setAttribute("answer", answer);
            req.setAttribute("questionId", questionId);
            req.setAttribute("questions", questionService.getAllRecords());
            req.getRequestDispatcher("/WEB-INF/jsp/lecturer/answerForm.jsp").forward(req, resp);
        }
    }
}

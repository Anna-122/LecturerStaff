package edu.goncharova.controller.lecturer.question;

import edu.goncharova.entities.Question;
import edu.goncharova.services.QuestionService;
import edu.goncharova.utils.NumberUtils;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "question_edit", urlPatterns = {"/question/edit"})
public class DisplayQuestionEditForm extends HttpServlet {
    private final QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));
        if (id != null) {
            req.setAttribute("question", questionService.getById(id));
        }
        req.getRequestDispatcher("/WEB-INF/jsp/lecturer/lecturerForm.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Question question = new Question();
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));
        question.setId(id);
        question.setQuestion(req.getParameter("question"));
        questionService.saveOrUpdate(question);
        resp.sendRedirect("/questions");
    }
}

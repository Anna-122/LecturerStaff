package edu.goncharova.controller.lecturer.question;

import edu.goncharova.entities.Question;
import edu.goncharova.exceptions.ValidateException;
import edu.goncharova.services.QuestionService;
import edu.goncharova.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "save_question", urlPatterns = {"/question/form"})
public class SaveQuestion extends HttpServlet {
    private final QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/lecturer/lecturerForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Question question = new Question();
        question.setId(NumberUtils.parseNumber(req.getParameter("id")));
        question.setQuestion(req.getParameter("question"));
        try  {
            questionService.saveOrUpdate(question);
            resp.sendRedirect("/questions");
        } catch (ValidateException e) {
            req.setAttribute("errors", e.getErrors());
            req.setAttribute("question", question);
            req.getRequestDispatcher("/WEB-INF/jsp/lecturer/lecturerForm.jsp").forward(req, resp);
        }
    }
}



//
//@WebServlet(name = "save_question", urlPatterns = {"/question/form"})
//public class SaveQuestion extends HttpServlet {
//    private final QuestionService questionService = new QuestionService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/jsp/lecturer/lecturerForm.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        Question question = new Question();
//        question.setId(NumberUtils.parseNumber(req.getParameter("id")));
//        question.setQuestion(req.getParameter("question"));
//        questionService.saveOrUpdate(question);
//        resp.sendRedirect("/");
//    }
//}
package edu.goncharova.controller.lecturer.question;

import edu.goncharova.entities.Question;
import edu.goncharova.services.QuestionService;
import edu.goncharova.utils.NumberUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "delete_question", urlPatterns = "/question/delete")
public class DeleteQuestion extends HttpServlet {
    private final QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));

        if (id != null) {
            Question question = new Question();
            question.setId(id);
            questionService.delete(question);
            resp.sendRedirect("/questions");
        }
    }
}


//@WebServlet(name = "delete_question", urlPatterns = "/question/delete")
//public class DeleteQuestion extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //  req.getRequestDispatcher("/WEB-INF/jsp/lecturer/lectureForm.jsp").forward(req, resp);
//        req.getRequestDispatcher("/").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        LecturerService lecturerService = new LecturerService();
//
//        Integer id = NumberUtils.parseNumber(req.getParameter("id"));
//
//        if (id != null) {
//            Question question = new Question();
//            question.setId(id);
//            lecturerService.delete(question);
//            resp.sendRedirect("/");
//        }
//    }
//}



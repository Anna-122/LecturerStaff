package edu.goncharova.controller.lecturer.question;

import edu.goncharova.services.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "list_question", urlPatterns = "/questions")
public class ListOfQuestions extends HttpServlet {

    private final QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("questions", questionService.getAllRecords());
        req.getRequestDispatcher("/WEB-INF/jsp/lecturer/questionList.jsp").forward(req, resp);
    }
}


//
//
//@WebServlet(name = "list_question", urlPatterns = "/")
//public class ListOfQuestions extends HttpServlet {
//
//    private final LecturerService lecturerService = new LecturerService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer id = NumberUtils.parseNumber(req.getParameter("id"));
//        if (id != null) {
//            req.setAttribute("questions", lecturerService.getById(id));
//        }
//        req.getRequestDispatcher("/WEB-INF/jsp/lecturer/questionList.jsp").forward(req, resp);
//    }
//}
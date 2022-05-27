package edu.goncharova.controller.lecturer.answer;

import edu.goncharova.services.AnswerService;
import edu.goncharova.utils.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "list_answer", urlPatterns = "/question/answers")
public class ListOfAnswers extends HttpServlet {
    private final AnswerService answerService = new AnswerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));

        if (id != null) {
            req.setAttribute("answers", answerService.getAllAnswersByQuestionId(id));
            req.setAttribute("questionId", id);
            req.getRequestDispatcher("/WEB-INF/jsp/lecturer/answerList.jsp").forward(req, resp);
        }
        resp.sendRedirect("/questions");
    }
}



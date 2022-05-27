package edu.goncharova.controller.lecturer.answer;

import edu.goncharova.entities.Answer;
import edu.goncharova.services.AnswerService;
import edu.goncharova.utils.NumberUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_answer", urlPatterns = "/answer/delete")
public class DeleteAnswer extends HttpServlet {
    private final AnswerService answerService = new AnswerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = NumberUtils.parseNumber(req.getParameter("id"));
        Integer questionId = NumberUtils.parseNumber(req.getParameter("questionId"));

        if (id != null) {
            Answer answer = new Answer();
            answer.setId(id);
            answerService.delete(answer);
            resp.sendRedirect("/question/answers?id=" + questionId);
        }
    }
}

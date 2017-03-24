package com.domain.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wszybisty
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("SAVE".equals(action)) {
            resp.getWriter().append("Saved");
        } else {
            resp.setStatus(404);
            resp.getWriter().append("Not Found");
        }
    }
}

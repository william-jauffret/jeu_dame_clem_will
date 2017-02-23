package org.isen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jeudame.JeuDameImpl;
import org.apache.commons.lang.StringUtils;

/**
 * Servlet implementation class GameJDDServlet
 */
@WebServlet("/clicright")
public class ClicOnPionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClicOnPionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pion =request.getParameter("pion");
        String x = pion.substring(4,5);
        String y = pion.substring(5,6);
        System.out.println(x);
        System.out.println(y);
        response.setContentType("text/plain");
        response.getWriter().write(pion);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        if (request == null) {
            return "";
        }

        String token = request.getRequestURI().substring(
                request.getContextPath().length()
                        + request.getServletPath().length() + 1);

        return token;

    }
    private void redirectToGameRoot(HttpServletResponse response,
                                    HttpServletRequest request) throws IOException {
        response.sendRedirect(request.getContextPath()
                + request.getServletPath() + "/" );
    }

}
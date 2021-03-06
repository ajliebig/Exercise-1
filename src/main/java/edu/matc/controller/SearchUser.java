package edu.matc.controller;

import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchType = "";
        String searchTerm = "";

        String lastName = "lastName";


        UserData userData = new UserData();

        searchTerm = req.getParameter("search");
        searchType  = req.getParameter("searchType");

      if (lastName.equals(searchType) ) {

          req.setAttribute("usersSingle", userData.getOneUser(searchTerm ));

       } else {
            req.setAttribute("users", userData.getAllUsers());

       }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
       dispatcher.forward(req, resp);

    }
}
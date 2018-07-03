package com.first.servlet.controller.developer;

import com.first.servlet.domain.Developer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeveloperAddController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/jsp/developer-add.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String developerFirstName = request.getParameter("developerFirstName");
        String developerLastName = request.getParameter("developerLastName");

        Developer developer = new Developer();
        developer.setFirstName(developerFirstName);
        developer.setLastName(developerLastName);

        developers().create(developer);

        response.sendRedirect("/");
    }
}

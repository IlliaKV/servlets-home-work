package com.first.servlet.controller.developer;

import com.first.servlet.domain.Developer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeveloperEditController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long developerId = Long.parseLong(request.getParameter("idDeveloper"));
        Developer developer = getDeveloperById(developerId);

        request.setAttribute("developer", developer);

        request.getRequestDispatcher("/jsp/developer-edit.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long developerId = Long.parseLong(request.getParameter("idDeveloper"));
        Developer developer = getDeveloperById(developerId);

        String firstName = request.getParameter("developerFirstName");
        String lastName = request.getParameter("developerLastName");

        developer.setFirstName(firstName);
        developer.setLastName(lastName);

        updateDeveloper(developer);

        response.sendRedirect("/");
    }
}

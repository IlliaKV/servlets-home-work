package com.first.servlet.controller.developer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeveloperDeleteController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long developerId = Long.parseLong(request.getParameter("idDeveloper"));
        developers().deleteById(developerId);

        response.sendRedirect("/");
    }
}

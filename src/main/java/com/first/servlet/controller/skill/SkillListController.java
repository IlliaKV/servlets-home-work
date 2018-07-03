package com.first.servlet.controller.skill;

import com.first.servlet.domain.Skill;
import com.first.servlet.domain.Developer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class SkillListController extends SkillAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long developerId = Long.parseLong(request.getParameter("idDeveloper"));
        Developer developer = developers().getById(developerId);

        Set<Skill> skills = developer.getSkills();

        request.setAttribute("developer", developer);
        request.setAttribute("skills", skills);

        System.out.println("In controller");

        request.getRequestDispatcher("/jsp/skill-list.jsp").forward(request, response);
    }
}

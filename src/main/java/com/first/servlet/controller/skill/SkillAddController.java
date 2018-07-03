package com.first.servlet.controller.skill;

import com.first.servlet.domain.Skill;
import com.first.servlet.domain.Developer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkillAddController extends SkillAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("idDeveloper", request.getParameter("idDeveloper"));
        request.getRequestDispatcher("/jsp/skill-add.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nameSkill = request.getParameter("nameSkill");
        String levelSkill = request.getParameter("levelSkill");
        long idDeveloper = Long.parseLong(request.getParameter("idDeveloper"));

        Developer developer = developers().getById(idDeveloper);

        Skill skill = new Skill();
        skill.setDeveloper(developer);
        skill.setNameSkill(nameSkill);
        skill.setLevelSkill(levelSkill);
        developer.getSkills().add(skill);

        developers().update(developer);

        response.sendRedirect("/developer/skills?idDeveloper=" + idDeveloper);
    }
}

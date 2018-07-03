package com.first.servlet.controller.skill;

import com.first.servlet.controller.Controller;
import com.first.servlet.domain.Skill;
import com.first.servlet.domain.Developer;
import com.first.servlet.repository.CrudRepository;
import com.first.servlet.service.CrudRepositoryService;
import com.first.servlet.service.ServiceRepository;

public class SkillAbstractController extends Controller {
    protected CrudRepository<Skill, Long> skills() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getInstance().getService(CrudRepositoryService.class);
        CrudRepository<Skill, Long> skillRepository = crudRepositoryService.getRepository(Skill.class);
        return skillRepository;
    }

    protected Skill getSkillById(long id) {
        return skills().getById(id);
    }

    protected void updateDeveloper(Skill skill) {
        skills().update(skill);
    }

    protected CrudRepository<Developer, Long> developers() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getInstance().getService(CrudRepositoryService.class);
        CrudRepository<Developer, Long> developerRepository = crudRepositoryService.getRepository(Developer.class);
        return developerRepository;
    }

    protected Developer getDeveloperById(long id) {
        return developers().getById(id);
    }

    protected void updateDeveloper(Developer developer) {
        developers().update(developer);
    }
}

package com.first.servlet.controller.developer;

import com.first.servlet.controller.Controller;
import com.first.servlet.domain.Developer;
import com.first.servlet.repository.CrudRepository;
import com.first.servlet.service.CrudRepositoryService;
import com.first.servlet.service.ServiceRepository;

public class DeveloperAbstractController extends Controller {
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

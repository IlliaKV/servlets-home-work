package com.first.servlet.controller;

import com.first.servlet.domain.Developer;
import com.first.servlet.repository.CrudRepository;
import com.first.servlet.service.CrudRepositoryService;
import com.first.servlet.service.ServiceRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IndexController extends Controller {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getInstance().getService(CrudRepositoryService.class);
        CrudRepository<Developer, Long> developerRepository = crudRepositoryService.getRepository(Developer.class);

        List<Developer> developers = developerRepository.listAll();
        request.setAttribute("developers", developers);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

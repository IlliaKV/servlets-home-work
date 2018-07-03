package com.first.servlet.controller;

import com.first.servlet.controller.developer.DeveloperAddController;
import com.first.servlet.controller.developer.DeveloperDeleteController;
import com.first.servlet.controller.developer.DeveloperEditController;
import com.first.servlet.controller.skill.SkillAddController;
import com.first.servlet.controller.skill.SkillListController;
import com.first.servlet.service.ServiceRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter({"/*", "/**"})
public class FrontController implements Filter {
    private Map<String, Controller> handlers;

    public void init(FilterConfig filterConfig) throws ServletException {
        ServiceRepository.getInstance();

        handlers = new HashMap<String, Controller>();
        handlers.put("/", new IndexController());

        handlers.put("/developer_edit", new DeveloperEditController());
        handlers.put("/developer_delete", new DeveloperDeleteController());
        handlers.put("/developer_add", new DeveloperAddController());

        handlers.put("/developer/skills", new SkillListController());
        handlers.put("/developer/skill_add", new SkillAddController());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletRequest.setCharacterEncoding("UTF-8");

        String uri = httpServletRequest.getRequestURI();

        if (uri.endsWith(".jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            try {
                handlers.get(uri).process(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {}
}

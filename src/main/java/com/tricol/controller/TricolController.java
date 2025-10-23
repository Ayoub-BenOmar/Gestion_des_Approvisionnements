package com.tricol.controller;

import com.tricol.service.TricolService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TricolController implements Controller {
    private TricolService tricolService;

    public void setTricolService(TricolService tricolService) {
        this.tricolService = tricolService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}

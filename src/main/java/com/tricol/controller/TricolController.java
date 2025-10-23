package com.tricol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tricol.model.Tricol;
import com.tricol.service.TricolService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.io.BufferedReader;
import java.util.List;

public class TricolController implements Controller {
    private TricolService tricolService;

    public void setTricolService(TricolService tricolService) {
        this.tricolService = tricolService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();

        if ("GET".equalsIgnoreCase(request.getMethod())){
            String paramId = request.getParameter("id");

            if (paramId != null){
                int id = Integer.valueOf(paramId);
                Tricol tricol = tricolService.getById(id);
                mapper.writeValue(response.getWriter(), tricol);
            }else {
                List<Tricol> tricols = tricolService.getAll();
                mapper.writeValue(response.getWriter(), tricols);
            }
            return null;
        }

        if("POST".equalsIgnoreCase(request.getMethod())){
            BufferedReader bufferedReader = request.getReader();
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            String body = stringBuilder.toString();
            Tricol tricol = mapper.readValue(body, Tricol.class);
            tricolService.save(tricol);
            ModelAndView view = new ModelAndView("jsonView");
            return view.addObject("Message", body);
        }

        if ("PUT".equalsIgnoreCase(request.getMethod())){
            String paramId = request.getParameter("id");
            if (paramId != null){
                int id = Integer.valueOf(paramId);
                BufferedReader reader = request.getReader();
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null){
                    stringBuilder.append(line);
                }
                String body = stringBuilder.toString();

                Tricol tricol = mapper.readValue(body, Tricol.class);
                tricolService.update(id, tricol);
                ModelAndView view = new ModelAndView("jsonView");
                return view.addObject("Message", body);
            }else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return null;
            }
        }

        if ("DELETE".equalsIgnoreCase(request.getMethod())){
            String paramId = request.getParameter("id");
            if (paramId != null){
                int id = Integer.valueOf(paramId);
                tricolService.delete(id);
                response.getWriter().write("{\"status\":\"deleted\"}");
                return null;
            }else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return null;
            }
        }

        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return null;
    }
}

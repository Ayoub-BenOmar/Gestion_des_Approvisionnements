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
    private ObjectMapper mapper; // inject it

    public void setTricolService(TricolService tricolService) {
        this.tricolService = tricolService;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method)) {
            String paramId = request.getParameter("id");

            if (paramId != null) {
                int id = Integer.parseInt(paramId);
                Tricol tricol = tricolService.getById(id);
                mapper.writeValue(response.getWriter(), tricol);
            } else {
                List<Tricol> tricols = tricolService.getAll();
                mapper.writeValue(response.getWriter(), tricols);
            }
            return null;
        }

        if ("POST".equalsIgnoreCase(method)) {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            Tricol tricol = mapper.readValue(sb.toString(), Tricol.class);
            tricolService.save(tricol);

            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\":\"Tricol saved successfully\"}");
            return null;
        }

        if ("PUT".equalsIgnoreCase(method)) {
            String paramId = request.getParameter("id");
            if (paramId != null) {
                int id = Integer.parseInt(paramId);

                BufferedReader reader = request.getReader();
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                Tricol tricol = mapper.readValue(sb.toString(), Tricol.class);
                tricolService.update(id, tricol);

                response.getWriter().write("{\"message\":\"Tricol updated successfully\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"message\":\"ID parameter is required for PUT\"}");
            }
            return null;
        }

        if ("DELETE".equalsIgnoreCase(method)) {
            String paramId = request.getParameter("id");
            if (paramId != null) {
                int id = Integer.parseInt(paramId);
                tricolService.delete(id);

                response.getWriter().write("{\"message\":\"Tricol deleted successfully\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"message\":\"ID parameter is required for DELETE\"}");
            }
            return null;
        }

        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        response.getWriter().write("{\"message\":\"Method not allowed\"}");
        return null;
    }
}

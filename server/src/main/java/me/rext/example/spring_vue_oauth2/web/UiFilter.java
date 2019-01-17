package me.rext.example.spring_vue_oauth2.web;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UiFilter extends OncePerRequestFilter {

    private static final String WEBJARS_UI = "/webjars/app-ui";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath().replaceFirst("/ui/?", "/");

        if (path.length() == 1) {
            path = "/index.html";
        }

        path = WEBJARS_UI + path;

        String queryString = request.getQueryString();
        if (queryString != null) {
            path += queryString;
        }
        request.getRequestDispatcher(path).forward(request, response);
    }
}

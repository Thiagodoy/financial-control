package com.personal.financial.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.financial.exception.TokenInvalidException;
import com.personal.financial.resource.response.AppErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.personal.financial.utils.ConstantsError.*;


@Component
public class TokenExpiredFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        AppErrorResponse error = null;

        try {
            chain.doFilter(request, response);
        } catch (ExpiredJwtException expiredJwtException) {

            error = new AppErrorResponse(
                    "3.0",
                    APPLICATION_ERROR_001,
                    NO_PERMISSION_ERROR,
                    DCMS_EXCEPTION,
                    null,
                    expiredJwtException.getMessage()
            );
            writeResponseErro(error, response);
        } catch (TokenInvalidException e) {
            error = new AppErrorResponse(
                    "3.0",
                    APPLICATION_ERROR_002,
                    INVALID_TOKEN,
                    DCMS_EXCEPTION,
                    null,
                    e.getMessage()
            );
            writeResponseErro(error, response);
        }

    }

    private void writeResponseErro(AppErrorResponse error, HttpServletResponse response) {
        try {
            response.setHeader("Content-Type", "application/json");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(convertObjectToJson(error));
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getCause().getMessage());
        }
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }

        return new ObjectMapper().writeValueAsString(object);
    }
}

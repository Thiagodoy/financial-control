/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.financial.utils;

import br.com.odontoprev.dcmsassociado.dto.AppError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static br.com.odontoprev.dcmsassociado.dto.ConstantsError.*;

/**
 *
 * @author thiag
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        AppError error = new AppError(
                "3.0",
                ODONTOPREV_ERROR_004,
                NO_PERMISSION_ERROR_4,
                DCMS_EXCEPTION,
                "Acesso negado!",
                authException.getMessage()
        );
        writeResponseErro(error, response);
    }


    private void writeResponseErro(AppError error, HttpServletResponse response) {
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

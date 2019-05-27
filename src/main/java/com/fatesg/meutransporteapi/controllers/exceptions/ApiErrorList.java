package com.fatesg.meutransporteapi.controllers.exceptions;

import java.util.Date;
import java.util.List;


public class ApiErrorList extends ApiError {

    private static final long serialVersionUID = 1L;

    private List<String> erros;

    public ApiErrorList(int value, String defaultMessage, Date date, List<String> errors) {
    }
}

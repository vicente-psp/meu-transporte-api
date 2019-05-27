package com.fatesg.meutransporteapi.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ApiErrorList extends ApiError {

    private static final long serialVersionUID = 1L;

    private List<String> erros;

}

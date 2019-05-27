package com.fatesg.meutransporteapi.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ApiError implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private Date date;

}
package com.sitis.gestionusuariosbackend.common;

public class Constants {
    private Constants() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    //GENERAL
    public static final String UTILITY_CLASS = "Utility class";

    //EXCEPCIONES
    public static final Integer BAD_REQUEST_STATUS = 400;
    public static final String APPLICATION_EXCEPTION = "Application Exception";
    public static final String DATA_EXCEPTION = "Data Exception";
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "Constraint Violation Exception";

    //MENSAJES
    public static final String ERROR_PERFIL = "El perfil ingresado no es valido";
    public static final String ERROR_USUARIO_EXISTENTE = "El usuario ya se encuentra registrado";
    public static final String ERROR_CREDENCIALES = "credenciales incorrectas";
}

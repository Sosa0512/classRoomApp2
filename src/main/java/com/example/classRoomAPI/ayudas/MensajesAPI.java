package com.example.classRoomAPI.ayudas;

public enum MensajesAPI {
    ERROR_DOCENTE_NO_ENCONTRADO("El docente que buscas, no esta en la base de datos."),
    ERROR_ESTUDIANTE_NO_ENCONTRADO("El estudiante que buscas,  no esta en la base de datos."),
    ERROR_CURSO_NO_ENCONTRADO("El curso que buscas, no esta en la base de datos."),
    ERROR_CALIFICACION_NO_ENCONTRADO("La calificacion que buscas, no esta en la base de datos."),
    ERROR_ASISTENCIA_NO_ENCONTRADO("La asistencia que buscas, no esta en la base de datos."),
    ERROR_INSCRIPCION_NO_ENCONTRADO("La inscripcion que buscas, no esta en la base de datos."),
    ERROR_MATERIA_NO_ENCONTRADO("La materia que buscas, no esta en la base de datos."),
    ERROR_USUARIO_NO_ENCONTRADO("El usuario que buscas, no esta en la base de datos.")
    ;
    private String mensaje;

    MensajesAPI(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

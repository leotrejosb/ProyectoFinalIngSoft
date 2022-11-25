package com.plan.turismo.exception;

public class UsuarioFoundExcep extends Exception{

    public UsuarioFoundExcep(){
        super("El usuario con ese username ya existe, ingrese otro diferente");
    }

    public UsuarioFoundExcep(String mensaje){
        super(mensaje);
    }
}

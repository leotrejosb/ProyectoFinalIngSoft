package com.plan.turismo.exception;

public class UsuarioNotFoundExcep extends Exception{

    public UsuarioNotFoundExcep(){
        super("El usuario con ese no username ya existe, ingrese otro diferente");
    }

    public UsuarioNotFoundExcep(String mensaje){
        super(mensaje);
    }
}

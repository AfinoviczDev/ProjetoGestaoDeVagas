package dev.afinovicz.GestaoDeVagas.exception;

public class UserFoundException extends RuntimeException{

    public UserFoundException() {
        super("Usuário já existe");
    }
}

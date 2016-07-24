package net.sokontokoro_factory.yoshinani.exception;

public class FileIOException extends RuntimeException{
    public FileIOException(String message){
        super(message);
    }
    public FileIOException(String message, Throwable t){
        super(message, t);
    }
}

package br.com.fuctura.biblioteca.excepentions;

    // frase de quando nao tiver mais categoria
    public class ObjectNotFoundException extends RuntimeException{

        public ObjectNotFoundException(String message) {
            super (message);
        }
    }

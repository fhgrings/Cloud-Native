package com.github.fhgrings.hystrixdatabase.model;


public class Song {

    private String nome;
    private String album;
    private String cantor;

    public Song(String nome, String album, String cantor) {
        this.nome = nome;
        this.album = album;
        this.cantor = cantor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }


    @Override
    public String toString() {
        return "Nome : " + nome + " Album: " + album + " Cantor: " + cantor;
    }

}

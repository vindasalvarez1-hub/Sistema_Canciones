/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author PC
 */
public class Cancion {
    private int id;
    private int userId;  // Clavee
    private String titulo;
    private String artista;

    public Cancion(int id, int userId, String titulo, String artista) {
        this.id = id;
        this.userId = userId;
        this.titulo = titulo;
        this.artista = artista;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "[" + id + "] 🎵 " + titulo + " - " + artista;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import Modelos.*;

/**
 *
 * @author PC
 */
public class GestorCanciones {
    private static final String FILE_PATH = "canciones.json";
    private static final Gson gson = new Gson();

    public static List<Cancion> cargarCanciones() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Cancion>>(){}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void guardarCanciones(List<Cancion> canciones) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(canciones, writer);
        } catch (IOException e) {
            System.out.println("Error guardando canciones: " + e.getMessage());
        }
    }


    public static List<Cancion> obtenerCancionesUsuario(int userId) {
        List<Cancion> todas = cargarCanciones();
        List<Cancion> propias = new ArrayList<>();
        for (Cancion c : todas) {
            if (c.getUserId() == userId) {
                propias.add(c);
            }
        }
        return propias;
    }

    public static void agregarCancion(int userId, String titulo, String artista) {
        List<Cancion> canciones = cargarCanciones();
        int nuevoId = canciones.size() + 1;
        Cancion nueva = new Cancion(nuevoId, userId, titulo, artista);
        canciones.add(nueva);
        guardarCanciones(canciones);
    }

    public static boolean eliminarCancion(int userId, int cancionId) {
        List<Cancion> canciones = cargarCanciones();
        boolean eliminada = canciones.removeIf(c -> c.getId() == cancionId && c.getUserId() == userId);
        if (eliminada) guardarCanciones(canciones);
        return eliminada;
    }

    public static boolean editarCancion(int userId, int cancionId, String nuevoTitulo, String nuevoArtista) {
        List<Cancion> canciones = cargarCanciones();
        for (Cancion c : canciones) {
            if (c.getId() == cancionId && c.getUserId() == userId) {
                c.setTitulo(nuevoTitulo);
                c.setArtista(nuevoArtista);
                guardarCanciones(canciones);
                return true;
            }
        }
        return false;
    }

}

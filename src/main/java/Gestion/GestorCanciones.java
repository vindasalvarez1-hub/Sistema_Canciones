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

}

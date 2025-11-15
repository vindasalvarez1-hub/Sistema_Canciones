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
public class GestorUsuarios {
    private static final String FILE_PATH = "usuarios.json";
    private static final Gson gson = new Gson();
    
    public static List<Usuario> cargarUsuarios() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Usuario>>(){}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            System.out.println("Error guardando usuarios: " + e.getMessage());
        }
    }
    public static Usuario login(String nombre, String password) {
        List<Usuario> usuarios = cargarUsuarios();
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public static Usuario registrar(String nombre, String password) {
        List<Usuario> usuarios = cargarUsuarios();
        int nuevoId = usuarios.size() + 1;
        Usuario nuevo = new Usuario(nuevoId, nombre, password);
        usuarios.add(nuevo);
        guardarUsuarios(usuarios);
        return nuevo;
    }

}

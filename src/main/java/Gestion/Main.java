/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author PC
 */
import java.util.*;
import Modelos.*;
import Gestion.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioActual = null;

        System.out.println("🎶 Bienvenido al Sistema de Canciones 🎶");
        System.out.println("1. Login");
        System.out.println("2. Registrar");
        System.out.print("Seleccione opción: ");
        int opcion = sc.nextInt(); sc.nextLine();

        if (opcion == 1) {
            System.out.print("Usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Contraseña: ");
            String pass = sc.nextLine();
            usuarioActual = GestorUsuarios.login(nombre, pass);
            if (usuarioActual == null) {
                System.out.println("❌ Usuario o contraseña incorrectos.");
                return;
            }
        } else if (opcion == 2) {
            System.out.print("Nuevo usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Contraseña: ");
            String pass = sc.nextLine();
            usuarioActual = GestorUsuarios.registrar(nombre, pass);
            System.out.println("✅ Usuario registrado con éxito.");
        }

       
    }
}

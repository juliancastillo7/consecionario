package org.example;

import org.example.dao.PersonaDAOImpl;
import org.example.model.Persona;
import org.example.util.Conexion;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection conexion =
                Conexion.obtenerConexion();

        if (conexion == null) {

            System.out.println("ERROR DE CONEXION");

            return;
        }

        PersonaDAOImpl personaDAO =
                new PersonaDAOImpl(conexion);

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("     MENU PERSONAS     ");
            System.out.println("1. Añadir persona");
            System.out.println("2. Ver personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Salir");

            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido1: ");
                    String apellido1 = sc.nextLine();

                    System.out.print("Apellido2: ");
                    String apellido2 = sc.nextLine();

                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    Persona persona =
                            new Persona(
                                    0,
                                    nombre,
                                    apellido1,
                                    apellido2,
                                    dni
                            );

                    personaDAO.insertar(persona);

                    break;

                case 2:

                    System.out.println("LISTA DE PERSONAS");

                    personaDAO.listar().forEach(p ->

                            System.out.println(
                                    p.getId() + " | " +
                                            p.getNombre() + " | " +
                                            p.getApellido1() + " | " +
                                            p.getApellido2() + " | " +
                                            p.getDni()
                            )
                    );

                    break;

                case 3:

                    System.out.print("ID a eliminar: ");

                    int id =
                            sc.nextInt();

                    personaDAO.eliminar(id);

                    break;

                case 4:

                    System.out.println("SALIENDO...");
                    break;

                default:

                    System.out.println("OPCION INVALIDA");
            }

        } while (opcion != 4);
    }
}
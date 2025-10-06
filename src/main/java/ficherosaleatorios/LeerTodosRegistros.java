package ficherosaleatorios;

import java.io.*;

public class LeerTodosRegistros {

    static int longitudRegistro = 34;
    static File fichero = new File("datos/AleatorioEmpleados.dat");

    public static void main(String[] args) {

        try
        {
            RandomAccessFile file = new RandomAccessFile(fichero, "r");

            int id;
            short dep;
            double salario;

            for (; ; ) { // recorro el fichero

                id = file.readInt(); // obtengo id de empleado

                // recorro uno a uno los caracteres del apellido
                char apellido[] = new char[10], aux;
                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar();
                    apellido[i] = aux; // los voy guardando en el array
                }
                // convierto a String el array
                String apellidos = new String(apellido);

                dep = file.readShort(); // obtengo dep
                salario = file.readDouble(); // obtengo salario

                if (id > 0)
                    System.out.printf("ID: %s, Apellido: %s, Departamento: %d, "
                                    + "Salario: %,9.2f %n", id, apellidos.trim(), dep,
                            salario);

                // Si he recorrido todos los bytes salgo del for
                if (file.getFilePointer() == file.length())
                    break;

            } // fin bucle for

            file.close(); // cerrar fichero
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}

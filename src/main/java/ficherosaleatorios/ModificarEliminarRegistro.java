package ficherosaleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificarEliminarRegistro {
    static int LONGITUD_REGISTRO = 34;
    static File fichero = new File("datos/AleatorioEmpleados.dat");

    public static void main(String[] args)  {

        System.out.println("antes de modificar");
        int identificador = 4;// id a modificar

        verRegistro(identificador);

        try
        {
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            long posicion = (identificador - 1) * LONGITUD_REGISTRO;
            posicion = posicion + 4 + 20; // calcular posición del departamento
            file.seek(posicion);

            file.writeShort(40); // modificar departamento

            double antiguo = file.readDouble();
            double nuevosalario= 300 + antiguo;

            posicion = file.getFilePointer()-8;// calcular posicion del salario
            file.seek(posicion);

            file.writeDouble(nuevosalario);// modificar salario
            file.close(); // cerrar fichero

            System.out.println("Después de modificar");
            verRegistro(identificador);
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

        borrarRegistro(4);
        verRegistro(4);
    }


    private static void verRegistro(int id)
    {
        try
        {
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            long posicion = (id - 1) * LONGITUD_REGISTRO;

            if (posicion >= file.length())
                System.out.printf("ID: %d, NO EXISTE.%n", id);
            else {
                file.seek(posicion); // nos posicionamos
                int idf = file.readInt(); // obtengo id de empleado

                if (idf == id) {
                    // obtener apellido
                    char apellido[] = new char[10], aux;
                    for (int i = 0; i < apellido.length; i++) {
                        aux = file.readChar();//
                        apellido[i] = aux;
                    }
                    String apellidoS = new String(apellido).trim();// convierto a String el array

                    short dep = file.readShort(); // obtener departamento
                    double salario = file.readDouble(); // obtener salario

                    System.out.printf("ID: %d, Apellido: %s, Departamento: %d, Salario: %,9.2f%n", id, apellidoS, dep,
                            salario);
                } else {
                    System.out.printf("ID: %d, NO EXISTE, ES UN HUECO.%n", id);
                }
            }

            file.close();
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

    private static void borrarRegistro(int identificador)
    {
        int id;	//id del empleado a eliminar

        long posicion = (identificador - 1) * LONGITUD_REGISTRO;

        try
        {
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            //si dentro del rango del fichero existente
            if (posicion < fichero.length() && posicion >= 0)
            {
                //mueve apuntador del fichero a la posición=(iden-1)*lreg;
                file.seek(posicion);
                id = file.readInt();
                if (id != -1)
                {
                    id = -1; //marcamos como borrado lógico
                    //hay que reescribir ese id
                    file.seek(posicion);
                    file.writeInt(id);
                    System.out.println("Eliminando empleado: " + identificador);
                }
                else {
                    System.out.println("No existe el empleado: " + identificador);
                }
            }
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

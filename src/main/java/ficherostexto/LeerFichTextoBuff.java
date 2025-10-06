/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherostexto;


import java.io.*;
public class LeerFichTextoBuff 
{

    public static void main(String[] args) 
    {
       
        File fichero = new File("c:" + File.separator + "tmp" + File.separator + "FichTexto2.txt");
        try 
        {
            //montamos un buffer sobre FileReader
            FileReader fr=new FileReader(fichero);
            BufferedReader br=new BufferedReader(fr);
            
            //BufferedReader br = new BufferedReader(new FileReader(fichero));
            
            
            String linea;
            //lee una línea del fichero
            while ((linea = br.readLine()) != null) 
            {
                System.out.println(linea);
            }
            
            br.close();
            fr.close();
        } 
        catch (FileNotFoundException fn) 
        {
            System.out.println("No se encuentra el fichero");
            System.out.println(fn.getMessage());
        } 
        catch (IOException io) 
        {
            System.out.println("Error de E/S");
            System.out.println(io.getMessage());
        } 
        
    }
}
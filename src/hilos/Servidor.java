
package hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.portable.OutputStream;


public class Servidor {
    
    
    public static void main(String[] args) {
        try {
            // 1. Establecer el servidor
            ServerSocket servidor = new ServerSocket(8000);
            System.out.println("Esperando conexiones"); 
            
            //2. Aceptar conexion      
            Socket cliente = servidor.accept();            
            System.out.println("Se conecto un cliente");
            
            //Abrir IO
            InputStream flujoEntrada = cliente.getInputStream();
            java.io.OutputStream flujoSalida = cliente.getOutputStream();
            
            //Usar decoradores convertir bytes en texto
            BufferedReader entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
            
            PrintWriter salida = new PrintWriter(flujoSalida, true);
            String mensaje = "";
            while(true){
                mensaje = entrada.readLine();
                salida.println("Eco " + mensaje);
            }
            //entrada.close();            
            //salida.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

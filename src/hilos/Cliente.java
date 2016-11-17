
package hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {
    
    public static void main(String[] args) {
        try {
            //1. Establecer comunicacion con sevidor
            Socket cliente = new Socket("localhost" , 8000);
            
            //Abrir IO
            InputStream flujoEntrada = cliente.getInputStream();
            java.io.OutputStream flujoSalida = cliente.getOutputStream();
            
            //Usar decoradores convertir bytes en texto
            BufferedReader entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
            
            PrintWriter salida = new PrintWriter(flujoSalida, true);
            
            //Flujo para capturar datos del teclado
            
            BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            String mensajeAEnviar = "";
            String mensajeRecibir = "";
            while(true){
                System.out.println("Enviar:");
                mensajeAEnviar = datosUsuario.readLine();
                salida.println(mensajeAEnviar);
                mensajeRecibir = entrada.readLine();
                System.out.println(mensajeRecibir);
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
            
    }
}

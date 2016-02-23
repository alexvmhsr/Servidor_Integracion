/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_integracion.TCP;

import com.espe.distribuidas.jdni.ejb.ClienteJDNIServicioRemote;
import com.espe.distribuidas.protocolocajero.pc.Mensaje;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author PabloA
 */
public class HiloServer extends Thread{
    
    private static Integer idGlobal = 0;
    
    private DataOutputStream output;
    private DataInputStream input;
    private Socket socket;
    
    public HiloServer(Socket socket){
        this.socket = socket;
    }
    //Metodo que invoca el ebj remoto de el login
    public void EjbRemotoLogin(String usuario, String clave){
        InitialContext ctx = null;
        try {
            

            Properties prop = new Properties();
            
            prop.put("org.omg.CORBA.ORBInitialHost", "10.16.164.119");
            prop.put("org.omg.CORBA.ORBInitialPort", "3700");
            prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            ctx = new InitialContext(prop);
            ClienteJDNIServicioRemote bean = (ClienteJDNIServicioRemote) ctx.lookup("java:global/E-banking-ear/E-banking-ejb-1/ClienteJDNIServicio!com.espe.distribuidas.jdni.ejb.ClienteJDNIServicioRemote");
            System.out.println("Esta logeado: " + bean.loginEmpleado(usuario, clave));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("1726247950"));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("123456780"));
            //System.out.println("Deposito: " +bean.realizarDeposito("123456780", "10.00", "1726247950"));
            
        } catch (Exception ex) {

            System.out.println("FATAL ERROR: --- ");
            ex.printStackTrace();
        } finally {
            close_context(ctx);

        }
    }
        //Metodo que invoca el ebj remoto dde la consulta de cuentas
    public void EjbRemotoConsulta(String cuenta){
        InitialContext ctx = null;
        try {
            

            Properties prop = new Properties();
            
            prop.put("org.omg.CORBA.ORBInitialHost", "10.16.164.119");
            prop.put("org.omg.CORBA.ORBInitialPort", "3700");
            prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            ctx = new InitialContext(prop);
            ClienteJDNIServicioRemote bean = (ClienteJDNIServicioRemote) ctx.lookup("java:global/E-banking-ear/E-banking-ejb-1/ClienteJDNIServicio!com.espe.distribuidas.jdni.ejb.ClienteJDNIServicioRemote");
            //System.out.println("Esta logeado: " + bean.loginEmpleado(usuario, clave));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("1726247950"));
            System.out.println("Cliente: " + bean.consultarCuentaCliente(cuenta));
            //System.out.println("Deposito: " +bean.realizarDeposito("123456780", "10.00", "1726247950"));
            
        } catch (Exception ex) {

            System.out.println("FATAL ERROR: --- ");
            ex.printStackTrace();
        } finally {
            close_context(ctx);

        }
    }
        //Metodo que invoca el ebj remoto de la operacion deposito
    public void EjbRemotoDeposito(String cuenta,String monto,String cedula){
        InitialContext ctx = null;
        try {
            

            Properties prop = new Properties();
            
            prop.put("org.omg.CORBA.ORBInitialHost", "10.16.164.119");
            prop.put("org.omg.CORBA.ORBInitialPort", "3700");
            prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            ctx = new InitialContext(prop);
            ClienteJDNIServicioRemote bean = (ClienteJDNIServicioRemote) ctx.lookup("java:global/E-banking-ear/E-banking-ejb-1/ClienteJDNIServicio!com.espe.distribuidas.jdni.ejb.ClienteJDNIServicioRemote");
            //System.out.println("Esta logeado: " + bean.loginEmpleado(usuario, clave));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("1726247950"));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente(cuenta));
            System.out.println("Deposito: " +bean.realizarDeposito(cuenta, monto, cedula));
            
        } catch (Exception ex) {

            System.out.println("FATAL ERROR: --- ");
            ex.printStackTrace();
        } finally {
            close_context(ctx);

        }
    }
        //Metodo que invoca el ebj remoto de la operacion retiro
    public void EjbRemotoRetiro(String cuenta,String monto,String cedula){
        InitialContext ctx = null;
        try {
            

            Properties prop = new Properties();
            
            prop.put("org.omg.CORBA.ORBInitialHost", "10.16.164.119");
            prop.put("org.omg.CORBA.ORBInitialPort", "3700");
            prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            prop.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            ctx = new InitialContext(prop);
            ClienteJDNIServicioRemote bean = (ClienteJDNIServicioRemote) ctx.lookup("java:global/E-banking-ear/E-banking-ejb-1/ClienteJDNIServicio!com.espe.distribuidas.jdni.ejb.ClienteJDNIServicioRemote");
            //System.out.println("Esta logeado: " + bean.loginEmpleado(usuario, clave));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("1726247950"));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente(cuenta));
            System.out.println("Retiro: " +bean.realizarRetiro(cuenta, monto, cedula));
            
        } catch (Exception ex) {

            System.out.println("FATAL ERROR: --- ");
            ex.printStackTrace();
        } finally {
            close_context(ctx);

        }
    }

    private static void close_context(Context ctx) {
        if (ctx != null) {
            try {
                ctx.close();
            } catch (Exception ex) {   //    
                ex.printStackTrace();
            }
        }
    
    
    }
    
    @Override
    public void run(){
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("Conexion Establecida: " + this.idGlobal);
        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            try {
                System.out.println("Esperando datos...");
                String trama = this.input.readUTF();
                System.out.println("Datos recibidos...");
                System.out.println("Trama --> " + trama);
                
                if(trama.equals("FIN")){
                    break;
                }
                
                String idMensaje = trama.substring(39,49);
                System.out.println("idMensaje: " + idMensaje);
                
                String contenido=trama.substring(85);
                switch(idMensaje){
                    case Mensaje.AUTENTIC_USER:
                        
                        System.out.println(contenido);
                        String[] user= contenido.split(" ", 2);
                        String usuario= user[0];
                        String clave = user[1].trim();
                        System.out.println("Usuario: " +usuario+" Clave: "+clave);
                        EjbRemotoLogin(usuario, clave);
                        
                    break;
                    
                    case Mensaje.CONSULTAR_CUENTA:
                        
                        System.out.println(contenido);
                        String[] consultar= contenido.split(" ", 2);                        
                        String cuenta = consultar[0].trim();
                        System.out.println("Cuenta: " +cuenta);
                        EjbRemotoConsulta(cuenta);
                    break;
                        
                    
                    case Mensaje.DEPOSITO:
                        if(Mensaje.validaHash(trama)){
                            System.out.println("Operacion desposito");
                        }
                    break;
                    
                    case Mensaje.RETIRO:
                        if(Mensaje.validaHash(trama)){
                            System.out.println("Operacion retiro");
                        }
                    break;
                    
                    default:
                        System.out.println("Operacion no encontrada");
                    break;
                }
                
            } catch (Exception e) {
            }
        }
    }
    
}

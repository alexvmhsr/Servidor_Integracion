/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_integracion.RMI;

import com.espe.distribuidas.jdni.ejb.ClienteJDNIServicioRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author PabloA
 */
public class CoreJdniCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
            System.out.println("Esta logeado: " + bean.loginEmpleado("mzapata", "root"));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("1726247950"));
            //System.out.println("Cliente: " + bean.consultarCuentaCliente("123456780"));
            System.out.println("Deposito: " +bean.realizarDeposito("123456780", "10.00", "1726247950"));
            
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
    
}


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jona
 */
public class ClienteNoticias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        	try {
			Interfaces service =  (Interfaces) Naming.lookup("rmi://127.0.0.1:5000/service");	
  
                
                        Login login = new Login(service);
                        login.setVisible(true);
                        
			//System.out.println(service.sumar(4));			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
    
}

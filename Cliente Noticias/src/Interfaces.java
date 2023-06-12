
import java.rmi.Remote;
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
public interface Interfaces extends Remote{
    
    public String Login(String Usuario, String Clave) throws RemoteException;
    
     public String PublicarNoticia(String NombreUnico, String Titular, String FechaCreacion, String FechaActualizacion, String Autor, String Contenido) throws RemoteException;
    
      public String BuscarNoticia(String NombreNoticia) throws RemoteException;
      
      public String[] LeerNoticia(String noticia_A_Leer) throws RemoteException;
      
            public String Buscar_Mi_Noticia(String noticia_A_Leer) throws RemoteException;
            
               public String[] Leer_Mi_Noticia(String noticia_A_Leer) throws RemoteException;
               
                    public String Eliminar_Mi_Noticia (String noticia_A_Eliminar) throws RemoteException;
                    
                    public String Admin_EliminarNoticia (String Noticia_Eliminar) throws RemoteException;;
                    
                    public String Admin_ModificarNoticia (String NombreUnico, String Titular, String FechaCreacion, String FechaActualizacion, String Autor, String Contenido, String noticia_A_Leer) throws RemoteException;
}

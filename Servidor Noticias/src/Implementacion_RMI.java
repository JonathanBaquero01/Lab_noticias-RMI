
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jona
 */
public class Implementacion_RMI extends UnicastRemoteObject implements Interfaces  {
    String UsuarioP ="";
    
    protected Implementacion_RMI() throws RemoteException {
	}
	private static final long serialVersionUID = 1L;

    @Override
    public String Login(String Usuario, String Clave) throws RemoteException {
               
      String Respuesta ="";//vasriable q guardara la rta al cliente

        try {
           
            //vere si la carpeta de recibo esta creada en el usuario actual, si no la creo
              File  Carpeta = new File("BD/Usuarios/" + Usuario);//ruta donde creare la carpeta
              
           
               //si la carpeta no existe
               if (!Carpeta.exists()) {
                   Respuesta="El usuario no existe";
               }
         
               else{
                     
               
                 FileReader lector = new FileReader("BD/Usuarios/"+Usuario+"/Clave.txt");
            BufferedReader Br = new BufferedReader(lector);
       String bfRead;
             bfRead = Br.readLine();          
            
          lector.close();
          
       
    
          if( bfRead.equals(Clave)){
             UsuarioP =Usuario;
              Respuesta="OK";
    
                  //por ultimo vere su rol
               lector = new FileReader("BD/Usuarios/"+Usuario+"/Rol.txt");
             Br = new BufferedReader(lector);
             Respuesta = Respuesta+Br.readLine();          
            
          lector.close();
              System.out.println("Servidor-Login");
          }
          
          else{
              
               Respuesta="Clave incorrecta";
    
          }
          
      
          
            
        }
        } catch (Exception e) {
            System.out.println(e);
        }
		return Respuesta;
    }

    @Override
    public String PublicarNoticia(String NombreUnico, String Titular, String FechaCreacion, String FechaActualizacion, String Autor, String Contenido) throws RemoteException {
   
       
        String Respuesta ="";
        try {
             //Guardare la noticia 
            FileWriter archivo = new FileWriter("BD/Usuarios/" + UsuarioP+"/Noticias/"+NombreUnico+".txt", false);//el false es para q reemplace el archivo y creee uno nuevo, el true escribe sobre el q ya esta
              PrintWriter printWriter = new PrintWriter(archivo);

            printWriter.println(NombreUnico);    
                 printWriter.println(Titular);    
                      printWriter.println(FechaCreacion);    
                           printWriter.println(FechaActualizacion);    
                                printWriter.println(Autor);  
                                  printWriter.println(Contenido);  
            archivo.close();
            Respuesta= "OK";
            System.out.println("Servidor-PublicarNoticia");
            
        } catch (Exception e) {
        }
        
        return Respuesta;
     
    }

    @Override
    public String BuscarNoticia(String NombreNoticia) throws RemoteException {
       	String Respuesta ="";
        String Usuario_Dueño_Noticia="";
        File Carpeta_Por_Usuario = new File("BD/Usuarios");
       //hare  un doble for, el primero recorrera cada carpeta de cada usuario
       
      
        for (File file : Carpeta_Por_Usuario.listFiles()) {
           //en file.getname me dara la carpeta de cad ausuario
            File Carpeta_Por_Usuario_Noticias = new File("BD/Usuarios/"+file.getName()+"/Noticias");
            
            
           //compruebo si la carpeta donde estan las noticias existe, ya q la de los admins no tendran la carpeta noticias
            if(Carpeta_Por_Usuario_Noticias.exists()){
                //aqui guardo el usuario dueño de la noticia
                Usuario_Dueño_Noticia=file.getName().replace("BD/Usuarios/", "");
                
               //en el 2do ya como se como se llama el usuario por su carpeta, ire hasta su carpeta noticias y cogere todas las noticias
          for (File file2 : Carpeta_Por_Usuario_Noticias.listFiles()) {
      
              
              Respuesta=Respuesta+Usuario_Dueño_Noticia+"-"+file2.getName()+"\n";
        }
            }
            
         
            
            
        }
        Respuesta=Respuesta.replace(".txt", "");
             System.out.println("Servidor-BuscarNoticia");
        return Respuesta;

    }

    @Override
    public String[] LeerNoticia(String noticia_A_Leer) throws RemoteException {
   String NombreUnico="";
    String Titular="";
      String FechaCreacion="";
      String FechaActualizacion="";
       String Autor="";
   String Contenido="";
    int contador =0;
   try {
         String AutorNoticia="";
                String NombreNoticia="";
                AutorNoticia=noticia_A_Leer;
                 contador=noticia_A_Leer.length();
                
                //aqui descompongo la cadena pa hallar al autor de la noticia
        for (int i = 0; i < noticia_A_Leer.length(); i++) {
            AutorNoticia= AutorNoticia.substring(0,contador);
            if(AutorNoticia.contains("-")==false){
                break;
              
            }
            contador--;
        }
        //y aqui simplemente todo el nombre de la noticia le quito  el nombre del autor
       NombreNoticia=noticia_A_Leer.replace(AutorNoticia+"-", "");
       
       
       
       
       
       
       
       
       
       //aqui ahora meto todos los datos de la noticia a un array y lo mando a la app
                  FileReader lector = new FileReader("BD/Usuarios/"+AutorNoticia+"/Noticias/"+NombreNoticia+".txt");
            BufferedReader Br = new BufferedReader(lector);      
            String bfRead;
            while ((bfRead = Br.readLine()) != null) {
        
            NombreUnico= bfRead;
              
             Titular=  Br.readLine();     
       FechaCreacion=  Br.readLine();
             FechaActualizacion=  Br.readLine();           
             Autor=  Br.readLine();
           Contenido=  Br.readLine();
          
               
                       
         }
              lector.close();
              
              
        } catch (Exception e) {
            System.out.println(e);
        }
             
   
   
  
        String  [] Respuesta={NombreUnico,Titular,FechaCreacion,FechaActualizacion,Autor,Contenido};
     System.out.println("Servidor-LeerNoticia");
        
        return Respuesta;
        
    }

    @Override
    public String Buscar_Mi_Noticia(String noticia_A_Leer) throws RemoteException {
        	String Respuesta ="";
        String Usuario_Dueño_Noticia="";
        File CarpetaUsuario = new File("BD/Usuarios/"+UsuarioP+"/Noticias");

          Usuario_Dueño_Noticia=UsuarioP;
            
            
           //compruebo si la carpeta donde estan las noticias existe, ya q la de los admins no tendran la carpeta noticias
            if(CarpetaUsuario.exists()){
     
                
               //en el 2do ya como se como se llama el usuario por su carpeta, ire hasta su carpeta noticias y cogere todas las noticias
          for (File file : CarpetaUsuario.listFiles()) {
      
              
              //Respuesta=Respuesta+file.getName()+"\n";
               Respuesta=Respuesta+Usuario_Dueño_Noticia+"-"+file.getName()+"\n";
        }
            }
            
         
            
            
        
        Respuesta=Respuesta.replace(".txt", "");
             System.out.println("Servidor-BuscarNoticia");
        return Respuesta;
    }

    @Override
    public String[] Leer_Mi_Noticia(String noticia_A_Leer) throws RemoteException {
  String NombreUnico="";
    String Titular="";
      String FechaCreacion="";
      String FechaActualizacion="";
       String Autor="";
   String Contenido="";
    int contador =0;
   try {
         String AutorNoticia="";
                String NombreNoticia="";
                AutorNoticia=noticia_A_Leer;
                 contador=noticia_A_Leer.length();
                
                //aqui descompongo la cadena pa hallar al autor de la noticia
        for (int i = 0; i < noticia_A_Leer.length(); i++) {
            AutorNoticia= AutorNoticia.substring(0,contador);
            if(AutorNoticia.contains("-")==false){
                break;
              
            }
            contador--;
        }
        //y aqui simplemente todo el nombre de la noticia le quito  el nombre del autor
       NombreNoticia=noticia_A_Leer.replace(AutorNoticia+"-", "");
       
       
       
       
       
       
       
       
       
       //aqui ahora meto todos los datos de la noticia a un array y lo mando a la app
                  FileReader lector = new FileReader("BD/Usuarios/"+AutorNoticia+"/Noticias/"+NombreNoticia+".txt");
            BufferedReader Br = new BufferedReader(lector);      
            String bfRead;
            while ((bfRead = Br.readLine()) != null) {
        
            NombreUnico= bfRead;
              
             Titular=  Br.readLine();     
       FechaCreacion=  Br.readLine();
             FechaActualizacion=  Br.readLine();           
             Autor=  Br.readLine();
           Contenido=  Br.readLine();
          
               
                       
         }
              lector.close();
              
              
        } catch (Exception e) {
            System.out.println(e);
        }
             
   
   
  
        String  [] Respuesta={NombreUnico,Titular,FechaCreacion,FechaActualizacion,Autor,Contenido};
    
        System.out.println("Servidor-LeerNoticia");
        
        return Respuesta;
    }

    @Override
    public String Eliminar_Mi_Noticia(String noticia_A_Eliminar) throws RemoteException {
        String Respuesta ="";
    int contador =0;
     Respuesta ="";
   try {
       
  
       
       //aqui ahora meto todos los datos de la noticia a un array y lo mando a la app
                 File NoticiaEliminar = new File("BD/Usuarios/"+UsuarioP+"/Noticias/"+noticia_A_Eliminar+".txt");
     NoticiaEliminar.delete();
              Respuesta="OK";
              
        } catch (Exception e) {
            System.out.println(e);
        }
   
        System.out.println("Servidor-EliminarNoticia");
        return Respuesta;
       
    }

    @Override
    public String Admin_EliminarNoticia(String Noticia_Eliminar) {
         int contador =0;
         String Respuesta ="";
        try {
               String AutorNoticia="";
                String NombreNoticia="";
                AutorNoticia=Noticia_Eliminar;
                 contador=Noticia_Eliminar.length();
                
                //aqui descompongo la cadena pa hallar al autor de la noticia
        for (int i = 0; i < Noticia_Eliminar.length(); i++) {
            AutorNoticia= AutorNoticia.substring(0,contador);
            if(AutorNoticia.contains("-")==false){
                break;
              
            }
            contador--;
        }
        //y aqui simplemente todo el nombre de la noticia le quito  el nombre del autor
       NombreNoticia=Noticia_Eliminar.replace(AutorNoticia+"-", "");
       
       File NoticiaEliminar = new File("BD/Usuarios/"+AutorNoticia+"/Noticias/"+NombreNoticia+".txt");
     NoticiaEliminar.delete();
            
     Respuesta ="OK";
            
        } catch (Exception e) {
        }
        
          System.out.println("Servidor-EliminarNoticia");
        return Respuesta;
        
    }

    @Override
    public String Admin_ModificarNoticia(String NombreUnico, String Titular, String FechaCreacion, String FechaActualizacion, String Autor, String Contenido, String noticia_A_Leer) throws RemoteException {
    int contador=0;
         String AutorNoticia="";
                String NombreNoticia="";
                AutorNoticia=noticia_A_Leer;
                 contador=noticia_A_Leer.length();
                
                //aqui descompongo la cadena pa hallar al autor de la noticia
        for (int i = 0; i < noticia_A_Leer.length(); i++) {
            AutorNoticia= AutorNoticia.substring(0,contador);
            if(AutorNoticia.contains("-")==false){
                break;
              
            }
            contador--;
        }
        //y aqui simplemente todo el nombre de la noticia le quito  el nombre del autor
       NombreNoticia=noticia_A_Leer.replace(AutorNoticia+"-", "");
 
    


        String Respuesta ="";
        try {
             //Guardare la noticia 
            FileWriter archivo = new FileWriter("BD/Usuarios/" + AutorNoticia+"/Noticias/"+NombreNoticia+".txt", false);//el false es para q reemplace el archivo y creee uno nuevo, el true escribe sobre el q ya esta
              PrintWriter printWriter = new PrintWriter(archivo);

            printWriter.println(NombreUnico);    
                 printWriter.println(Titular);    
                      printWriter.println(FechaCreacion);    
                           printWriter.println(FechaActualizacion);    
                                printWriter.println(Autor);  
                                  printWriter.println(Contenido);  
            archivo.close();
            Respuesta= "OK";
            
        } catch (Exception e) {
        }
          System.out.println("Servidor-ModificarNoticia");
        
        return Respuesta;
    }
        
        
	
    
}

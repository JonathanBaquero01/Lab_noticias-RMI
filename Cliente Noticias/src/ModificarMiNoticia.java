
import PlaceHolder.PlaceHolder;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jona
 */
public class ModificarMiNoticia extends javax.swing.JFrame {

   private Interfaces service;
    private String noticia_A_Leer;
    public ModificarMiNoticia(Interfaces service, String noticia_A_Leer) {
        initComponents();
        
          this.service = service;
           this.noticia_A_Leer = noticia_A_Leer;

          this.setLocationRelativeTo(this); // para que este en el centro de la pantalla
       
              PlaceHolder placeholder = new PlaceHolder("Nombre unico", jTextFieldNombreUnico);//aqui le asigon l oq se vera en el text q se borra al escribir
        placeholder = new PlaceHolder("Titular", jTextFieldTitular);
         placeholder = new PlaceHolder("Autor", jTextFieldAutor);
                placeholder = new PlaceHolder("CONTENIDO", jTextAreaContenido);
         try {
         
       String[] Respuesta_LeerMiNoticia = Leer_Mi_Noticia(noticia_A_Leer);
       
       jTextFieldNombreUnico.setText(Respuesta_LeerMiNoticia[0]);
       jTextFieldTitular.setText(Respuesta_LeerMiNoticia[1]);
       FechaHOY.setText(Respuesta_LeerMiNoticia[2]);
       FechaModificacion.setText(Respuesta_LeerMiNoticia[3]);
       jTextFieldAutor.setText(Respuesta_LeerMiNoticia[4]);
       jTextAreaContenido.setText(Respuesta_LeerMiNoticia[5]);
            
        } catch (Exception e) {
        }
                
    }

    public String[] Leer_Mi_Noticia(String noticia_A_Leer) throws RemoteException{
          String[] Respuesta_LeerNoticia = service.Leer_Mi_Noticia(noticia_A_Leer);
       
     return Respuesta_LeerNoticia;
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNombreUnico = new javax.swing.JTextField();
        jTextFieldTitular = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        FechaHOY = new javax.swing.JLabel();
        FechaModificacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContenido = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldNombreUnico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTextFieldTitular.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Fecha creacion:");

        FechaHOY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FechaHOY.setText("Fecha creacion:");

        FechaModificacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FechaModificacion.setText("Fecha Modificacion:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha modificacion");

        jTextFieldAutor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTextAreaContenido.setColumns(20);
        jTextAreaContenido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextAreaContenido.setLineWrap(true);
        jTextAreaContenido.setRows(5);
        jTextAreaContenido.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaContenido);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaHOY)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaModificacion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextFieldNombreUnico, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                                .addComponent(jTextFieldTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jButton1)
                .addGap(183, 183, 183)
                .addComponent(jButtonEliminar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreUnico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FechaHOY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FechaModificacion))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
        String NombreUnico= jTextFieldNombreUnico.getText();
        String Titular =jTextFieldTitular.getText();
        String FechaCreacion = FechaHOY.getText();
 String FechaActualizacion = FechaModificacion.getText();
 String Autor = jTextFieldAutor.getText();
 String Contenido = jTextAreaContenido.getText();

       String Respuesta= publicarNoticia(NombreUnico, Titular,FechaCreacion,FechaActualizacion,Autor,Contenido);
       
       if(Respuesta.contains("OK")){
               JOptionPane.showMessageDialog(null, "<html><b><span style=\"font-size:1.2em\">Noticia modificada UwU</b> ", "UwU", JOptionPane.INFORMATION_MESSAGE);
           this.dispose();
       }
       
       else{
       JOptionPane.showMessageDialog(null, "<html><b><span style=\"font-size:1.2em\">Vuelve a intentarlo</b> ", "✘✘✘", JOptionPane.INFORMATION_MESSAGE);
       }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
              String NombreNoticia = jTextFieldNombreUnico.getText();
        String Respuesta= Eliminar_Mi_Noticia(NombreNoticia);
        if(   "OK".equals(Respuesta)){
     JOptionPane.showMessageDialog(null, "<html><b><span style=\"font-size:1.2em\">Se elimino la noticiaUwU</b> ", "UwU", JOptionPane.INFORMATION_MESSAGE);
           this.dispose();
     }
        
        } catch (Exception e) {
        }
      
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    public String publicarNoticia(String NombreUnico, String Titular, String FechaCreacion, String FechaActualizacion, String Autor, String Contenido) throws RemoteException{
   
     String Respuesta_PublicarNoticia = service.PublicarNoticia( NombreUnico,  Titular,  FechaCreacion,  FechaActualizacion,  Autor,  Contenido);
       
     return Respuesta_PublicarNoticia;
    
    }
    
    public String Eliminar_Mi_Noticia(String NombreNoticia) throws RemoteException{
     String Respuesta_EliminarNoticia = service.Eliminar_Mi_Noticia(NombreNoticia);
       
     return Respuesta_EliminarNoticia;
     
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PublicarNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PublicarNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PublicarNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PublicarNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FechaHOY;
    private javax.swing.JLabel FechaModificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaContenido;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldNombreUnico;
    private javax.swing.JTextField jTextFieldTitular;
    // End of variables declaration//GEN-END:variables
}

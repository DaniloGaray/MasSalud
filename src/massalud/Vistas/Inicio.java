/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package massalud.Vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Cintia
 */
public class Inicio extends javax.swing.JFrame {

  private Timer tiempo;
  int cont = 0;
  public final static int TWO_SECOND = 200;
  private javax.swing.JLabel cargandoLabel; // Etiqueta para mostrar "Cargando..."

  /**
   * Creates new form Inicio
   */
  public Inicio() {
    initComponents();
     setIconImage(new ImageIcon(getClass().getResource("/massalud/Recursos/icon.jpeg")).getImage());
    setLocationRelativeTo(null);
   

    // Inicializar el temporizador y comenzarlo
    tiempo = new Timer(TWO_SECOND, new timerListener());
    tiempo.start();

    // Configurar la barra de progreso
    Barra.setMinimum(0);
    Barra.setMaximum(100);
    Barra.setValue(0);
    // Configurar la etiqueta "Cargando..."
    cargandoLabel = new javax.swing.JLabel("Cargando...");
    cargandoLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
    cargandoLabel.setForeground(Color.gray);
    cargandoLabel.setBounds(425, 495, 250, 40); // Establece la posición de la etiqueta
    inicio.add(cargandoLabel); // Agrega la etiqueta al JDesktopPane
    cargandoLabel.setVisible(true); // Asegura que la etiqueta sea visible inicialmente
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icono=new ImageIcon(getClass().getResource("/massalud/Recursos/f1.jpg"));
        Image imagen=icono.getImage();
        inicio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        inilog = new javax.swing.JLabel();
        Barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inilog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/logo.gif"))); // NOI18N

        Barra.setBackground(new java.awt.Color(255, 102, 102));
        Barra.setForeground(new java.awt.Color(0, 255, 204));

        inicio.setLayer(inilog, javax.swing.JLayeredPane.DEFAULT_LAYER);
        inicio.setLayer(Barra, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inilog, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(386, 386, 386))
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(inilog, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  class timerListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      cont++;
      Barra.setValue(cont);
      cargandoLabel.setText("Cargando... " + cont + "%");
      if (cont == 100) {
        tiempo.stop();
        esconderB();
        Login log = new Login();
        log.setVisible(true);
        setVisible(false);

      }
    }
  }

  public void esconderB() {
    this.setVisible(false);
  }

  public void activarB() {
    tiempo.start();
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
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Inicio().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Barra;
    private javax.swing.JDesktopPane inicio;
    private javax.swing.JLabel inilog;
    // End of variables declaration//GEN-END:variables
}

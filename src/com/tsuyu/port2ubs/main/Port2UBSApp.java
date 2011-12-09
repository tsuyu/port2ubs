/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kospek.port2ubs.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author tsuyu
 */
public class Port2UBSApp {
    /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(Port2UBSApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
               Logger.getLogger(Port2UBSApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
               Logger.getLogger(Port2UBSApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
               Logger.getLogger(Port2UBSApp.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                new Port2UBSGui().setVisible(true);   
            }
         }
}

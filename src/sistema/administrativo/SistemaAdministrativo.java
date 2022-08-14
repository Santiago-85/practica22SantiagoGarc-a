/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.administrativo;

import javax.swing.JFrame;


public class SistemaAdministrativo {

    
    public static void main(String[] args) {
        
        Ventana marco = new Ventana();
        marco.setVisible(true);
        marco.setTitle("Sistema Administrativo De Clientes y Recursos");
        marco.setSize(450, 350);
        marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

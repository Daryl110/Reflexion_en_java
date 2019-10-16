/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eam.lenguajes_formales.reflection.Controllers;

import eam.lenguajes_formales.reflection.Views.FrmMain;
import java.awt.EventQueue;

/**
 *
 * @author daryl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrmMain ventanaPrincipal = new FrmMain();

        EventQueue.invokeLater(() -> {
            ventanaPrincipal.setLocationRelativeTo(null);
            ventanaPrincipal.setVisible(true);
        });
    }

}

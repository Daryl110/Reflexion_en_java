/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eam.lenguajes_formales.reflection.Controllers;

import com.google.common.reflect.ClassPath;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author daryl
 */
public class CtlApp {

    public String PACKAGE_PREFIX = "eam.lenguajes_formales.reflection.";
    public String paquete = "";

    public DefaultComboBoxModel cargarPaquete(String nombrePaquete) {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccione Clase");

        this.paquete = nombrePaquete;

        try {
            ClassPath classpath = ClassPath.from(Thread.currentThread().getContextClassLoader());
            classpath.getTopLevelClasses(this.PACKAGE_PREFIX + this.paquete).forEach((info) -> {
                model.addElement(info.getSimpleName());
            });
        } catch (IOException ex) {
            Logger.getLogger(CtlApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }

    public DefaultComboBoxModel cargarAtributosClase(String nombreClase) {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccione Atributos");

        Class clase;

        try {
            clase = Class.forName(this.PACKAGE_PREFIX + this.paquete + "." + nombreClase);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CtlApp.class.getName()).log(Level.SEVERE, null, e);
            return model;
        }

        Field[] atributos = clase.getFields();

        for (Field atributo : atributos) {
            System.out.println(atributo.getName());
            model.addElement(atributo.getName());
        }

        return model;
    }
}

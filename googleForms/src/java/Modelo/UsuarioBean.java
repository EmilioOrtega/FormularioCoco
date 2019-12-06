/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.*;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {
    private int id;
    private String nombre;
    private String contra;
    
    public UsuarioBean(){
        
    }
    public UsuarioBean(int id, String nombre, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.contra = contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
     
    public void setUsuario(){
        FacesContext context = FacesContext.getCurrentInstance();
        ResultadoBean rb = context.getApplication().evaluateExpressionGet(context, "#{resultadoBean}", ResultadoBean.class);
        rb.setNombre(this.nombre);
        //rb.setContra(this.contra);
    }
     
}

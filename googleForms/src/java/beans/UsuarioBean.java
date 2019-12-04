/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emilio
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
    
    private int id;
    private String nombre;
    private String contra;
    private String validationCode;
    
    private String code="1";
    
    public UsuarioBean() {
        code = "XULES-CODE";
        System.out.println("Validation code (Código de validación): " + code);
    }    
    public String getValidation() {
        if ((validationCode != null) && (validationCode.compareTo(code) == 0)) {
            // The validationCode is OK then we show the user data in validation.xhtml
            // El código validationCode es correcto entonces mostramos los datos en validation.xhtm
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "<p>User accepted:</p>"
                    + "<ul>"
                    + " <li>Usuario: " + getNombre() + " </li>"
                    + " <li>NContra: " + getContra() + " </li>"
                    + "</ul>";
        } else {
            return "<p>Sorry, " + validationCode + " isn't valid.</p>"
                    + "<p>Try again...</p>";
        }
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

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

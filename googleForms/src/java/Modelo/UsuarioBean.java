/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name = "usuario")
public class UsuarioBean {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contra")
    private String contra;

    List<UsuarioBean> listUser;

    public UsuarioBean() {

    }

    public UsuarioBean(String nombre, String contra) {
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

    public void setUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResultadoBean rb = context.getApplication().evaluateExpressionGet(context, "#{resultadoBean}", ResultadoBean.class);
        rb.setNombre(this.nombre);
        rb.setContra(this.contra);
        insertUser();
    }  

    public void insertUser() {
        UsuarioBean usuario = new UsuarioBean(this.nombre, this.contra);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("googleFormsPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

}

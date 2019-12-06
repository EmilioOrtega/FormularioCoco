/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
/**
 *
 * @author Emilio
 */
@Named
@RequestScoped
public class ButtonView {
 
    private MenuModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
 
        //First submenu
        DefaultMenuItem item = new DefaultMenuItem();
        item.setValue("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("pi pi-home"); 
 
        DefaultSubMenu firstSubmenu =  new DefaultSubMenu();
                firstSubmenu.setLabel("Dynamic Submenu");
                firstSubmenu.addElement(item);
 
        model.getElements().add(firstSubmenu);
 
        //Second submenu
        item = new DefaultMenuItem();
                item.setValue("Save");
                item.setIcon("pi pi-save");
                //((i) -> save());
                item.setUpdate("messages");
 
        DefaultSubMenu secondSubmenu = new DefaultSubMenu();
                secondSubmenu.setLabel("Dynamic Actions");
                secondSubmenu.addElement(item);
 
        item = new DefaultMenuItem();
                item.setValue("Delete");
                item.setIcon("pi pi-times");
                item.setCommand("#{buttonView.delete}");
                item.setAjax(false);
        secondSubmenu.getElements().add(item);
 
        model.getElements().add(secondSubmenu);
    }
 
    public MenuModel getModel() {
        return model;
    }
 
    public String save() {
        addMessage("Data saved");
        return null;
    }
 
    public void update() {
        addMessage("Data updated");
    }
 
    public void delete() {
        addMessage("Data deleted");
    }
 
    public void buttonAction() {
        addMessage("Welcome to PrimeFaces!!");
    }
 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

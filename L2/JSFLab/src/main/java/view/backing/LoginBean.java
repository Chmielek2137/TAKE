/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlSelectBooleanCheckbox;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;

/**
 *
 * @author Patryk
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    
    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public String login() {
        if (username.equals("scott") && password.equals("tiger")) {
            FacesContext context = FacesContext.getCurrentInstance();
            String errMsgText = context.getApplication().evaluateExpressionGet(context, "#{AppMessages['text.error']}", String.class);
            FacesMessage message = new FacesMessage(errMsgText);
            context.addMessage(null, message);
            return "index";
        }
        if (username.equals(password)) { 
            return "success"; 
        } else { 
            return "failure"; 
        }
    }
    
    public void activateButton(ValueChangeEvent e) 
    { 
        if (acceptCheckbox.isSelected()) 
            loginButton.setDisabled(false); 
        else 
            loginButton.setDisabled(true); 
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.renderResponse();
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }
    
}

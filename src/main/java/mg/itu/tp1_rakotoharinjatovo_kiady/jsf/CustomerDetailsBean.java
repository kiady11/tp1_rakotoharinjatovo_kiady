/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tp1_rakotoharinjatovo_kiady.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.tp1_rakotoharinjatovo_kiady.ejb.CustomerManager;
import mg.itu.tp1_rakotoharinjatovo_kiady.ejb.DiscountManager;
import mg.itu.tp1_rakotoharinjatovo_kiady.entities.Customer;
import mg.itu.tp1_rakotoharinjatovo_kiady.entities.Discount;

/**
 *
 * @author kiady
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable {
    private int idCustomer;
    private Customer customer;
    private List<Discount> discountList;

    @EJB
    private CustomerManager customerManager;
    
    @EJB
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    public List<Discount> getDiscounts() {
        discountList = discountManager.getAllDiscounts();   
        return discountList; 
    }

    public CustomerDetailsBean() {
    }
}

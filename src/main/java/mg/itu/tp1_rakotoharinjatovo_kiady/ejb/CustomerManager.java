/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tp1_rakotoharinjatovo_kiady.ejb;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query; // utilisé dans getAllCustomers
import java.util.List;
import mg.itu.tp1_rakotoharinjatovo_kiady.entities.Customer;
/**
 *
 * @author kiady
 */

@Stateless        
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    //execution d'une requête JPQL dont le nom est "Customer.findAll"
    //définie dans l'entité Customer
    public List<Customer> getAllCustomers() {  
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }  
        
    public Customer update(Customer customer) {
      return em.merge(customer);
    } 
    
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    public Customer findById(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }
}

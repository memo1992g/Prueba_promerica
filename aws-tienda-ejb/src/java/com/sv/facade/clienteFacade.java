/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.facade;




import com.sv.entity.Cliente;
import com.sv.util.JPAUtil;
import java.io.Serializable;
import javax.persistence.EntityManager;



/**
 *
 * @author Capacitaciones
 */
public class clienteFacade extends MantenimientoGenerico<Cliente> implements Serializable {

    private EntityManager em;

    public clienteFacade() {
        super(Cliente.class);
        
    }

    @Override
    protected EntityManager getEntityManager() {
      if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
        }

        return em;
    }

    
}

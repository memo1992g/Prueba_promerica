/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.facade;




import com.sv.entity.Cliente;
import com.sv.entity.Orden;
import com.sv.util.JPAUtil;
import java.io.Serializable;
import javax.persistence.EntityManager;



/**
 *
 * @author Capacitaciones
 */
public class ordenFacade extends MantenimientoGenerico<Orden> implements Serializable {

    private EntityManager em;

    public ordenFacade() {
        super(Orden.class);
        
    }

    @Override
    protected EntityManager getEntityManager() {
      if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
        }

        return em;
    }

    
}

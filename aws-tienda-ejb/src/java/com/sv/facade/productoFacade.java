/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.facade;




import com.sv.entity.Cliente;
import com.sv.entity.Orden;
import com.sv.entity.Producto;
import com.sv.util.JPAUtil;
import java.io.Serializable;
import javax.persistence.EntityManager;



/**
 *
 * @author Capacitaciones
 */
public class productoFacade extends MantenimientoGenerico<Producto> implements Serializable {

    private EntityManager em;

    public productoFacade() {
        super(Producto.class);
        
    }

    @Override
    protected EntityManager getEntityManager() {
      if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
        }

        return em;
    }

    
}

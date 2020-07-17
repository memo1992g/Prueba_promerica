/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.ws;

import com.sv.entity.Cliente;
import com.sv.facade.clienteFacade;
import java.util.List;
import javax.ejb.LocalBean;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@WebService(serviceName = "ClienteWebService")
@Stateless()
@LocalBean
public class ClienteWebService {
    clienteFacade clientef = new clienteFacade();
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "findAll")
    public List<Cliente> findAll() {
        return clientef.findAll();
    }
    
    
    @WebMethod(operationName = "findById")
    public Cliente findById(@WebParam (name="id")int id) {
        return clientef.find(id);
    }
    
    @WebMethod(operationName = "update")
    public void update(@WebParam (name="cliente")Cliente cliente) {
             clientef.edit(cliente);
    }
    
      @WebMethod(operationName = "create")
    public void create(@WebParam (name="cliente")Cliente cliente) {
             clientef.create(cliente);
             
    }
    @WebMethod(operationName = "delete")
    public void delete(@WebParam (name="cliente")Cliente cliente) {
             clientef.remove(cliente);
             
    }

    
}

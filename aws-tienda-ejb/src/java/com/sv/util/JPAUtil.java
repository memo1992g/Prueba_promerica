/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *aws-tienda-ejbPU
 * @author Adonay
 */
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "aws-tienda-ejbPU";
    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            System.out.println("Conexion exitosa"+factory);
        } 
        return factory;
    }

}

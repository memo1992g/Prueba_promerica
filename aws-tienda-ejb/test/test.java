
import com.sv.entity.Cliente;
import com.sv.facade.clienteFacade;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class test {
    public static void main(String[] args) {
        clienteFacade cf = new clienteFacade();
       List<Cliente>lista = new ArrayList<>();
       lista = cf.findAll();
      
        System.out.println("testain "+lista);
        
    }
    
}

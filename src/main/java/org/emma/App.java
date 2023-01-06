package org.emma;

import org.emma.Service.EmployeService;
import org.emma.Service.EmployeServiceImpl;
import org.emma.entities.Employe;

import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(
                "Spring Framework, at its core, is a dependency injection container that manages the classes you wrote" +
                        " and their dependencies for you!" );
        EmployeService employeService = new EmployeServiceImpl();

 /*       Employe employe = new Employe();
        employe.setId(UUID.randomUUID().toString());
        employe.setNom("Kabore");
        employe.setPrenom("Marc");
        employe = employeService.Save(employe);*/

        List<Employe> all = employeService.findAll();
        for (Employe emp : all
             ) {
            System.out.println(emp.getPrenom());
        }
        //employeService.Delete("e68ba082-5e73-4031-b596-d0a8019319ac");

    }
}

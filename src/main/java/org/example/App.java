package org.example;

import org.example.Service.EmployeService;
import org.example.Service.EmployeServiceImpl;
import org.example.entities.Employe;

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

        Employe employe = new Employe();
        employe.setId(UUID.randomUUID().toString());
        employe.setNom("ETest");
        employe.setPrenom("EPTest");
        employe = employeService.Save(employe);
        List<Employe> all = employeService.findAll();
        for (Employe emp : all
             ) {
            System.out.println(emp.getPrenom());
        }

    }
}

package org.example.Service;

import org.example.entities.Employe;

import java.util.List;

public interface EmployeService {
    Employe Save(Employe employe);
    Employe findById(String id);
    Employe Update(Employe employe);
    void Delete(String id);

    List<Employe> findAll();



}

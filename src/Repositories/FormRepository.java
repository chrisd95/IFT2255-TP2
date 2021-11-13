package Repositories;

import models.Form;
import models.FormPreVaccin;
import models.FormSante;

import java.util.ArrayList;

public class FormRepository {
    ArrayList<Form> list = new ArrayList<>();

    public ArrayList<Form> findAllByCompteId(String compteId){
        return list;
    }

    public boolean create(FormPreVaccin form){
        Form newForm = new Form();
        newForm.setFormPreVaccin(form);
        list.add(newForm);
        return true;
    }

    public boolean update(FormSante form){
        Form newForm = new Form();
        newForm.setFormSante(form);
        list.add(newForm);
        return true;
    }
}

package models;

public class Form {
    String formId;
    String compteId;
    FormPreVaccin formPreVaccin;
    FormSante formSante;

    public FormPreVaccin getFormPreVaccin() {
        return formPreVaccin;
    }

    public FormSante getFormSante() {
        return formSante;
    }

    public void setFormPreVaccin(FormPreVaccin formPreVaccin) {
        this.formPreVaccin = formPreVaccin;
    }

    public void setFormSante(FormSante formSante) {
        this.formSante = formSante;
    }

    //    public Form combinerForm(FormPreVaccin form1, FormSante form2){
//        System.out.println(getFormPreVaccin());
//        System.out.println(getFormSante());
//        return formPreVaccin;
//    }
}

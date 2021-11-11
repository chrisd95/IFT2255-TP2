package utils;

import java.util.UUID;

public class GenerateCompteId {
    String lastGeneratedId;
    GenerateCompteId inst = new GenerateCompteId();
    private GenerateCompteId(){

    }


    public GenerateCompteId getInstance() {
        return inst;
    }

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}

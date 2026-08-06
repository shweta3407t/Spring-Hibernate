package com.example.springHibernate.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter  implements AttributeConverter<Boolean , String> {


    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
         if(attribute){
             return "yes";
         }
         else{
             return "No";
         }
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData.equals("yes")){
            return true;
        }else {
            return false;
        }
    }
}

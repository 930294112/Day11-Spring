package com.lanou.dao;

import com.lanou.domain.Person;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/10/24.
 */
@Repository("personDao")
public class PersonDaoImpl {
    private Person person;

    public boolean login(String name,String psw){
        if (name.equals(person.getName()) && psw.equals(person.getPassword())){
            return true;
        }
        return false;
    }

    @Required
    public void setPerson(Person person) {
        this.person = person;
    }
}

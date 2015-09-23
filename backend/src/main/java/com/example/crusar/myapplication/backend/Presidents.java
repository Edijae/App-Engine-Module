package com.example.crusar.myapplication.backend; /**
 * Created by crusar on 9/18/15.
 */

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class Presidents {

    @Id Long id;
    @Parent Key<Presidents> group;

    @Index
    String name;

    int age;

    static{
        ObjectifyService.register(Presidents.class);
    }

    public Presidents(Long pId, String pName, int pAge, String group){
        id = pId;
        name = pName;
        age = pAge;
        this.group = Key.create(Presidents.class,group);
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }
}

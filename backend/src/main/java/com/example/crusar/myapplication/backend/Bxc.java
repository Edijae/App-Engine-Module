package com.example.crusar.myapplication.backend;

import com.example.crusar.myapplication.backend.Presidents;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by crusar on 9/18/15.
 */
public class Bxc {



    public void savingLeaders(){
        Presidents p1 = new Presidents(new Long(1),"Daniel",88,"president");
        Presidents p2 = new Presidents(new Long(2),"Mwai",81,"President");
        Presidents p3 = new Presidents(new Long(3),"Daniel",70,"President");
        ofy().save().entities(p1,p2,p3).now();

    }
}

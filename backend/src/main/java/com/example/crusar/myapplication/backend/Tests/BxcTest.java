package com.example.crusar.myapplication.backend.Tests;

import com.example.crusar.myapplication.backend.Presidents;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static org.junit.Assert.*;

/**
 * Created by crusar on 9/23/15.
 */
public class BxcTest {

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    Presidents p1,p2,p3;
    @org.junit.Before
    public void setUp() throws Exception {
        helper.setUp();
         p1 = new Presidents(new Long(1),"Daniel",88,"president");
         p2 = new Presidents(new Long(2),"Mwai",81,"President");
         p3 = new Presidents(new Long(3),"Daniel",70,"President");
        ofy().save().entities(p1,p2,p3).now();
        System.out.println("Successfully saved.");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        ofy().clear();
        helper.tearDown();
    }

    @org.junit.Test
    public void testSavingLeaders() throws Exception {
     Presidents pres1 = ofy().load().type(Presidents.class).filter("name","Mwai").first().now();
        System.out.println("President name is: "+ pres1.getName()+ "His id is: "+pres1.getId());
    }
}
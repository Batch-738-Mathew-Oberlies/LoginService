package com.revature.rideshare.utilities;


import com.revature.rideshare.models.Address;
import com.revature.rideshare.models.Batch;
import com.revature.rideshare.models.User;

public class MockObjects {
    public static User getAdonis() {
        User adonis = new User();
        adonis.setUserId(1);
        adonis.setUserName("userName");
        Batch batch = new Batch();
        batch.setBatchLocation("Reston");
        batch.setBatchNumber(15);
        adonis.setBatch(batch);
        adonis.setFirstName("Adonis");
        adonis.setLastName("Cabreja");
        adonis.setEmail("adonis@gmail.com");
        adonis.setPhoneNumber("123-456-7890");
        adonis.setDriver(true);
        adonis.setActive(true);
        adonis.setAcceptingRides(true);
        Address address = new Address();
        address.setCity("Youngsville");
        address.setState("MI");
        address.setStreet("123 Fake Street");
        address.setZip("12123");
        address.setId(5);
        adonis.setHomeAddress(address);
        adonis.setWorkAddress(address);
        return adonis;
    }

    public static Address getAddress() {
        Address a = new Address();
        a.setId(1);
        a.setZip("27051");
        a.setState("VA");
        a.setCity("Reston");
        a.setStreet("123 Fake Street");
        return a;
    }
}

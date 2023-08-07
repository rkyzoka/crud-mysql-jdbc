package com.schedule.application;

import com.schedule.dao.ContactDAO;
import com.schedule.model.Contact;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ContactDAO contactDao = new ContactDAO();

        Contact contact1 = new Contact();
        contact1.setName("Pedro Fabri");
        contact1.setAge(29);
        contact1.setRegisterDate(new Date());

        contactDao.save(contact1);
    }

}

package com.schedule.application;

import com.schedule.dao.ContactDAO;
import com.schedule.model.Contact;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ContactDAO contactDao = new ContactDAO();

        Contact contact1 = new Contact();
        contact1.setName("Jonas Pedrolas");
        contact1.setAge(25);
        contact1.setRegisterDate(new Date());

        //contactDao.save(contact1);

        Contact contact1Up = new Contact();
        contact1Up.setName("Ryan Iug Ramos");
        contact1Up.setAge(22);
        contact1Up.setRegisterDate(new Date());
        contact1Up.setId(1);

        //contactDao.update(contact1Up);
        contactDao.delete(4);


        for (Contact c : contactDao.getContacts()) {
            System.out.println("Contato: " + c.getName() + ", " + c.getAge() + " anos, " + c.getRegisterDate());
        }
    }

}

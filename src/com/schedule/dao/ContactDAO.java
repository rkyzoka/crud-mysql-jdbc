package com.schedule.dao;

import com.mysql.jdbc.PreparedStatement;
import com.schedule.factory.ConnectionFactory;
import com.schedule.model.Contact;

import java.sql.Connection;
import java.sql.Date;

public class ContactDAO {
    public void save(Contact contact) {
        String sql = "INSERT INTO contacts(name, age, registerDate) VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getRegisterDate().getTime()));

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
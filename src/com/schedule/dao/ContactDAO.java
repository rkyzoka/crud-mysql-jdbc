package com.schedule.dao;

import com.mysql.jdbc.PreparedStatement;
import com.schedule.factory.ConnectionFactory;
import com.schedule.model.Contact;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Contact> getContacts() {
        String sql = "SELECT * FROM contacts";
        List<Contact> contacts = new ArrayList<Contact>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setAge(resultSet.getInt("age"));
                contact.setRegisterDate(resultSet.getDate("registerDate"));

                contacts.add(contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contacts;
    }

    public void update(Contact contact) {
        String sql = "UPDATE contacts SET name = ?, age = ?, registerDate = ? " + "WHERE id = ?";
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getRegisterDate().getTime()));
            pstm.setInt(4, contact.getId());

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

    public void delete(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            pstm.setInt(1, id);
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
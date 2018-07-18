/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.Numbers;
import dbconnectionfactory.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.NumberPojo;

/**
 *
 * @author Hagar
 */
public class NumbersImpl implements Numbers {

    @Override
    public ArrayList<NumberPojo> getAllNumbers() {
        ArrayList<NumberPojo> allNumbers = new ArrayList();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement retrievePs = connection.prepareStatement("SELECT * FROM numbers");
            ResultSet retSet = retrievePs.executeQuery();
            while (retSet.next()) {

                NumberPojo number = new NumberPojo();
                number.setId(retSet.getInt(1));
                number.setNumber(retSet.getInt(2));
                allNumbers.add(number);

            }
            bubbleSort(allNumbers);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return allNumbers;

    }

    public static void bubbleSort(ArrayList<NumberPojo> list) {
        NumberPojo temp;
        if (list.size() > 1) // check if the number of orders is larger than 1
        {
            for (int x = 0; x < list.size(); x++) // bubble sort outer loop
            {
               for (int i=0; i < list.size() - x - 1; i++)
 {
                    if (list.get(i).getNumber()>(list.get(i + 1).getNumber())) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
        }

    }

    @Override
    public boolean addNumber(NumberPojo number) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO numbers (id,number) VALUES (?,?)");
            insertPs.setInt(1, number.getId());
            insertPs.setInt(2, number.getNumber());

            insertPs.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(NumbersImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}

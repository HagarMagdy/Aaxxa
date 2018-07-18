/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.ArrayList;
import pojos.NumberPojo;

/**
 *
 * @author Hagar
 */
public interface Numbers {

    public ArrayList<NumberPojo> getAllNumbers();

    public boolean addNumber(NumberPojo number);

}

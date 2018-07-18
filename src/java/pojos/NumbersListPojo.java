/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;

/**
 *
 * @author Aya
 */
public class NumbersListPojo {
    
    ArrayList<NumberPojo> numbers= new ArrayList<NumberPojo>();

    public ArrayList<NumberPojo> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<NumberPojo> numbers) {
        this.numbers = numbers;
    }
    
    
}

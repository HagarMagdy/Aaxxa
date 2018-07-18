/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import pojos.NumberPojo;
import pojos.NumbersListPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Hagar
 */
public interface NumbersApi {

    public ResponseMessage insertNumber(NumberPojo number);

    public NumbersListPojo getAllNumbers();

}

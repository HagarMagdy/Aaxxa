/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementation;

import api.interfaces.NumbersApi;
import dao.implementation.NumbersImpl;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojos.NumberPojo;
import pojos.NumbersListPojo;
import pojos.ResponseMessage;

/**
 *
 * @author Hagar
 */
@Path("/number")
public class NumberApiImplementation implements NumbersApi {

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ResponseMessage insertNumber(NumberPojo number) {
        ResponseMessage response = new ResponseMessage();
        NumbersImpl numberObj = new NumbersImpl();
        boolean result = numberObj.addNumber(number);
        if (result == true) {
            response.setStatus(true);
            response.setMessage("Number Added Successfully");
            response.setError("0");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Number Failed to be added");
            response.setError("1");
            return response;

        }
    }
    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public NumbersListPojo getAllNumbers() {
        NumbersImpl numberObj = new NumbersImpl();
        ArrayList<NumberPojo> labs = new ArrayList();
        NumbersListPojo numberList = new NumbersListPojo();
        labs = numberObj.getAllNumbers();
        numberList.setNumbers(labs);
        return numberList;
    }

}

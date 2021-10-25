package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

        CabInvoice invoice=new CabInvoice();

        @Test
        public void whenEnterValue_returnTotalFare(){

            double res=invoice.totalFare(0.8,2);
            Assertions.assertEquals(10.0,res,0.0);
        }

        @Test
        public void whenMinimumDistance_returnMinimumFare(){
            double result=invoice.totalFare(0.2,2);
            Assertions.assertEquals(5,result,0.0);
        }
        @Test
         public void whenEnterAllRide_returnTotalFare(){
           RideDetails[] ride={
                new RideDetails(0.9,3),
                new RideDetails(2.0,7),
           };
            CabInvoiceSummary res=invoice.calculateTotalFare(ride);
            CabInvoiceSummary expected=  new CabInvoiceSummary(2,39.0);
            Assertions.assertEquals(res,expected);
         }

         @Test
         public void whenEnterMultipleUser_returnFare(){

            CabInvoiceSummary cabInvoiceData= invoice.detailsCab(2);
            CabInvoiceSummary cabInvoiceData1=new CabInvoiceSummary(3,30);
            Assertions.assertEquals(cabInvoiceData1.getInvoice(),cabInvoiceData.getInvoice());
         }
    @Test
    public void GivenDistaneAndTimePremiumData_ShouldReturnFare(){
        double distance = 5.0;
        int time = 12;
        String type = "normal";
        double fare = invoice.calculateCompute(distance,time,type);
        Assertions.assertEquals(62,fare,0.0);
    }
    @Test
    public void GivenDistanceAndTimePremiumData_ShouldReturnMinDataDare(){
        double distance = 1.1;
        int time = 2;
        String type = "premium";
        double fare = invoice.calculateCompute(distance,time,type);
        Assertions.assertEquals(20.5,fare,0.0);
    }
    @Test
    public void GivenDistanceAndTime_ShouldReturnMultiDataFare(){
        RideDetails[] cabRideData = {
                new RideDetails(2.0,3),
                new RideDetails(0.1,1)
        };
        String type = "premium";
        double fare = invoice.calculateFareCompute(cabRideData,type);
        Assertions.assertEquals(56.0,fare,0.0);
    }
    @Test
    public void GivenDistanceAndTime_ShouldReturnMultiInvoiceCabDataCompute(){
        String type = "normal";
        RideDetails[] cabRideData = {
                new RideDetails(3.0,4),
                new RideDetails(1.1,1)
        };
        CabInvoiceSummary cabInvoiceData = invoice.calculateFare(cabRideData,type);
        CabInvoiceSummary expectedDataCompute = new CabInvoiceSummary(2,46.0);
        Assertions.assertEquals(expectedDataCompute.getInvoice(),cabInvoiceData.getInvoice());
    }
}




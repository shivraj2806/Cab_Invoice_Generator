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
}



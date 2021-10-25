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
    }


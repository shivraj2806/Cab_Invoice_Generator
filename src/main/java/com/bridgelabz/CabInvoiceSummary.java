package com.bridgelabz;

import java.util.Objects;

public class CabInvoiceSummary {

        private final int TOTAL_RIDE;
        private final double TOTAL_FARE;
        private final double AVERAGE_FARE;

        public CabInvoiceSummary(int total_ride,double total_fare){
            this.TOTAL_RIDE=total_ride;
            this.TOTAL_FARE=total_fare;
            this.AVERAGE_FARE=this.TOTAL_FARE / this.TOTAL_RIDE;
        }

        @Override
        public boolean equals(Object o){
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CabInvoiceSummary that = (CabInvoiceSummary) o;
            return TOTAL_RIDE == that.TOTAL_RIDE && Double.compare(that.TOTAL_FARE,TOTAL_FARE) == 0 && Double.compare(that.AVERAGE_FARE,AVERAGE_FARE) == 0;
        }

        public int hashcode() {
            return Objects.hash(TOTAL_RIDE,TOTAL_FARE,AVERAGE_FARE);
        }

        @Override
        public String toString(){
            return "ride" + TOTAL_RIDE + "Fare" + TOTAL_FARE + "Average" + AVERAGE_FARE;
        }

    }


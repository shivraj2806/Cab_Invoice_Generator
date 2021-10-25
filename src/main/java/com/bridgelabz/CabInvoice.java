package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoice {
    double COST_PER_KILOMETER=10;
    int COST_PER_MINUTE=1;
    double MINIMUM_FARE=5;
    public Map<Integer,RideDetails[]> rideDetails=new HashMap<>();

    public double totalFare(double kilometer,int minute){
        double fare=(COST_PER_KILOMETER*kilometer + COST_PER_MINUTE * minute);
        if(fare<5){
            return  MINIMUM_FARE;
        }
        return fare;
    }


    public CabInvoiceSummary calculateTotalFare(RideDetails[] rideDetails){
        double fare=0.0;
        for (RideDetails details:rideDetails){
            fare+=totalFare(details.getKilometer(),details.getTime());
        }
        return new CabInvoiceSummary(rideDetails.length, fare);
    }

    public CabInvoiceSummary detailsCab(int userId){
        RideDetails[] details={
                new RideDetails(2.0,5),
                new RideDetails(3.0,2),
                new RideDetails(1.0,1)
        };

        RideDetails[] details1={
                new RideDetails(0.3,4),
                new RideDetails(0.7,2),
                new RideDetails(1,4)
        };
        rideDetails.put(1,details);
        rideDetails.put(2,details1);
        for(Map.Entry<Integer,RideDetails[]> entry:rideDetails.entrySet()){
            if(userId == entry.getKey()){
                RideDetails[] data=entry.getValue();
                return calculateTotalFare(data);
            }
        }
        return null;
    }
}
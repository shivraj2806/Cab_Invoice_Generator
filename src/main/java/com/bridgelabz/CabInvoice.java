package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoice {
    double COST_PER_KILOMETER=10;
    int COST_PER_MINUTE=1;
    double MINIMUM_FARE=5;
    double COST_PER_KILOMETER_NORMAL=10;
    int COST_PER_MINUTE_NORMAL=1;
    double COST_PER_KILOMETER_PREMIUM=15;
    int COST_PER_MINUTE_PREMIUM=2;
    double MINIMUM_FARE_PREMIUM=20;


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

    public double calculateCompute(double distance,int time,String type){
        if(type.equalsIgnoreCase("normal")){
            double fare=(distance * COST_PER_KILOMETER_NORMAL + time * COST_PER_MINUTE_NORMAL);
            return Math.max(MINIMUM_FARE,fare);
        }
        else if(type.equalsIgnoreCase("premium")){
            double fare=(distance * COST_PER_KILOMETER_PREMIUM + time * COST_PER_MINUTE_PREMIUM);
            return Math.max(MINIMUM_FARE_PREMIUM,fare);
        }
        else
            return 0;
    }

    public double calculateFareCompute(RideDetails[] ride,String type){
        double fare=0.0;
        if(type.equalsIgnoreCase("normal")){
            for(RideDetails data: ride){
                fare+=calculateCompute(data.getKilometer(),data.getTime(),type);
            }
            //return fare;
        }
        else if(type.equalsIgnoreCase("premium")){
            for(RideDetails data1: ride){
                fare +=calculateCompute(data1.getKilometer(),data1.getTime(),type);
            }
            //return fare;
        }
        return fare;
    }

    public CabInvoiceSummary calculateFare(RideDetails[] ride,String type){
        double fare=0.0;
        if(type.equalsIgnoreCase("normal")){
            for(RideDetails data: ride){
                fare+=calculateCompute(data.getKilometer(),data.getTime(),type);
            }
            //return fare;
        }
        else if(type.equalsIgnoreCase("premium")){
            for(RideDetails data1: ride){
                fare +=calculateCompute(data1.getKilometer(),data1.getTime(),type);
            }
            //return fare;
        }
        return new CabInvoiceSummary(ride.length, fare);
    }
}
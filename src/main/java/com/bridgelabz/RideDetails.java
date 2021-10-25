package com.bridgelabz;

    public class RideDetails {

        public double kilometer;
        public int time;

        public RideDetails(double kilometer,int time){
            this.kilometer=kilometer;
            this.time=time;
        }

        public double getKilometer() {
            return kilometer;
        }

        public int getTime() {
            return time;
        }
    }


package org.firstinspires.ftc.teamcode.FRQs;

public class Bottle {
    public double maxBottleCapacity;
    public double bottleAmount;

    public Bottle(double maxBottleCapacity){
        this.maxBottleCapacity = maxBottleCapacity;
        this.bottleAmount = maxBottleCapacity;
    }

    public double updateAmount(double amountRemoved) {
        bottleAmount = bottleAmount - amountRemoved;

        if(bottleAmount < (maxBottleCapacity * 0.25)){
            System.out.println("bottle refilled");
            bottleAmount = maxBottleCapacity;
        }
        return bottleAmount;

    }

}
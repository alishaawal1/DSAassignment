package Question5;

//Assume an electric vehicle must go from source city s to destination city d. You can locate many service centers
//        along the journey that allow for the replacement of batteries; however, each service center provides batteries with a
//        specific capacity. You are given a 2D array in which servicecenter[i]=[xi,yj] indicates that the ith service center is
//        xi miles from the source city and offers yj miles after the automobile can travel after replacing batteries at specific
//        service centers. Return the number of times the car's batteries need to be replaced before arriving at the destination.
//        Input: serviceCenters = [{10,60},{20,30},{30,30},{60,40}], targetMiles= 100, startChargeCapacity = 10
//        Output: 2
//        Explanation: The car can go 10 miles on its initial capacity; after 10 miles, the car replaces batteries with a
//        capacity of 60 miles; and after travelling 50 miles, at position 60 we change batteries with a capacity of 40 miles;
//        and ultimately, we may arrive at our destination.

public class Vehicle {

    int[][] capacityDistance;
    int capacity;
    int remCapacity;
    int recharging;
    int distance;
    int distancetravelled;
    int prevDistance=0;
    int nextDistance;

    Vehicle(int[][] capacityDistance){
        this.capacityDistance=capacityDistance;
        this.remCapacity=10;
        this.prevDistance=0;

        for(int i=0;i< capacityDistance.length;i++){
            for(int j=1;j>=0;j--){
                if(j==1){
                    capacity=capacityDistance[i][j];
                }else{

                    if(i!=0){
                        prevDistance=capacityDistance[i-1][j];

                    }
                    System.out.println("previous distance is === "+prevDistance);

                    if(i!=capacityDistance.length-1) {
                        nextDistance = capacityDistance[i + 1][j];
//                        System.out.println("next distance "+nextDistance);
                    }
                    distance=capacityDistance[i][j]-prevDistance;
                    System.out.println("distance from on to another is  "+distance);
                    if(remCapacity>=distance){
                        distancetravelled+=distance;
                        remCapacity=remCapacity-distance;
                        System.out.println("distance travelled "+distancetravelled);
                        System.out.println("remaining capacity is"+remCapacity);
                    }else{
                        recharging=recharge(capacity);
                        System.out.println("recharged at"+distancetravelled);
                        System.out.println("new capacity after recharging "+recharging);
                        remCapacity=remCapacity+recharging;
                        if(remCapacity>=distance){
                            distancetravelled+=distance;
                            remCapacity=remCapacity-distance;
                        }
                    }
                }

            }
        }
    }
    int recharge(int serviceCentercharge){
        this.capacity=capacity+serviceCentercharge;
        return capacity;
    }

    public static void main(String[] args) {
        int[][] arr={{10,60},{20,30},{30,30},{60,40},{100,0}};
        //providing destination distance as 100 to make it travel till the end

        new Vehicle(arr);
    }
}
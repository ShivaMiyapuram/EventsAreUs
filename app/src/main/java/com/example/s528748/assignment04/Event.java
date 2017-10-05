package com.example.s528748.assignment04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by S528748 on 10/4/2017.
 */

public class Event {
    // Name is a string and is the name of the event.
    private String Name;
    // Count is an integer and is the number of times the event has occurred.
    private int Count;

    private int Rating;


// {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    private static int temp[] = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static int i = 0;

    public String getName() {
        return Name;
    }

    public int getCount() {
        return Count;
    }

    public Event(String name) {
        this.Name = name + "";
        this.Count = 0;
    }

    // It should have a method to increase the count by one
    public void incrementCountByOne(){
        this.Count++;
    }

    public  int getRating() {
        return Rating;
    }

    public void setRating() {
        if(i <= 20){
            this.Rating = temp[i] ;
            i++;
        }
        else{
            i = 0;
            this.Rating = temp[i];
            i++;
        }

        //Random ran = new Random();
        //this.Rating = temp[ran.nextInt(20)] ;
    }
}


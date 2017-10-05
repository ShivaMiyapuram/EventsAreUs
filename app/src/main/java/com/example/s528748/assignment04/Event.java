package com.example.s528748.assignment04;

/**
 * Created by S528748 on 10/4/2017.
 */

public class Event {
    // Name is a string and is the name of the event.
    private String Name;
    // Count is an integer and is the number of times the event has occurred.
    private int Count;

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


}


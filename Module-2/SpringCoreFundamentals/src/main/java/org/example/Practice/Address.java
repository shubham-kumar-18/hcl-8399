package org.example.Practice;

public class Address {
    private String address;
    private int pin;
    public Address(String address, int pin) {
        this.address = address;
        this.pin = pin;
    }
     void getAddress(){
        System.out.println(address + " " + pin);
     }

}

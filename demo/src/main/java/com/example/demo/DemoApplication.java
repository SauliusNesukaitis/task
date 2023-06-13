package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
    	Vehicle[] myVehicles = new Vehicle[3];
    	myVehicles[0] = new MilitaryVehicle(1992, 2);
    	myVehicles[1] = new Tank(1995, 4, 125);
    	myVehicles[2] = new Tank(1981, 4, 105);
    	
    	for (Vehicle vehicle : myVehicles) {
    		iskviestiMetoda(vehicle);
    	}
    }
    
    public static void iskviestiMetoda(Vehicle vehicle) {
    	vehicle.repair();
    }
	
	
}

abstract class Vehicle {
	private int year;
	
	public Vehicle(int year) {
		this.year = year;
	}
	
	public int getYear() {
		
		return year;
	}
	
	public abstract void repair();
}


class MilitaryVehicle extends Vehicle {
	private int crew;
	
	public MilitaryVehicle(int year, int crew) {
		super(year);
		this.crew = crew;
	}
	
	public int getCrew() {
		return crew;
	}
	
	public void repair() {
		System.out.println("Vehicle needs to be repaired.");
	}
	
	public void prepare() {
		System.out.println("Vehicle is prepared.");
	}
}


class Tank extends MilitaryVehicle {
	private int caliber;
	
	public Tank(int year, int crew, int caliber) {
		super(year, crew);
		this.caliber = caliber;
	}
	
	public int getCaliber() {
		return caliber;
	}
	
	public void repair() {
		System.out.println("Tank needs to be repaired.");
	}
	
	public void loadAPRound() {
		System.out.println("Armor-piercing round is loaded.");
	}
}

interface Briefing {
	default void crewBriefing() {
		System.out.println("Crew briefing.");
	}
	
	static void missionBriefing() {
        System.out.println("Mission briefing");
    }
}

interface Cleaning {
	default void dailyCleaning() {
		System.out.println("Daily cleaning.");
	}
	
	static void sheduledCleaning() {
        System.out.println("Sheduled cleaning.");
    }
}
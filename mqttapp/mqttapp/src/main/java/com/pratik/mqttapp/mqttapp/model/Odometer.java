package com.pratik.mqttapp.mqttapp.model;

public class Odometer {
     private int speed;
     private int rpm;
     private int fuelLevel;
     private int batteryVoltage;
     private int milesDriven;
     private String engineStatus;
     private String warningStatus;
     
     public Odometer() {
    	 
     }

	public Odometer(int speed, int rpm, int fuelLevel, int batteryVoltage, int milesDriven, String engineStatus,
			String warningStatus) {
		this.speed = speed;
		this.rpm = rpm;
		this.fuelLevel = fuelLevel;
		this.batteryVoltage = batteryVoltage;
		this.milesDriven = milesDriven;
		this.engineStatus = engineStatus;
		this.warningStatus = warningStatus;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	public int getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(int fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public int getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(int batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public int getMilesDriven() {
		return milesDriven;
	}

	public void setMilesDriven(int milesDriven) {
		this.milesDriven = milesDriven;
	}

	public String getEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(String engineStatus) {
		this.engineStatus = engineStatus;
	}

	public String getWarningStatus() {
		return warningStatus;
	}

	public void setWarningStatus(String warningStatus) {
		this.warningStatus = warningStatus;
	}

	@Override
	public String toString() {
		return "Odometer [speed=" + speed + ", rpm=" + rpm + ", fuelLevel=" + fuelLevel + ", batteryVoltage="
				+ batteryVoltage + ", milesDriven=" + milesDriven + ", engineStatus=" + engineStatus
				+ ", warningStatus=" + warningStatus + "]";
	}
	
     
     
}

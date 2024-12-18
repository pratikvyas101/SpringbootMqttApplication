package com.pratik.mqttapp.mqttapp.model;

public class VehicleData {
	
		private int milesDriven;
	    private String engineStatus;
	    private String acState;
	    private String doorStatus;
	    private String warningStatus;
	    private String securityAlarm;
	    private String accModeState;
	    private String tjpModeState;
	    private String trunkModeState;
	    
	    public VehicleData() {
	    	
	    }

		public VehicleData(int milesDriven, String engineStatus, String acState, String doorStatus,
				String warningStatus, String securityAlarm, String accModeState, String tjpModeState,String trunkModeState) {
			this.milesDriven = milesDriven;
			this.engineStatus = engineStatus;
			this.acState = acState;
			this.doorStatus = doorStatus;
			this.warningStatus = warningStatus;
			this.securityAlarm = securityAlarm;
			this.accModeState = accModeState;
			this.tjpModeState = tjpModeState;
			this.trunkModeState = trunkModeState;;
		}
		



		public String getAcState() {
			return acState;
		}

		public void setAcState(String acState) {
			this.acState = acState;
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

		public String getDoorStatus() {
			return doorStatus;
		}

		public void setDoorStatus(String doorStatus) {
			this.doorStatus = doorStatus;
		}

		public String getWarningStatus() {
			return warningStatus;
		}

		public void setWarningStatus(String warningStatus) {
			this.warningStatus = warningStatus;
		}

		public String getSecurityAlarm() {
			return securityAlarm;
		}

		public void setSecurityAlarm(String securityAlarm) {
			this.securityAlarm = securityAlarm;
		}
		
		

		public String getAccModeState() {
			return accModeState;
		}

		public void setAccModeState(String accModeState) {
			this.accModeState = accModeState;
		}

		public String getTjpModeState() {
			return tjpModeState;
		}

		public void setTjpModeState(String tjpModeState) {
			this.tjpModeState = tjpModeState;
		}
		
		

		public String getTrunkModeState() {
			return trunkModeState;
		}

		public void setTrunkModeState(String trunkModeState) {
			this.trunkModeState = trunkModeState;
		}

		@Override
		public String toString() {
			return "VehicleData [milesDriven=" + milesDriven + ", engineStatus=" + engineStatus + ", acState=" + acState
					+ ", doorStatus=" + doorStatus + ", warningStatus=" + warningStatus + ", securityAlarm="
					+ securityAlarm + ", accModeState=" + accModeState + ", tjpModeState=" + tjpModeState
					+ ", trunkModeState=" + trunkModeState + "]";
		}

		

		
		
		
	    

}

package model;

public class InParking {
        private String vehicleNum;
        private String vehicleType;
        private String slotNumber;
        private String dataAndTime;

        public InParking() {
        }

        public InParking(String vehicleNum, String vehicleType, String slotNumber, String dataAndTime) {
            this.setVehicleNum(vehicleNum);
            this.setVehicleType(vehicleType);
            this.setSlotNumber(slotNumber);
            this.setDataAndTime(dataAndTime);
        }

        public String getVehicleNum() {
            return vehicleNum;
        }

        public void setVehicleNum(String vehicleNum) {
            this.vehicleNum = vehicleNum;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getSlotNumber() {
            return slotNumber;
        }

        public void setSlotNumber(String slotNumber) {
            this.slotNumber = slotNumber;
        }

        public String getDataAndTime() {
            return dataAndTime;
        }

        public void setDataAndTime(String dataAndTime) {
            this.dataAndTime = dataAndTime;
        }
}

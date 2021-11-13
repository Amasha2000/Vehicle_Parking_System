package model;


public class Slots  {

    private  String vNumber;
    private int slotId;
    private String vehicleType;
    private boolean isAvailable;

    public Slots() {
    }

    public Slots(int slotId, String vehicleType, boolean isAvailable) {
        this.setSlotId(slotId);
        this.setVehicleType(vehicleType);
        this.setAvailable(isAvailable);
    }
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}




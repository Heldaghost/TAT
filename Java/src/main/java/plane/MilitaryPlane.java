package plane;

import model.MilitaryPlaneType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryPlaneType militaryType;

    public MilitaryPlane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneType militaryType) {
        super(planeModel, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;
    }

    public MilitaryPlaneType getMilitaryType() {
        return militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryType +
                '}');
    }

    @Override
    public boolean equals(Object plane) {
        if (this == plane) return true;
        if (!(plane instanceof MilitaryPlane)) return false;
        if (!super.equals(plane)) return false;
        MilitaryPlane currentPlane = (MilitaryPlane) plane;
        return militaryType == currentPlane.militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}

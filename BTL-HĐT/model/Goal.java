package model;

import java.io.Serializable;

public class Goal implements Serializable {
    private double monthlyDistance; // ví dụ: 50km/tháng

    public Goal(double monthlyDistance) {
        this.monthlyDistance = monthlyDistance;
    }

    public double getMonthlyDistance() {
        return monthlyDistance;
    }

    @Override
    public String toString() {
        return "Muc tieu : " + monthlyDistance + " km/Thang";
    }
}

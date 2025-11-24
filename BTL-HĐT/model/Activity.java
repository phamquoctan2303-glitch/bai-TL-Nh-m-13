package model;

import java.io.Serializable;

/**
 * Lưu thông tin một hoạt động thể thao của thành viên:
 * - Loại hoạt động (chạy bộ, đạp xe...)
 * - Quãng đường km
 * - Lượng calo tiêu hao
 */
public class Activity implements Serializable {

    private String type;
    private double distance; // km
    private double calories;

    public Activity(String type, double distance, double calories) {
        this.type = type;
        this.distance = distance;
        this.calories = calories;
    }

    // Getter
    public String getType() {
        return type;
    }

    public double getDistance() {
        return distance;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return String.format("%s | %.2f km | %.2f kcal", type, distance, calories);
    }
}

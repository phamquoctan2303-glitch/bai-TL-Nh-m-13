package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivityManager {

    // Mỗi thành viên có một danh sách hoạt động
    private HashMap<String, ArrayList<Activity>> activities = new HashMap<>();

    // Thêm một hoạt động cho thành viên
    public void addActivity(String memberId, Activity act) {
        activities.putIfAbsent(memberId, new ArrayList<>());
        activities.get(memberId).add(act);
        System.out.println(">> Da ghi nhan hoat dong cho " + memberId);
    }

    // Lấy danh sách hoạt động của thành viên
    public ArrayList<Activity> getActivities(String memberId) {
        return activities.getOrDefault(memberId, new ArrayList<>());
    }

    // Tính tổng quãng đường của thành viên
    public double getTotalDistance(String memberId) {
        double sum = 0;
        for (Activity a : getActivities(memberId)) {
            sum += a.getDistance();
        }
        return sum;
    }

    // Tính tổng calo tiêu hao của thành viên
    public double getTotalCalories(String memberId) {
        double sum = 0;
        for (Activity a : getActivities(memberId)) {
            sum += a.getCalories();
        }
        return sum;
    }
}

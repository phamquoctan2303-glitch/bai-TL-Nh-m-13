package model;

import java.util.HashSet;

public class Challenge {

    private String name;
    private double targetDistance;
    private HashSet<String> members = new HashSet<>();

    // ===========================================
    // 1. Constructor rỗng (bắt buộc để App.java chạy)
    // ===========================================
    public Challenge() {
        this.name = "Default Challenge";
        this.targetDistance = 10; // mục tiêu mặc định 10 km
    }

    // ===========================================
    // 2. Constructor có tham số (tuỳ chọn)
    // ===========================================
    public Challenge(String name, double targetDistance) {
        this.name = name;
        this.targetDistance = targetDistance;
    }

    // ===========================================
    // 3. Thêm thành viên vào thử thách
    // ===========================================
    public void addMember(String id) {
        if (members.add(id)) {
            System.out.println(">> Da them " + id + " vao thu thach !");
        } else {
            System.out.println(">> Thanh vien " + id + " da nam trong challenge!");
        }
    }

    // ===========================================
    // 4. Kiểm tra thành viên hoàn thành thử thách chưa
    // ===========================================
    public boolean isCompleted(String memberId, ActivityManager act) {
        return act.getTotalDistance(memberId) >= targetDistance;
    }

    // ===========================================
    // 5. Hiển thị kết quả thử thách
    // ===========================================
    public void showResults(MemberManager manager, ActivityManager act) {

        if (members.isEmpty()) {
            System.out.println("\n>> Chua co ai tham gia thu thach !");
            return;
        }

        System.out.println("\n===== KET QUA THU THACH : " + name + " =====");
        System.out.println("Mục tiêu: " + targetDistance + " km\n");

        for (String id : members) {

            Student s = manager.findById(id);

            if (s == null) {
                System.out.println("- " + id + ": Khong tim thay thanh vien !");
                continue;
            }

            double totalKm = act.getTotalDistance(id);
            boolean completed = totalKm >= targetDistance;

            System.out.printf(
                "%s (%s): %.2f km - %s\n",
                s.getName(),
                s.getId(),
                totalKm,
                (completed ? "Hoan Thanh ✔" : "Chua dat ✘")
            );
        }
    }

    // ========== Getter & Setter ==========
    public String getName() {
        return name;
    }

    public double getTargetDistance() {
        return targetDistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTargetDistance(double targetDistance) {
        this.targetDistance = targetDistance;
    }
}

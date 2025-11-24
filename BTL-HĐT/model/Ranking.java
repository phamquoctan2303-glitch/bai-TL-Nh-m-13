package model;

import java.util.*;

public class Ranking {

    // Xếp hạng theo quãng đường hoặc theo điểm
    public void showRanking(MemberManager manager, ActivityManager actManager, boolean byScore) {
        ArrayList<Student> members = new ArrayList<>(manager.getMembers());

        // Map: id → giá trị để xếp hạng
        Map<String, Double> rankMap = new HashMap<>();

        for (Student s : members) {
            double distance = actManager.getTotalDistance(s.getId());
            double calories = actManager.getTotalCalories(s.getId());

            double value = byScore ? (calories + distance * 10) : distance;
            rankMap.put(s.getId(), value);
        }

        // Sắp xếp giảm dần
        members.sort((a, b) -> Double.compare(rankMap.get(b.getId()), rankMap.get(a.getId())));

        System.out.println("\n===== BANG XEP HANG " + (byScore ? "THEO DIEM" : "THEO QUANG DUONG") + " =====");

        int rank = 1;
        for (Student s : members) {
            double distance = actManager.getTotalDistance(s.getId());
            double calories = actManager.getTotalCalories(s.getId());
            double score = calories + distance * 10;

            if (byScore) {
                System.out.println(rank + ". " + s.getName() +
                        " - diem: " + score +
                        " (Quang duong: " + distance + " km, Calo: " + calories + ")");
            } else {
                System.out.println(rank + ". " + s.getName() +
                        " - Quang duong: " + distance + " km" +
                        " (Calo: " + calories + ")");
            }
            rank++;
        }
    }

    // Convenience method: mặc định xếp hạng theo quãng đường
    public void showRanking(MemberManager manager, ActivityManager actManager) {
        showRanking(manager, actManager, false);
    }
}

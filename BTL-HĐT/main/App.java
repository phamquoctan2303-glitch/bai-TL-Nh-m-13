package main;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        MemberManager manager = new MemberManager();
        Scanner sc = new Scanner(System.in);

        // Các module mở rộng
        ActivityManager activityManager = new ActivityManager();
        Goal goal = null;
        Ranking ranking = new Ranking();
        Challenge challenge = new Challenge();

        // ---------- Tự động load file .dat ----------
        ArrayList<Student> loaded = FileHandler.loadDat("data.dat");
        if (!loaded.isEmpty()) {
            manager.setMembers(loaded);
            System.out.println(">> Da tai du lieu tu data.dat");
        }

        // ==================== MENU CHÍNH ====================
        while (true) {
            System.out.println("\n===== DNU FITNESS TRACKER =====");
            System.out.println("1. Them thanh vien");
            System.out.println("2. Xoa thanh vien");
            System.out.println("3. Sua thong tin thanh vien");
            System.out.println("4. Hien thi danh sach");
            System.out.println("5. Luu file .dat");
            System.out.println("6. Xuat file JSON");

            System.out.println("7. Them hoat dong");
            System.out.println("8. Xem hoat dong cua thanh vien");
            System.out.println("9. Dat muc tieu thang");
            System.out.println("10. Kiem tra muc tieu thang dat dc cua thanh vien");
            System.out.println("11. Xep hang thanh vien");
            System.out.println("12. Them nguoi vao thu thach");
            System.out.println("13. Ket qua thu thach");

            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                // ----------------- Thành viên -----------------
                case 1:
                    System.out.print("MVS: ");
                    String id = sc.nextLine();
                    System.out.print("Ten: ");
                    String name = sc.nextLine();
                    System.out.print("Tuoi: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nganh: ");
                    String major = sc.nextLine();
                    manager.addMember(new Student(id, name, age, major));
                    break;

                case 2:
                    System.out.print("Nhap MVS can xoa : ");
                    manager.removeMember(sc.nextLine());
                    break;

                case 3:
                    System.out.print("MVS can sua : ");
                    String uid = sc.nextLine();
                    System.out.print("Ten moi: ");
                    String newName = sc.nextLine();
                    System.out.print("Tuoi moi : ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nganh moi: ");
                    String newMajor = sc.nextLine();
                    manager.updateMember(uid, newName, newAge, newMajor);
                    break;

                case 4:
                    manager.showAll();
                    break;

                case 5:
                    FileHandler.saveDat(manager.getMembers(), "data.dat");
                    break;

                case 6:
                    JsonHandler.saveJson(manager.getMembers(), "data.json");
                    break;

                // ----------------- Hoạt động thể thao -----------------
                case 7:
                    System.out.print("MSV Thanh vien : ");
                    String uidAct = sc.nextLine();
                    System.out.print("Loai hoat dong : ");
                    String type = sc.nextLine();
                    System.out.print("Quang duong (km): ");
                    double dist = sc.nextDouble();
                    System.out.print("Calo tiêu hao: ");
                    double cal = sc.nextDouble();
                    sc.nextLine();
                    activityManager.addActivity(uidAct, new Activity(type, dist, cal));
                    break;

                case 8:
                    System.out.print("MSV Thanh vien: ");
                    String uidH = sc.nextLine();
                    System.out.println(activityManager.getActivities(uidH));
                    break;

                // ----------------- Mục tiêu -----------------
                case 9:
                    System.out.print("Nhap muc tieu km/thang: ");
                    goal = new Goal(sc.nextDouble());
                    sc.nextLine();
                    break;

                case 10:
                    System.out.print("MSV Thanh vien : ");
                    String idGoal = sc.nextLine();
                    double done = activityManager.getTotalDistance(idGoal);
                    System.out.println("Da dat : " + done + "/" + goal.getMonthlyDistance() + " km");
                    break;

                // ----------------- Xếp hạng -----------------
                case 11:
                    ranking.showRanking(manager, activityManager);
                    break;

                // ----------------- Thử thách -----------------
                case 12:
                    System.out.print("MSV can them vao challenge: ");
                    challenge.addMember(sc.nextLine());
                    break;

                case 13:
                    challenge.showResults(manager, activityManager);
                    break;

                case 0:
                 System.out.println("Goodbye !");
                     sc.close(); 
                        return;


                default:
                    System.out.println("Lua chon ko hop le !");
            }
        }
    }
}

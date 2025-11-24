package model;

import java.util.ArrayList;

public class MemberManager {
    private ArrayList<Student> members = new ArrayList<>();

    public void addMember(Student s) {
        members.add(s);
        System.out.println(">> Da them thanh vien !");
    }

    public void removeMember(String id) {
        members.removeIf(s -> s.getId().equals(id));
        System.out.println(">> Da xoa thanh vien !");
    }

    public void updateMember(String id, String name, int age, String major) {
        for (Student s : members) {
            if (s.getId().equals(id)) {
                s.setName(name);
                s.setAge(age);
                s.setMajor(major);
                System.out.println(">> Da cap nhat thanh vien !");
                return;
            }
        }
        System.out.println(">> Khong tim thay ID!");
    }

    public void showAll() {
        System.out.println("===== DANH SACH THANH VIEN =====");
        for (Student s : members)
            System.out.println(s);
    }

    public ArrayList<Student> getMembers() { return members; }

    public void setMembers(ArrayList<Student> list) {
        this.members = list;
    }

    public Student findById(String id) {
    for (Student s : members)
        if (s.getId().equals(id)) return s;
    return null;
    }
}

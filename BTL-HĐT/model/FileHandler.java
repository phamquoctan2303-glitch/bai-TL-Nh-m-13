package model;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Lưu danh sách Student vào file .dat
     */
    public static void saveDat(ArrayList<Student> list, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {

            oos.writeObject(list);
            System.out.println(">> Da luu du lieu vao file : " + filename);

        } catch (IOException e) {
            System.out.println("!! loi khi luu file " + filename);
            e.printStackTrace();
        }
    }


    /**
     * Load danh sách Student từ file .dat
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadDat(String filename) {

        File file = new File(filename);

        // Nếu file chưa có → tạo file mới + trả về danh sách rỗng
        if (!file.exists()) {
            System.out.println(">> File chua ton tai . Tao moi : " + filename);
            return new ArrayList<>();
        }

        // Nếu có file thì load dữ liệu vào
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            Object obj = ois.readObject();

            if (obj instanceof ArrayList<?> list) {
                System.out.println(">> Da tai du lieu vao file " + filename);
                return (ArrayList<Student>) list;
            } else {
                System.out.println("!! File khong dung dinh dang . Tao danh scah mơi .");
                return new ArrayList<>();
            }

        } catch (Exception e) {
            System.out.println("!! Loi khi doc file " + filename);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

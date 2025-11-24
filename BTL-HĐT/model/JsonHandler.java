package model;

import java.io.FileWriter;
import java.util.ArrayList;

public class JsonHandler {

    public static void saveJson(ArrayList<Student> list, String filename) {
        try (FileWriter fw = new FileWriter(filename)) {

            fw.write("[\n");
            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);

                fw.write("  {\n");
                fw.write("    \"id\": \"" + s.getId() + "\",\n");
                fw.write("    \"name\": \"" + s.getName() + "\",\n");
                fw.write("    \"age\": " + s.getAge() + ",\n");
                fw.write("    \"major\": \"" + s.getMajor() + "\"\n");
                fw.write("  }");

                if (i < list.size() - 1) fw.write(",");
                fw.write("\n");
            }
            fw.write("]");

            System.out.println(">>Da xuat JSON vao " + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


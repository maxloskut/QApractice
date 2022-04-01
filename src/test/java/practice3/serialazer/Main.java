package practice3.serialazer;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("input_json.txt");
        String InputString = null;
        try {
            InputString = Files.readString(inputFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(InputString);

        JSONObject json = new JSONObject(InputString);
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        try {
            user = mapper.readValue(InputString, User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setPhoneList(new ArrayList<>());
        user.getPhoneList().add("+38094567712");
        user.getPhoneList().add("+38034453679");

        System.out.println(user);

        JSONObject outputJson = new JSONObject(user);
        System.out.println(outputJson);

        File outputFile = new File("output.json");

        PrintWriter out = null;
        try {
            out = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        out.println(outputJson);
        out.close();
    }
}

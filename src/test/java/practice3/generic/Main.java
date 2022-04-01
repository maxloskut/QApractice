package practice3.generic;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User("genericPlayer");
        user.setDb(new Date());
        String jsonUser = user.asJson().toString();
        System.out.println(jsonUser);

        System.out.println(user.makeMyFromJsonString(User.class, jsonUser));
    }
}

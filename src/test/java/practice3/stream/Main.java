package practice3.stream;



import practice3.serialazer.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>(
                Arrays.asList(
                        new User("UserName"),
                        new User("WithPhones", Arrays.asList("198412847", "81647147143")),
                        new User("WithOnePhone", "224816135")
                )
        );
        System.out.println(userList);

        userList.sort((o1, o2) -> {
            if(o1.getPhoneList() == null) return -1;
            if(o2.getPhoneList() == null) return 1;
            return Integer.compare(o1.getPhoneList().size(), o2.getPhoneList().size());
        });

        System.out.println(userList);

        System.out.println(userList.stream().
                filter(u -> u.getPhoneList() != null).collect(Collectors.toList()));

        System.out.println(userList.stream().
                map(u->u.getName()+(u.getPhoneList()!=null?u.getPhoneList().toString():"")).collect(Collectors.toList()));

        System.out.println();
        System.out.println(Arrays.asList(args));
    }
}

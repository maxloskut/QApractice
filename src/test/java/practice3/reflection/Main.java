package practice3.reflection;

import java.lang.reflect.Field;

import static javax.swing.UIManager.put;

public class Main {
    public static void main(String[] args){
        User user = new User("Player1");
        System.out.println(get(user, "name"));
        put(user, "name", "name2");
        System.out.println(get(user, "name"));
    }

    private static void put(User object, String fieldname, Object value) {
        for(Field f:object.getClass().getDeclaredFields()){
            if(f.getName().equals(fieldname)){
                try{
                    f.setAccessible(true);
                    f.set(object, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Object get(Object object, String fieldname) {
        for(Field f:object.getClass().getDeclaredFields()){
            if(f.getName().equals(fieldname)){
                try{
                    f.setAccessible(true);
                    Object res = f.get(object);
                    return res;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

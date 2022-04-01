package practice3.serialazer;


import practice3.generic.JSONModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private String name;
    private Date db;
    private Integer weight;
    private List<String> phoneList;

    public User(String name, List<String> phoneList){
        super();
        this.name = name;
        this.phoneList = phoneList;
    }

    public User(){}

    public User(String name){this.name = name;}

    public User(String name, String phone){
        this.name = name;
        this.setPhoneList(List.of(phone));
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDb() {
        return db;
    }

    public void setDb(Date db) {
        this.db = db;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", db=" + db +
                ", weight=" + weight +
                ", phoneList=" + phoneList +
                '}';
    }
}
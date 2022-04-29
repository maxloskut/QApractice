package practice4.Model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class student {
    @Id
    private Integer id_student;
    private String name;
    private Date bd;
    private Integer course;

    @ManyToMany
    @JoinTable(
            name = "address_student",
            joinColumns = @JoinColumn(name = "id_address"),
            inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private Set<adrress> studentAdrress;

    public Integer getId_student() {
        return id_student;
    }

    public void setId_student(Integer id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBd() {
        return bd;
    }

    public void setBd(Date bd) {
        this.bd = bd;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "student{" +
                "id_student=" + id_student +
                ", name='" + name + '\'' +
                ", bd=" + bd +
                ", course=" + course +
                ", studentAdrress=" + studentAdrress +
                '}';
    }
}

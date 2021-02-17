package hw05;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer mark;

    public Student() {
    }

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student(Integer id, String name, Integer mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}

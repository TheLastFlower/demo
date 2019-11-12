package app.component.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by DELL on 2019/9/22 12:27
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

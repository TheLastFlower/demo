package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by DELL on 2019/9/22 12:27
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer age;
}

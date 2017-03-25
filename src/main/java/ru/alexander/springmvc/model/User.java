package ru.alexander.springmvc.model;

import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class User {

    private int id;

    @Size(min = 5, max = 10, message = "Имя должно быть от 5 до 10 символов")
    private String name;

    @Size(min = 5, max = 10, message = "Пароль должен быть от 5 до 10 символов")
    private String password;

    private boolean admin;

}

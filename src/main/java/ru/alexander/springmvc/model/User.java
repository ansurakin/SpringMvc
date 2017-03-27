package ru.alexander.springmvc.model;

import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class User {

    private int id;

    //Имя должно быть от 5 до 10 символов
    @Size(min = 5, max = 10, message = "{name.size.error}")
    private String name;

    //Пароль должен быть от 5 до 10 символов
    @Size(min = 5, max = 10, message = "{password.size.error}")
    private String password;

    private boolean admin;

}

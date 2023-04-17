package personal.controllers;

import personal.model.User;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Validat {
    public void validate(User user) {
        if (!pattern.matcher(user.getFirstName()).find()) {
            throw new RuntimeException("Имя пользователя не должно быть пустым");
        }
        if (!pattern.matcher(user.getLastName()).find()) {
            throw new RuntimeException("Фамилия пользователя не должно быть пустым");
        }
        if (!patternDigit.matcher(user.getPhone()).find()) {
            throw new RuntimeException("Номер телефона введён не правильно");
        }
    }
    final String regex = "^\\S+$";
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final String reDigit = "^\\d+$";

    final Pattern patternDigit  = Pattern.compile(regex);

}
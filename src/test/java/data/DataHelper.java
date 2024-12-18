package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    public static final Faker faker = new Faker(new Locale("en"));

    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static WrongAuthInfo getWrongAuthInfoWithTestData() {
        return new WrongAuthInfo("vasya", "qwerty");
    }
    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
    @Value
    public static class WrongAuthInfo {
        String login;
        String password;
    }

}
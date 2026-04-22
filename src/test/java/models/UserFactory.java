package models;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import utils.PropertyReader;

public class UserFactory {

    @Contract(" -> new")
    public static @NonNull User getStandardUser() {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password")
        );
    }

    @Contract(" -> new")
    public static @NonNull User getLockedUser() {
        return new User(
                PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password")
        );
    }

    @Contract(" -> new")
    public static @NonNull User getUserWithoutPassword() {
        return new User(
                PropertyReader.getProperty("saucedemo.incorrect_user"),
                ""
        );
    }

    @Contract(" -> new")
    public static @NonNull User getUserWithoutUsername() {
        return new User(
                "",
                PropertyReader.getProperty("saucedemo.password")
        );
    }
}

package by.kupi.utils;

import net.datafaker.Faker;

public class DataFaker {
    public Faker faker = new Faker();

    public String getMaxBoundaryPassword(){
        return faker.internet().password(256,256);
    }

    public String getMinBoundaryPassword(){
        return faker.internet().password(3,3);
    }

    public String getMaxBoundaryEmail(){
        String email = faker.internet().password(251,251) + "@q.ru";
        return email;
    }

    public String getCorrectPassword(){
        return faker.internet().password(4,255);
    }

    public String getCorrectEmail(){
        return faker.internet().emailAddress();
    }
}

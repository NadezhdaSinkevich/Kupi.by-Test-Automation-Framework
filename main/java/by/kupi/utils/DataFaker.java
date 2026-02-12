package by.kupi.utils;

import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataFaker {
    public Faker faker = new Faker();
    private static Logger logger = LogManager.getLogger();

    public String getMaxBoundaryPassword(){
        String password = faker.internet().password(256,256);
        logger.info(password);
        return password;
    }

    public String getMinBoundaryPassword(){
        String password = faker.internet().password(3,3);
        logger.info(password);
        return password;
    }

    public String getMaxBoundaryEmail(){
        String email = faker.internet().password(251,251) + "@q.ru";
        logger.info(email);
        return email;
    }

    public String getCorrectPassword(){
        String password = faker.internet().password(4,255);
        logger.info(password);
        return password;
    }

    public String getCorrectEmail(){
        String email = faker.internet().emailAddress();
        logger.info(email);
        return email;
    }
}

package DataUtils;

import io.qameta.allure.Step;

import java.sql.SQLException;

public class FinesQueries extends DBUtils {

    @Step
    public void restAllFines() throws SQLException {
        getConnection();


    }
}

package DataUtils;

import java.sql.*;

public class DBUtils {


    private static final String DB_URL = "jdbc:oracle:thin:@10.11.206.27:1527/TRFUAT";
        private static final String USER = "QC_FAHMY";
        private static final String PASS = "Fahmy2025pwd123#";

        private static Connection connection;

        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
            return connection;
        }

        public static void closeConnection() throws SQLException {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }


        public static String getTrafficNo() {
            String result = null;
            String sql = SQLQueryLoader.getQuery("getTrafficNo");

            try (Connection conn = getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                if (rs.next()) {
                    result = rs.getString("RTA_UNIFIED_NO");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        public static String getApplicationRef(String trafficNo) {
            String result = null;
            String sql = SQLQueryLoader.getQuery("getApplicationRef");

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, trafficNo);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    result = rs.getString("APPLICATION_REF_NO");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
    }



import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class SendTemperature extends Thread {
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=root&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    boolean resultInsert;
    public void insert() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return ;
        }
        System.out.println("sendTeperture.......");
        connection= (Connection) DriverManager.getConnection(url);
        sql="insert into sample(sample_time,sample_data)values(?,?);";

        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
        preparedStatement.setBigDecimal(2, BigDecimal.valueOf(15+10*Math.random()));
        System.out.println(preparedStatement.toString());
        resultInsert=preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void run() {
        while(true){
            try {
                this.insert();
                sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

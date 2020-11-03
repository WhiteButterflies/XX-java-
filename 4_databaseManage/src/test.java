import java.sql.SQLException;

public class test extends Thread{
    SendTemperature sendTemperature=new SendTemperature();
    ShowTemperature showTemperature=new ShowTemperature();
    alertSystem alertSystem=new alertSystem();
    public static void main(String[] args) throws SQLException {
        test test1=new test();
        test1.run();
    }

    @Override
    public void run() {
        sendTemperature.start();
        showTemperature.start();
        alertSystem.start();

    }
}

import java.sql.SQLException;

public class test extends Thread{
    SendTemperature sendTemperature=new SendTemperature();
    ShowTemperature showTemperature=new ShowTemperature();
    alertSystem alertSystem=new alertSystem();
    public static void main(String[] args) throws Exception {
        test test1=new test();
        int time = 0;
        while (true){
            while(time%6!=5){
                test1.sendTemperature.insert();
                System.out.println("Now temperature"+test1.showTemperature.getTemperatureByTime(1).get(0).toString());
                test1.alertSystem.warn(test1.showTemperature.getTemperatureByTime(6));
                time++;
                System.out.println();
                Thread.sleep(10000);
            }
            time=0;
            time++;
            test1.sendTemperature.insert();
            System.out.println("Now temperature"+test1.showTemperature.getTemperatureByTime(1).get(0).toString());
            test1.showTemperature.getAverageTemperatureBy60();
            System.out.println();
            Thread.sleep(10000);

        }
    }

    @Override
    public void run() {
        sendTemperature.start();
        showTemperature.start();
        alertSystem.start();

    }
}

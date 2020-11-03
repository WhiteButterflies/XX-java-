import java.sql.SQLException;
import java.util.ArrayList;

public class alertSystem extends Thread{
//    警告温度是否超过阈值 如果超过 报警. true为异常状态
    ShowTemperature showTemperature=new ShowTemperature();
    public  boolean warn(ArrayList<Double> results){
        if(results!=null){
            for (Double res:results
                 ) {
                if(res<18.0||res>22){
                    System.out.println("危险状态，报警！");
                    return false;
                }
            }
        }
        else {
            System.out.println("数据不足！请稍等！");
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.warn(this.showTemperature.getTemperatureByTime(6));
                sleep(1000);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }

    }
}

import java.sql.SQLException;
import java.util.ArrayList;

public class alertSystem extends Thread{
//    警告温度是否超过阈值 如果超过 报警. false为异常状态
    ShowTemperature showTemperature=new ShowTemperature();
    public  boolean warn(ArrayList<Double> results){
        int errorCount=0;
        if(results!=null){
            for (Double res:results
                 ) {
                if(res<18.0||res>22){
                    errorCount++;
                }
            }
        }
        else {
            System.out.println("预警系统暂缺乏数据，请稍等！");
            return false;
        }
        if (errorCount==results.size()){
            System.out.println("阈值[18℃, 22℃]长达1分钟!");
        }
        return true;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.warn(this.showTemperature.getTemperatureByTime(6));
                sleep(10000);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }

    }
}

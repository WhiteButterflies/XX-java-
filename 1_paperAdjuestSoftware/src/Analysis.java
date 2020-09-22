import javax.tools.Tool;
import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

class grade{
    public double grade;
    public grade(){

    }
    public grade(double grade){
        this.grade=grade;
    }
}
class Tools{
    public static double getAverage(ArrayList<grade> grades){
        double sum=0.0;
        for (grade grade:grades) {
            sum+=grade.grade;
        }
        return sum/grades.size();
    }
    public static double getMax(ArrayList<grade> grades){
        if(grades.size()==0){
            return 0;
        }
        double max=grades.get(0).grade;
        for(grade grade:grades){
            if(max<grade.grade){
                max=grade.grade;
            }
        }
        return max;
    }
    public static double getMin(ArrayList<grade> grades){
        if(grades.size()==0){
            return 0;
        }
        double min=grades.get(0).grade;
        for(grade grade:grades){
            if(min>grade.grade){
                min=grade.grade;
            }
        }
        return min;
    }
    public static ArrayList<grade> getSpecificList(ArrayList<grade> grades,int level){
//        特定指标学生的成绩单
        ArrayList<grade> list= new ArrayList<>();
        double low=0;
        double high=60;
        if(level<6){
            for (grade grade:grades
                 ) {
                if(grade.grade>=0&&grade.grade<60){
                    list.add(grade);
                }
            }
        }
        else{
            low=level*10;
            high=low+10;
            for (grade grade:grades
            ) {
                if(grade.grade>=low&&grade.grade<=high){
                    list.add(grade);
                }
            }
        }
        if(level<6){
            System.out.println("不及格学生");
        }
        System.out.println("分数档为"+low+"~"+high+"的人数："+list.size()+"百分比"+list.size()/((double)grades.size()));
        return list;
    }
    public static void getAllList(ArrayList<grade>grades){
        for(int i=5;i<10;i++){
            getSpecificList(grades,i);
        }
    }


}
public class Analysis {
    public static void main(String[] args) {
        System.out.println("请输入您想要输入的学生成绩");
        Scanner sc = new Scanner(System.in);
        ArrayList<grade>grades = new ArrayList<>();
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            grades.add(new grade( Double.parseDouble(stringArray[i])));
        }
        System.out.println("平均分："+Tools.getAverage(grades));
        System.out.println("最高分："+ Tools.getMax(grades)+"最低分："+Tools.getMin(grades));
        Tools.getAllList(grades);
    }
}

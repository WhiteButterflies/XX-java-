class StaffMember {
    //    int No;
    String name;
    String address;
    String phone;
//    String title;
//    String socialSN;
//    double payRate;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public StaffMember() {

    }

    public String toString() {
        return "姓名:" + name + '\n' + "地址" + address + '\n' + "电话" + phone + '\n';
    }

    public double pay() {
        return 0;
    }
}

class Volunteer extends StaffMember {
    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public double pay() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "多谢!" + '\n';
    }
}

class Employee extends StaffMember {
    String socialSN;
    double payRate;

    public Employee(String name, String address, String phone, String socialSN, double payRate) {
        super(name, address, phone);
        this.socialSN = socialSN;
        this.payRate = payRate;
    }

    public Employee() {

    }

    @Override
    public double pay() {
        return this.payRate;
    }

    @Override
    public String toString() {
        return super.toString() + "社会安全号:" + socialSN + '\n' + "工资:$" + this.payRate + '\n';
    }

}

class Manager extends Employee {
    double bonus;

    public Manager(String name, String address, String phone, String socialSN, double payRate, double bonus) {
        super(name, address, phone, socialSN, payRate);
        this.bonus = bonus;
    }

    public void awardBonus(double bonus) {
        this.bonus += bonus;
    }

    @Override
    public double pay() {
        return this.payRate+bonus;
    }

    @Override
    public String toString() {
        return super.toString()+"社会安全号:" + socialSN + '\n' + "工资:$" + (this.payRate+bonus) + '\n';
    }
}

class Hourly extends Employee {
    int hoursWorked = 0;

    public Hourly(String name, String address, String phone, String socialSN, double payRate, int hoursWorked) {
        super(name, address, phone, socialSN, payRate);
        this.hoursWorked = hoursWorked;
    }

    public void addHours(int hour) {
        hoursWorked += hour;
    }

    @Override
    public double pay() {
        return this.hoursWorked*payRate;
    }

    @Override
    public String toString() {
        return super.toString()+"社会安全号:" + socialSN + '\n' +"工作小时数:"+this.hoursWorked+'\n'+ "工资:$" + (this.payRate*hoursWorked) + '\n';
    }
}

public class Staff {
    public static StaffMember[] staffList;

    public Staff() {
        staffList = new StaffMember[6];
        Manager No1=new Manager("Sam","123 Main Line","555-0469","123-45-6789",2423.07,500);
        Employee No2=new Employee("Peter","456 Off Line","555-0101","987-65-4321",1246.15);
        Employee No3 = new Employee("Mary","789 Off Rocker","555-0690","010-20-3040",1169.23);
        Hourly No4=new Hourly("Cliff","678 Fifth Ave.","555-0000","958-47-3625",10.55,40);
        Volunteer No5=new Volunteer("Al","987 Suds Ave.","555-8374");
        Volunteer No6=new Volunteer("Gus","321 Off Line","555-7282");
        staffList[0]=No1;
        staffList[1]=No2;
        staffList[2]=No3;
        staffList[3]=No4;
        staffList[4]=No5;
        staffList[5]=No6;
    }

    public static void payDetail() {
        for (StaffMember st:staffList
             ) {
            System.out.print(st.toString());
            System.out.println("-----------------------");
        }
    }

    public static void main(String[] args) {
        new Staff();
        payDetail();
    }
}

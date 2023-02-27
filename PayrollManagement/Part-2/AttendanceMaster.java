
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AttendanceMaster {
    HashMap<Employee,Integer> empAttendancedict=new HashMap<Employee,Integer>();;
    Scanner sc=new Scanner(System.in);
    public void addAttendance(Employee employee,int attendance){
        empAttendancedict.put(employee, attendance);
    }
    public void updateAttendance(){
        int empId;
        int noOfWorkingDays;
        MasterData masterData=new MasterData();
        while (true){
            try{
                System.out.println("Enter the employee id");
                empId=sc.nextInt();
                sc.nextLine();
//                if(empId>=1001 || empId<masterData.getEmpList().size()){
//                    while (true){
//                    try {
//                    System.out.println("Enter the number of working days");
//                    noOfWorkingDays= sc.nextInt();
//                    sc.nextLine();
//                    while (true) {
//                        if (noOfWorkingDays >= 0) {
//                            empAttendancedict.put(masterData.getEmployee(empId), noOfWorkingDays);
//                            break;
//                        } else {
//
//                        }
//                        }
                    }
            catch (InputMismatchException me){
                System.out.println("Employee id should be value");
            }
        }
    }

    public void showEligibleList(){
        if(empAttendancedict.size()==0){
            System.out.println("Number of working days is not entered");
        }
        else {
            System.out.println("Eligible employee list:");
            for (Employee employee : empAttendancedict.keySet()) {
                if (empAttendancedict.get(employee) > 10) {
                    System.out.println("-------------Employee detail of "+employee.getEmpId()+"-------------");
                    System.out.println(employee.toString());
                    System.out.println("Number of working days:"+empAttendancedict.get(employee));
                }
            }
        }
    }
}

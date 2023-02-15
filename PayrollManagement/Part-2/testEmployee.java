import java.util.InputMismatchException;
import java.util.Scanner;
public class testEmployee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MasterData masterData=new MasterData();
        AttendanceMaster attendanceMaster=new AttendanceMaster();
        //int attendanceListCounter=1001;
        //int index=0;
        int employeeCount = 1;
        String nxtChoice="";
        while (true) {
            System.out.println("1.Add employee detail  2.Display the employee list  3.Eligible employee list  4.Exit");
            nxtChoice=sc.nextLine();
            if(nxtChoice.compareTo("1")==0){
                System.out.println("Enter the details of employee  " + employeeCount);
                Employee employee=new Employee();
                System.out.println("Enter the employee name");
                String name = "";
                name = sc.nextLine();
                employee.setEmpName(name);
                String departmentChoice = "";
                String department = "";
                while (true) {
                    System.out.println("Enter the employee department 1.R&D  2.IT 3.HR 4.Testing 5.Support");
                    departmentChoice = sc.nextLine();
                    if (departmentChoice.compareTo("1") == 0) {
                        department = "R&D";
                        break;
                    } else if (departmentChoice.compareTo("2") == 0) {
                        department = "IT";
                        break;
                    } else if (departmentChoice.compareTo("3") == 0) {
                        department = "HR";
                        break;
                    } else if (departmentChoice.compareTo("4") == 0) {
                        department = "IT";
                        break;
                    } else if (departmentChoice.compareTo("5") == 0) {
                        department = "Support";
                        break;
                    } else {
                        System.out.println("Invalid choice");
                    }
                }
                employee.setDepartment(department);
                String designationChoice = "";
                String designation = "";
                while (true) {
                    System.out.println("Enter the employee designation 1.Software Intern 2.Software Developer 3.Manager 4.Director 5.Vice President 6.CEO");
                    designationChoice = sc.nextLine();
                    if (designationChoice.compareTo("1") == 0) {
                        designation = "Software Intern";
                        break;
                    } else if (designationChoice.compareTo("2") == 0) {
                        designation = "Software Developer";
                        break;
                    } else if (designationChoice.compareTo("3") == 0) {
                        designation = "Manager";
                        break;
                    } else if (designationChoice.compareTo("4") == 0) {
                        designation = "Director";
                        break;
                    } else if (designationChoice.compareTo("5") == 0) {
                        designation = "Vice President";
                        break;
                    } else if (designationChoice.compareTo("6") == 0) {
                        designation = "CEO";
                        break;
                    } else {
                        System.out.println("Invalid choice");
                    }
                }
                employee.setDesignation(designation);
                Double salary=0.0;
                try {
                    System.out.println("Enter the employee salary");
                    salary = sc.nextDouble();
                    sc.nextLine();
                    employee.setSalary(salary);
                }
                catch (InputMismatchException e){
                    System.out.println("Salary should be a number");
                    sc.nextLine();
                    employee.setSalary(salary);
                }
                masterData.addEmployeeToList(employee);
                employeeCount++;

            }
            else if(nxtChoice.compareTo("2")==0){
                masterData.employeeDetailDisplay();
            }
            else if(nxtChoice.compareTo("3")==0){
                int noOfWorkingDays;
                //int i;
                for(Employee employee:masterData.getEmpList()){
                //for(i=attendanceListCounter;i<attendanceListCounter+masterData.getEmpList().size();i++){
                    System.out.println("Enter the number of working day for the employee "+employee.getEmpId());
                    noOfWorkingDays= sc.nextInt();
                    //attendanceMaster.addAttendance(masterData.getEmpList().get(index),noOfDays);
                    //index++;
                    attendanceMaster.addAttendance(employee,noOfWorkingDays);
                }
                //attendanceListCounter=i;
                sc.nextLine();
                attendanceMaster.showEligibleList();

            }
            else if(nxtChoice.compareTo("4")==0){
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
}
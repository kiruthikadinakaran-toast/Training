import java.util.InputMismatchException;
import java.util.Scanner;
public class testEmployee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MasterData masterData=new MasterData();
        AttendanceMaster attendanceMaster=new AttendanceMaster();
        int employeeCount = 1001;
        String nxtChoice="";
        while (true) {
            System.out.println("--------------Enter the coice--------------");
            System.out.println("1.Add employee detail  \n2.Other option");
            nxtChoice=sc.nextLine();
            if(nxtChoice.compareTo("1")==0){
                System.out.println("Enter the details of employee  " + employeeCount);
                Employee employee=new Employee();
                System.out.println("Enter the employee name");
                String name = "";
                name = sc.nextLine();
                employee.setEmpName(name);
                int departmentChoice ;
                String[] departmentList={"R&D","IT","HR","Testing","Support"};
                while (true) {
                    System.out.println("Enter the employee department \n1.R&D  \n2.IT \n3.HR \n4.Testing \n5.Support");
                    try {
                        departmentChoice = sc.nextInt();
                        sc.nextLine();
                        if (departmentChoice > 0 && departmentChoice <= 5) {
                            employee.setDepartment(departmentList[departmentChoice - 1]);
                            break;
                        } else {
                            System.out.println("Invalid choice");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid choice");
                        sc.nextLine();
                    }
                }
                int designationChoice;
                String[] designationList={"Software Intern","Software Developer","Manager","Director","Vice President","CEO"};
                while (true) {
                    System.out.println("Enter the employee designation \n1.Software Intern \n2.Software Developer \n3.Manager \n4.Director \n5.Vice President \n6.CEO");
                    try {
                        designationChoice= sc.nextInt();
                        sc.nextLine();
                        if(designationChoice>0 && designationChoice<=6){
                            employee.setDesignation(designationList[designationChoice-1]);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid choice");
                        sc.nextLine();
                    }
                }
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
                System.out.println("Employee detail added to the list");
                employeeCount++;

            }
            else if(nxtChoice.compareTo("2")==0) {
                boolean toContinue = true;
                while (true) {
                    if(masterData.getEmpList().size()==0){
                        System.out.println("The employee list is empty");
                        break;
                    }
                    else {
                        System.out.println("--------------Enter the coice--------------");
                        System.out.println("1.Display employee details   \n2.Add attendance to the employee  \n3.Show eligible employee list  \n4.Exit");
                        String displayChoice = sc.nextLine();
                        if (displayChoice.compareTo("1") == 0) {
                            masterData.employeeDetailDisplay();
                        } else if (displayChoice.compareTo("2") == 0) {
                            int noOfWorkingDays;
                            for (Employee employee1 : masterData.getEmpList()) {
                                System.out.println("Enter the number of working day for the employee " + employee1.getEmpId());
                                while (true) {
                                    try {
                                        noOfWorkingDays = sc.nextInt();
                                        sc.nextLine();
                                        if(noOfWorkingDays>0){
                                            attendanceMaster.addAttendance(employee1, noOfWorkingDays);
                                            break;
                                        }
                                        else{
                                            System.out.println("Number of working day should not be negative");
                                            System.out.println("Re-enter the number of working day for the employee");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Number of working days should be number");
                                        System.out.println("Re-enter the number of working day for the employee");
                                        sc.nextLine();
                                    }
                                }
                            }
                        }else if(displayChoice.compareTo("3")==0){

                            attendanceMaster.showEligibleList();
                        }
                        else if (displayChoice.compareTo("4") == 0) {
                            toContinue = false;
                            break;

                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                }
                if (!toContinue) {
                    break;
                }
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
}
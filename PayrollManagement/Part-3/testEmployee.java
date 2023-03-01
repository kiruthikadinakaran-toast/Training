import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class testEmployee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MasterData masterData=new MasterData();
        AttendanceMaster attendanceMaster=new AttendanceMaster();
        ArrayList<Employee> empList=new ArrayList<>();
        SalCalculator salCalculator=new SalCalculator();
        boolean toCalculateSalary=false;
        int lastId=1002;
        int employeeCount = 1001;
        String nxtChoice="";
        while (true) {
            System.out.println("--------------Enter the choice--------------");
            System.out.println("1.Add employee detail  \n2.Display employee details   \n3.Add attendance to the employee  \n4.Filtered employee list  \n5.Update attendance to the employee\n6.Sort\n7.Calculate salary for eligible employee\n8.Exit");
            nxtChoice=sc.nextLine();
            if(nxtChoice.compareTo("1")==0){
                System.out.println("Enter the details of employee  " + employeeCount);
                Employee employee=new Employee();
                System.out.println("Enter the employee name");
                String name = "";
                name = sc.nextLine();
                employee.setEmpName(name);
                String departmentChoice ;
                String[] departmentList={"R&D","IT","HR","Testing","Support"};
                while (true) {
                    System.out.println("Enter the employee department \n1.R&D  \n2.IT \n3.HR \n4.Testing \n5.Support");
                    try {
                        departmentChoice = sc.nextLine();
                        int convertedIntchoice=Integer.parseInt(departmentChoice);
                        if (convertedIntchoice > 0 && convertedIntchoice <= 5) {
                            employee.setDepartment(departmentList[convertedIntchoice - 1]);
                            break;
                        } else {
                            System.out.println("Invalid choice1");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid choice");
                    }
                }
                String designationChoice;
                String[] designationList={"Software Intern","Software Developer","Manager","Director","Vice President","CEO"};
                while (true) {
                    System.out.println("Enter the employee designation \n1.Software Intern \n2.Software Developer \n3.Manager \n4.Director \n5.Vice President \n6.CEO");
                    try {
                        designationChoice= sc.nextLine();
                        int convertedDesigChoice=Integer.parseInt(designationChoice);
                        if(convertedDesigChoice>0 && convertedDesigChoice<=6){
                            employee.setDesignation(designationList[convertedDesigChoice-1]);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid choice");
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
                empList.add(employee);
            }
            else if(nxtChoice.compareTo("2")==0) {
                if (masterData.getEmpList().size() == 0) {
                    System.out.println("The employee list is empty");
                } else {
                    masterData.employeeDetailDisplay();
                }
            }
            else if(nxtChoice.compareTo("3")==0){
                if(empList.size()==0 && masterData.getEmpList().size()==0){
                    System.out.println("You didn't enter any employee detail yet");
                }
                else if(empList.size()==0){
                    System.out.println("You already added the attendance of all employee");
                }
                else{
                    int noOfWorkingDays;
                    for(Employee emp:empList) {
                        while (true) {
                            System.out.println("Enter the number of working day for the employee " + emp.getEmpId());
                            try {
                                noOfWorkingDays = sc.nextInt();
                                sc.nextLine();
                                if (noOfWorkingDays > 0) {
                                    attendanceMaster.getEmpAttendancedict().put(emp, noOfWorkingDays);
                                    break;
                                }
                                else{
                                    System.out.println("Number of working days should not be negative");
                                }
                            } catch (InputMismatchException exception) {
                                System.out.println("Number of working days should be number");
                                sc.nextLine();
                            }

                        }
                    }
                    lastId=empList.get(empList.size()-1).getEmpId();
                    empList.clear();
                }
            } else if (nxtChoice.compareTo("4")==0) {
                if (attendanceMaster.getEmpAttendancedict().size()!=0) {
                    attendanceMaster.filterEmployeeList();
                    toCalculateSalary = true;
                }
                else{
                    System.out.println("The attendance is not been entered yet");
                }
            } else if (nxtChoice.compareTo("5")==0) {
                int empId;
                int updatedWorkingDays;
                boolean toBreak=false;
                if (attendanceMaster.getEmpAttendancedict().size()>0) {
                    while (true) {
                        try {
                            System.out.println("Enter the employee id");
                            empId = sc.nextInt();
                            sc.nextLine();
                            if (empId >= 1001 && empId <= lastId) {
                                while (true) {
                                    try {
                                        System.out.println("Enter the number of working days");
                                        updatedWorkingDays = sc.nextInt();
                                        sc.nextLine();
                                        if (updatedWorkingDays >= 0) {
                                            attendanceMaster.getEmpAttendancedict().put(masterData.getEmpList().get(empId-1001), updatedWorkingDays);
                                            toBreak=true;
                                            toCalculateSalary=false;
                                            break;
                                        } else {
                                            System.out.println("Working days cannot be negative");
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println("Working days should be value");
                                        sc.nextLine();
                                    }
                                }
                                if(toBreak){
                                    break;
                                }
                            } else {
                                System.out.println("The employee id is not found");
                            }

                        } catch (InputMismatchException ex) {
                            System.out.println("Employee id should be value");
                        }
                    }
                }
                else{
                    System.out.println("Inorder to update the attendance you should enter the attendance to the employee");
                }
            }
            else if (nxtChoice.compareTo("6")==0) {
                quick_sort(masterData.getEmpList(),3,0,masterData.getEmpList().size()-1);
                for(Employee e: masterData.getEmpList()){
                    System.out.println(e.toString());
                }
            }
            else if (nxtChoice.compareTo("7")==0) {
                if(toCalculateSalary) {
                    salCalculator.calculateSalary(attendanceMaster.getEmpAttendancedict());
                    toCalculateSalary=false;
                }
                else{
                    System.out.println("First filter the eligible employees");
                }
            }
            else if (nxtChoice.compareTo("8")==0) {
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
    public static int partition(ArrayList<Employee> list, int ch, int low, int high) {
        String pi="";
        String element="";
        int i = (low-1); // smaller element index
        for (int j=low; j<high; j++) {
            if(ch==1){
                pi = list.get(high).getEmpName();
                element = list.get(j).getEmpName();
            }
            else if(ch==2){
                pi = list.get(high).getDesignation();
                element = list.get(j).getDesignation();
            }
            else {
                pi = list.get(high).getDepartment();
                element = list.get(j).getDepartment();
            }
            if (element.compareTo(pi)<=0) {
                i++;
                Employee temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Employee temp = list.get(i+1);
        list.set(i+1, list.get(high));
        list.set(high, temp);

        return i+1;
    }
    public static void quick_sort(ArrayList<Employee> list, int choice, int low, int high) {
        if (low < high) {
            int pi = partition(list,choice, low, high);
            quick_sort(list, choice,low, pi-1);
            quick_sort(list, choice,pi+1, high);
        }
    }
}
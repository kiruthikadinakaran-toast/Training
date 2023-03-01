import java.util.ArrayList;

public class MasterData {
    private ArrayList<Employee> empList=new ArrayList<>();
    public void addEmployeeToList(Employee emp){
        empList.add(emp);
    }
    public ArrayList<Employee> getEmpList(){
        return empList;
    }
    public void employeeDetailDisplay(ArrayList<Employee> employeeList){
        System.out.println("______________________________________________________________________________________");
        System.out.printf("%-10s %-20s %-20s %-20s %-10s\n","Id","Name","Department","Designation","Salary");
        System.out.println("______________________________________________________________________________________");
        for(Employee employee:employeeList){
            System.out.println(employee.toString());
        }
    }


}

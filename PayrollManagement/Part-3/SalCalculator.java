import java.util.HashMap;

public class SalCalculator {
    public void calculateSalary(HashMap<Employee,Integer> employeeDictionary){
        System.out.println("____________________________________________________________________________________________________________________________");
        System.out.printf("%-19s %-20s %-20s %-20s %-10s %-10s %-10s %-10s\n","Id","Name","Department","Designation","Salary","Pf","Gross","Net");
        System.out.println("____________________________________________________________________________________________________________________________");
        for (Employee employee : employeeDictionary.keySet()) {
            double salary=employee.getOriginalSalary();
            double pf=salary*0.1;
            double gross=employee.getSalary();
            double net=gross-pf;
            System.out.printf("%-19d %-20s %-20s %-20s %-10.2f %-10.2f %-10.2f %-10.2f\n",employee.getEmpId(),employee.getEmpName(),employee.getDepartment(),employee.getDesignation(),salary,pf,gross,net);

        }

    }

}

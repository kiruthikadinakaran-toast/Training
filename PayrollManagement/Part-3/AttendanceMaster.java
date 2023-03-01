

import java.util.HashMap;
import java.util.Iterator;

public class AttendanceMaster {
    private HashMap<Employee,Integer> empAttendancedict=new HashMap<Employee,Integer>();;
    public HashMap<Employee,Integer> getEmpAttendancedict(){return empAttendancedict;}


    public void showEligibleList(){
        if(empAttendancedict.size()==0){
            System.out.println("Number of working days is not entered");
        }
        else {
            System.out.println("Eligible employee list:");
            for (Employee employee : empAttendancedict.keySet()) {
                if (empAttendancedict.get(employee) >= 10) {
                    System.out.println("-------------Employee detail of "+employee.getEmpId()+"-------------");
                    System.out.println(employee.toString());
                    System.out.println("Number of working days:"+empAttendancedict.get(employee));
                }
            }
        }
    }
    public void filterEmployeeList() {
//        ArrayList<Employee> key = new ArrayList<>(empAttendancedict.keySet());
//        for (Employee employee : key) {
//            int days = this.empAttendancedict.get(employee);
//            if (days <= 10) {
//                this.empAttendancedict.remove(employee);
//            }
//        }
        Iterator<Employee> it = empAttendancedict.keySet().iterator();
        while (it.hasNext()) {
            Employee employee = it.next();
            int attendance = empAttendancedict.get(employee);
            if (attendance <= 10) {
                it.remove();
            }
        }

    }
}

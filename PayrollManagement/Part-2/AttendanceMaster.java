
import java.util.HashMap;
import java.util.Map;

public class AttendanceMaster {
    HashMap<Employee,Integer> empAttendancedict=new HashMap<Employee,Integer>();;
    public void addAttendance(Employee employee,int attendance){
        empAttendancedict.put(employee, attendance);
    }
    public void showEligibleList(){
        for (Map.Entry<Employee, Integer> entry : empAttendancedict.entrySet()) {
            if (entry.getValue()>10) {
                System.out.println(entry.getKey().toString());
            }
        }
    }
}

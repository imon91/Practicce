import java.util.HashMap;
import java.util.Map;

public class OrgChart {
    static class Employee {
        int id;
        String name;
        int reportsTo;
        Employee(int id, String name, int reportsTo) {
            this.id = id;
            this.name = name;
            this.reportsTo = reportsTo;
        }
    }

    static Map<Integer, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        String input = "1,Ben,0\n2,Kate,4\n3,Damien,2\n4,Jane,1\n5,Meng,4\n6,Rahim,2";

        // parse input and create employee objects
        for (String line : input.split("\n")) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int reportsTo = Integer.parseInt(parts[2]);
            Employee e = new Employee(id, name, reportsTo);
            employees.put(id, e);
        }

        // print organizational chart
        printOrgChart(1, 0);
    }

    static void printOrgChart(int employeeId, int indentationLevel) {
        Employee e = employees.get(employeeId);
        for (int i = 0; i < indentationLevel; i++) {
            System.out.print("  ");
        }
        System.out.println(e.name);
        for (Employee e2 : employees.values()) {
            if (e2.reportsTo == employeeId) {
                printOrgChart(e2.id, indentationLevel + 1);
            }
        }
    }
}

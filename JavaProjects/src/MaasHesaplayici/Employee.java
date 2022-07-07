package MaasHesaplayici;


public class Employee {
    private String name;
    private double salary;
    private int workHour;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHour = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        double taxRate = salary > 1000 ? 0.03 : 0;

        return salary * taxRate;
    }

    public double bonus() {
        int bonusPerHour = 30;
        int extraWorkHour = workHour - 40;

        if (extraWorkHour > 0) {
            return extraWorkHour * bonusPerHour;
        }
        return 0;
    }

    public double raiseSalary() {
        int currentYear = 2021;
        int workYear = currentYear - hireYear;
        double raiseRate;

        if (workYear > 19) {
            raiseRate = 0.15;
        } else if (workYear > 9) {
            raiseRate = 0.10;
        } else {
            raiseRate = 0.05;
        }

        return salary * raiseRate;
    }

    @Override
    public String toString() {
        return
                "Adı : " + name + "\n" +
                        "Maaşı : " + salary + "\n" +
                        "Çalışma Saati : " + workHour + "\n" +
                        "Başlangıç Yılı : " + hireYear + "\n" +
                        "Vergi : " + tax() + "\n" +
                        "Bonus : " + bonus() + "\n" +
                        "Maaş Artışı : " + raiseSalary() + "\n" +
                        "Vergi ve Bonuslar ile birlikte maaş : " + (salary + bonus() - tax()) + "\n" +
                        "Toplam Maaş : " + (salary + raiseSalary());
    }

    public static void main(String[] args) {
        Employee employee = new Employee("kemal", 2000.0, 45, 1985);
        System.out.println(employee);
    }
}

public class FirstTest{
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        if(args.length == 4){
            //input
            String name = args[0];
            int age = Integer.valueOf(args[1]);
            //float salary = Float.valueOf(args[2]);
            //boolean java = Boolean.valueOf(args[3]);
            float salary = args[2].floatValue();
            boolean java = args[3].booleanValue();
            int workedMonths = args[4].intValue();

            //process
            int birthYear = 2021 - age;
            float periodSalary = salary * workedMonths;
            
            //output
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Birth Year: " + birthYear);
            System.out.println("Month Salary: " + salary);
            System.out.println("Salary in Period: " + periodSalary);
            System.out.println("Java: " + java);

        } else{
            System.out.println("Invalid Parameters");
        }
    }
}
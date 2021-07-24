public class PrimeiroTeste{
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        if(args.length == 4){
            String nome = args[0];
            int idade = Integer.valueOf(args[1]);
            float salario = Float.valueOf(args[2]);
            boolean java = Boolean.valueOf(args[3]);

            System.out.println(nome);
            System.out.println(idade);
            System.out.println(salario);
            System.out.println(java);

        } else{
            System.out.println("Invalid Parameters");
        }
    }
}
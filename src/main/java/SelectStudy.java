import java.sql.SQLOutput;
import java.util.Scanner;

public class SelectStudy {
    //Project1 - Spor kursu için seçilecek öğrencileri belirleyen bir uygulama yazınız

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Formu doldurunuz");
        System.out.println("Enter a number of Student...:");
        int numberOfStudent = scan.nextInt();

        String[] students = new String[numberOfStudent];
        String[] gender = new String[numberOfStudent];
        double[] weight = new double[numberOfStudent];
        double[] height = new double[numberOfStudent];

        boolean isSuccess = true;
        do {
            isSuccess=true;
            for (int i = 0; i < numberOfStudent; i++) {
                System.out.println("isim ....:");
                students[i] = scan.next();

                System.out.print("cinsiyet...:");
                String gen = scan.next().toUpperCase().substring(0, 1);
                if (gen.equals("K") || gen.equals("E")) {
                    gender[i] = gen;
                } else {
                    System.out.println("Hatalı giriş yaptınız");
                    isSuccess = false;
                    break;
                }
                System.out.println("boy..:");
                height[i] = scan.nextDouble();
                System.out.println("kilo..:");
                weight[i] = scan.nextDouble();

            }

        } while (!isSuccess);
        System.out.println();
        int counter=0;
        System.out.println("*** kursa seçilen öğrenciler ***");
        for(int i=0;i<numberOfStudent; i++){
            if(gender[i].equals("K") && weight[i]>=50 && weight[i]<=70 && height[i]>=1.50){
                System.out.println("isim: "+students[i]+" cinsiyet: "+gender[i]+" boy: "+height[i]+" kilo: "+weight[i]);
                counter++;
            }else if(gender[i].equals("E") && weight[i]>=70 && weight[i]<=90 && height[i]>=1.60){
                System.out.println("isim: "+students[i]+" cinsiyet: "+gender[i]+" boy: "+height[i]+" kilo: "+weight[i]);
                counter++;
            }
        }
        //kursa seçilen öğrenci yoksa
        if(counter==0){
            System.out.println("Malesef kurs gereksinimlerini sağlayan öğrenci bulunamadı.");
        }
    }

}

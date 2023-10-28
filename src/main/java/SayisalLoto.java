import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {
    public static void main(String[] args) {
     startLoto();


    }
    public static void startLoto(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayısal loto için hane sayısı giriniz..:");
        int sayLots = scan.nextInt();
        System.out.print("Sayılar için minimum değer girimniz...:");
        int min = scan.nextInt();
        System.out.print("Sayılar için maximum değer girimniz...:");
        int max = scan.nextInt();

        int[] LotoArr = new int[sayLots];
        int[] tickerArr = new int[sayLots];
        int randomNumber1 = 0;
        int randomNumber2 = 0;
        Random random = new Random();
        boolean isRepeated;
        for (int i = 0; i < sayLots; i++) {
            do {
                isRepeated = false;
                randomNumber1 = random.nextInt(max + 1 - min) + min;
                for (int j = 0; j < i; j++) {
                    if (LotoArr[j] == randomNumber1) {
                        isRepeated = true;
                        break;
                    }

                }

            } while (isRepeated);
            LotoArr[i] = randomNumber1;


            do {
                isRepeated = false;
                randomNumber2 = random.nextInt(max + 1 - min) + min;
                for (int j = 0; j < i; j++) {
                    if (tickerArr[j] == randomNumber2) {
                        isRepeated = true;
                        break;
                    }

                }

            } while (isRepeated);
            tickerArr[i] = randomNumber2;


        }
        System.out.println("Bilet Number...:");
        for (int i = 0; i <tickerArr.length;i++){
            System.out.print(tickerArr[i]+ "  ");

        }
        System.out.println();
        System.out.println("Loto Number...:");
        for (int i = 0; i <LotoArr.length;i++){
            System.out.print(LotoArr[i]+ "  ");

        }
        System.out.println();
       int result= compareArr(LotoArr,tickerArr);
       if(result>0){
           System.out.println("Tebrikler "+ result + " eşleşme gerçekleşmiştir");
       }else{
           System.out.println("Herhangi bir eşleşme gerçekleşmemiştir");
       }

    }

    public static int compareArr(int[]arr,int[]brr){
        int counter=0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<brr.length;j++){
                if(arr[i]==brr[j]){
                    counter++;
                }
            }
        }
        return counter;
    }
}
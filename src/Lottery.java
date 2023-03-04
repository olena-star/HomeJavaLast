import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


    public class Lottery {

        public static void main (String[] args) {

            Lottery lottery = new Lottery();

            lottery.generateRandomArray();

            lottery.setWinningNumbers();

            lottery.enterYourNumbers();

            lottery.compareWinningAndUsersNumbers();


        }

        // генерируем три массива из 1 - всех чисел  2 - выиграшных 3 - введённых пользователем
        ArrayList<Integer> allNumbers = new ArrayList<>();
        ArrayList<Integer> winNumbers = new ArrayList<>();
        ArrayList<Integer> usersNumbers = new ArrayList<>();
        // создаем генератор случайных чисел
        Random random = new Random();

        // метод который заполняет массив случайных чисел от 0 до 50
        public void generateRandomArray() {
            for (int i = 0; i < 50; i++) {
                int num = random.nextInt(50);
                allNumbers.add(num);
            }
        }

        // генерирует выиграшные числа
        public void setWinningNumbers() {
            for (int i = 0; i < 5; i++) {
                int num = random.nextInt(50);
                winNumbers.add(allNumbers.get(num));
            }
        }

        // вводим пользовательские числа
        public void enterYourNumbers() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 5 numbers from 1 to 50");
            for (int i = 0; i < 5; i++) {
                int num = scanner.nextInt();
                if (num < 0 || num > 50) {
                    System.out.println("Wrong numbers entered");
                    i--;
                } else if (usersNumbers.contains(num)) {
                    System.out.println("You have already entered this number ");
                    i--;
                } else {
                    usersNumbers.add(num);
                }
            }
        }


        // сопоставляем пользовательские и выиграшные числа
        public void compareWinningAndUsersNumbers() {
            int count = 0;
            for (int i = 0; i < winNumbers.size(); i++) {
                if (winNumbers.contains(usersNumbers.get(i))) {
                    count++;
                }
                if (count == 4)
                    System.out.println("JackPot");
            }
            System.out.println(count + " Number of comparisons");
        }
    }





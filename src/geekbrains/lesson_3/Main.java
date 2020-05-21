package geekbrains.lesson_3;

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
//1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        //инициализируем сканер
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        do {
            int guessedNumber = random.nextInt(10); //загадываем рандомное число
            System.out.println("Угдай число от 0 до 9 с 3-х попыток");
            for (int i = 3; i > 0; i--) {//даём пользователю 3 попытки
                System.out.println("Введи свой ответ: ");
                int userAnswer = scanner.nextInt(); //переменная пользовательского ответа
                if (userAnswer == guessedNumber) { //условие победы
                    System.out.println("Вы угадали число, молодец!");
                    break;
                }
                System.out.println(userAnswer > guessedNumber ? "Загаданное число меньше " : "Загаданное число больше ");
                System.out.println((i - 1) > 0 ? " у вас осталось " + (i - 1) + " попыток." : "Попытки закончились, вы проиграли.");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        }
        while (scanner.nextInt() == 1);//Повторять пока пользователь воодит еденицу
        guessFruit();
    }


    //2 * Создать массив из слов String[]
    // words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
    // "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    // "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы
    private static void guessFruit (){
        System.out.println("Lesson 3 task 2");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //загадаем слово из массива
        int i = (int) (Math.random() * 25);//делаю рандомную переменную что бы по её номеру бралось случайное
        // слово из массива
        String word = words[i];
        int lenWord = word.length();
        System.out.println("программа загадала одно из следующих слов: \"apple\", \"orange\", \"lemon\", \"banana\", " +
                "\"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\",\n" +
                "\"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\"," +
                "\"olive\", \"pea\", \"peanut\",\n" +
                "\"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\" отгадайте какое.");
        //инициализируем сканер
        Scanner scanner = new Scanner(System.in);
        do {
            //спрашиваем ответ
            System.out.println("Введи свой ответ: ");
            String answer = scanner.nextLine();
            if (word.equals(answer)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            //делаем подсказку
            char[] charsAnswer = answer.toCharArray();
            for (int j = 0; j < lenWord; j++) {
                if (j >= charsAnswer.length) break;
                if (word.charAt(j) != charsAnswer[j]) charsAnswer[j] = '#';
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
            for (int j = comment.length(); j < 15; j++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
    }
    }


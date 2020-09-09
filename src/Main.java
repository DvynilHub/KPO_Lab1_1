import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException, AWTException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Password pass = new Password();
        pass.setSamp(in);
        System.out.println("Введите пароль:");
        while (!pass.isEquals()){
            pass.setPassword(in.readLine());

            System.out.println(pass.toString());
            if (pass.isEquals()){

                break;
            }
        }

    }
    public static class Password{
        private String password;
        private String sample;

        String getPassword() {
            return password;                //Гетер пароля
        }

        void setPassword(String password) {          //Сетер пароля
            this.password = password;

        }

        String getSample() {            //Гетер пароля-экземпляра
            return sample;
        }

        void setSample(String sample) {    //Сетер пароля-экземпляра
            this.sample = sample;
        }

        Password() {
            this.password = "";
        }
        /*Сравнение введенного пароля и пароля-экземпляра*/
        boolean isEquals(){
            return getPassword().equals(getSample());
        }
        /*Процедура установки нового пароля(при желании)
        Если N - пароль устанавливается автоматически*/
        void setSamp(BufferedReader in) throws IOException, AWTException {
            System.out.println("Задать новый пароль?(Y/N)");
            if (in.readLine().equals("Y") ){
                System.out.println("Задайте пароль:");
                setSample(in.readLine());
                //click(65,750);
                /*эксперементальная функция очистки консоли
                после установки нового пароля */
            } else {
                System.out.println("Пароль будет задан по умолчанию");
                setSample("ABC123");
            }
        }
        /*Процедура очистки консоли путем нажатия на кнопку
        очистки указанием координат на экране*/
        public static void click(int x, int y) throws AWTException{
            Robot bot = new Robot();
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON1_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_MASK);
        }

        @Override
        public String toString() {
            if (isEquals()) return "Верный пароль";
            else return "Пароль введен неверно. Попробуйте еще раз.";

        }
    }
}

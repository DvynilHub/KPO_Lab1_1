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

            System.err.println(pass.toString());
            if (pass.isEquals()){

                break;
            }
        }

    }

}

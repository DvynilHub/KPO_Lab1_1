import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Password pass = new Password("ABC123");
        System.out.println("Введите пароль:");
        while (pass.isEquals() == false){
            pass.setPassword(in.readLine());

            System.out.println(pass.toString());
            if (pass.isEquals() == true){

                break;
            }
        }

    }
    public static class Password{
        private String password;
        private String sample;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;

        }

        public  String getSample() {
            return sample;
        }

        public void setSample(String sample) {
            this.sample = sample;
        }

        public Password(String sample) {
            this.sample = sample;
            this.password = "";
        }
        public boolean isEquals(){
            if (getPassword().equals(getSample()) == true){
                return true;
            } else return false;
        }

        @Override
        public String toString() {
            if (isEquals() == true){
               return "Верный пароль";
            } else return "Пароль введен неверно. Попробуйте еще раз.";

        }
    }
}

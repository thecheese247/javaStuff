public class HelloThere {

    public static void main(String[] args){
        System.out.println("What is your name?");
        String name = IOUtil.readString();
        System.out.println("Hi " + name);
    }

}
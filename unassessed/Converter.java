public class Converter{

    public static void main(String[] args){
        System.out.println("What number to you wish to convert");
        double x = IOUtil.readDouble();
        System.out.println(x + " miles is " 
                            + (UnassessedSimpleLibrary.milestoMetres(x)/1000)
                            + "km");
        System.out.println(x + " degrees F is " 
                            + UnassessedSimpleLibrary.farenheitToCelsius(x)
                            + " degrees C");
    }

}
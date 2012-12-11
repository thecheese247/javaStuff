public class EvenNumbers{

    public static void main(String[] args){
        System.out.println("Please type in a number:");
        int x = IOUtil.readInt();
        if(UnassessedSimpleLibrary.isEven(x)){
            System.out.println(x + " is even");
        } else {
            System.out.println(x + " is odd");
        }
        System.out.println("The next even number is "
                                + UnassessedSimpleLibrary.nextEven(x));
    }

}
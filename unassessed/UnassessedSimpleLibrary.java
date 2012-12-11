public class UnassessedSimpleLibrary{

    public static int nextEven(int i){
        return(i%2==1?i+1:i+2);
    }

    public static boolean isEven (int i){
        return(i%2==0);
    }
    
    public static double farenheitToCelsius(double x){
        return((x-32)*(5.0/9.0));
    }
    
    public static double milestoMetres(double j){
        return(j*1609.344);
    }
    
    public static boolean isASCIIUpperCase(char letter){
        return isInASCIIRange(letter, 'A', 'Z');
    }
    
    public static boolean isASCIILowerCase(char letter){
        return isInASCIIRange(letter, 'a', 'z');
    }
    
    public static boolean isASCIINumber(char number){
        return isInASCIIRange(number, '0', '9');
    }
    
    private static boolean isInASCIIRange(char character, char lowerBound,
                                                            char upperBound){
        return(character>=lowerBound && character<=upperBound);
    }
    
    public static int letterIndex(char character){
    assert (isASCIIUpperCase(character) || isASCIILowerCase(character));
        if(isASCIIUpperCase(character)){
            return(character - 'A');
        }else{
            return(character - 'a');
        }
    }
    
    public static int digitCharToInt(char digit){
    assert (isASCIINumber(digit));
        return digit - '0';    
    }
}
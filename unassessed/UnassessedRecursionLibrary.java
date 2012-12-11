public class UnassessedRecursionLibrary{

    public static int sumDivisors(int n){
        if(n==0||n==1){
            return n;
        }
        return sumDivisorsSub(n, 1, 0);
    }
    
    private static int sumDivisorsSub(int n, int psbleDivisor, int partialSum){
        if(psbleDivisor>(int)(Math.sqrt(n))){
            return partialSum;
        }else if(n%psbleDivisor==0){
            int divided = (n%psbleDivisor==n/psbleDivisor?0:n/psbleDivisor);
            partialSum+=psbleDivisor+divided;
        }
        return sumDivisorsSub(n, (psbleDivisor+1), partialSum);
    }

    public static int findAliqoutCliqueMember(int n){
        return n;
        //TODO
    }
}
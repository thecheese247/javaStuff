public class SimpleBlackJack{

    public static void main(String[] args){
        int gold  = 1000;
        while(gold>0){
            int wager = getWager(gold);
            if(wager==0){
                break;
            }
            int playerScore = playerScore();
            int dealerScore = dealerScore();
            System.out.println("Player scored: " +  playerScore
                                + ", dealer scored: " + dealerScore);
            gold = calculateNextGold(gold, wager, playerScore, dealerScore);
        }
    }

    public static int calculateNextGold(int gold, int wager, 
                                        int playerScore, int dealerScore){
        if(playerScore>21 || (dealerScore<=21 && dealerScore>playerScore)){
            System.out.println("Player lost");
            return gold-wager;
        }else if(dealerScore>21 || playerScore>dealerScore){
            System.out.println("Player won");
            return gold+wager;
        }else{
            System.out.println("Player drew");
            return gold;
        }
    }
    
    private static int getWager(int gold){
        System.out.println("You have " + gold + " gold");
        System.out.println("How much do you wish to wager? (Enter 0 to quit)");
        int amount = IOUtil.readInt();
        //if(amount==0){
        //    return;
        //}
        while(amount<0 || amount>gold){
            System.out.println("I'm sorry, that wasn't a valid amount."
                                + "Please try again");
            amount = IOUtil.readInt();
        }
        return amount;
    }
    
    private static int rollDie(){
        return 1+((int) (Math.random()*6));
    }
    
    private static int dealerScore(){
        int sum=0;
        while(sum<17){
            sum += rollDie();
        }
        return sum;
    }
    
    private static int playerScore(){
        int total = 0;
        int hitOrStick = 1;
        while(hitOrStick!=0 && total<21){
            total += rollDie();
            if(total>21){
                break;
            }
            System.out.println("Your total is: " + total + "\nEnter 0 to stick, or"
                            + " anything else to hit");
            hitOrStick = IOUtil.readInt();
        }
        return total;
    }
}

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
/*
Team: Jives
Written by: Brian Leahy 17372896,
            Oscar Byrne Carty 17430786,
            Gearoid Lynch 17459176
 */
public class Dice {

    private DefaultUserInputModel userInputModel;
    private Boolean firstTurn=true;
    private int diceOne;
    private Boolean diceOneValid=true;
    private int diceTwo;
    private Boolean diceTwoValid=true;

    public int getDiceOne() {
        return diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }

    public Boolean getDiceOneValid() {
        return diceOneValid;
    }

    public Boolean getDiceTwoValid() {
        return diceTwoValid;
    }

    public void invalidateDice(int d) {
        if(!rollDouble()){
            if(d==1){
                diceOneValid=false;
            }else if(d==2){
                diceTwoValid=false;
            }
        }
    }

    public Boolean rollDouble(){
        if(diceOne==diceTwo){
            return true;
        }
        return false;
    }

    public Dice(DefaultUserInputModel userInputModel) {
        this.userInputModel = userInputModel;

        this.userInputModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("turn".equals(evt.getPropertyName())&&firstTurn==false){
                    //turn changed
                    rollDice();
                }
            }
        });
    }

    public void rollDice() {

        Random rand = new Random();
        diceOne = (rand.nextInt(6)) + 1;
        diceTwo = (rand.nextInt(6)) + 1;
        if (userInputModel.getTurn()==0){
          userInputModel.setInfoPanelOutput(userInputModel.getRedPlayerName()+ " rolls:");
        }else{
            userInputModel.setInfoPanelOutput(userInputModel.getBluePlayerName()+ " rolls:");
        }
        userInputModel.setInfoPanelOutput("Dice One: " + diceOne);
        userInputModel.setInfoPanelOutput("Dice Two: " + diceTwo);
        diceOneValid=true;
        diceTwoValid=true;
    }

    public void startDice() {
        firstTurn=true;
        Random rand = new Random();

        diceOne = (rand.nextInt(6)) + 1;
        diceTwo = (rand.nextInt(6)) + 1;


        userInputModel.setInfoPanelOutput("\n"+userInputModel.getRedPlayerName()+" rolls: " + diceOne);
        userInputModel.setInfoPanelOutput(userInputModel.getBluePlayerName()+" rolls: " + diceTwo);

        if(diceOne > diceTwo) {
            userInputModel.setInfoPanelOutput(userInputModel.getRedPlayerName()+ " goes first:");
            userInputModel.setTurn(0);
        }
        else if(diceOne < diceTwo) {
            userInputModel.setInfoPanelOutput(userInputModel.getBluePlayerName()+ " goes first:");
            userInputModel.setTurn(1);
        }
        else {
            userInputModel.setInfoPanelOutput("Since both rolls are equal, we roll again:\n");
            startDice();
        }
        firstTurn=false;
        diceOneValid=true;
        diceTwoValid=true;
    }

}

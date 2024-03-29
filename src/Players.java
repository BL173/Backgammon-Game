import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;
/*
Team: Jives
Written by: Brian Leahy 17372896,
            Oscar Byrne Carty 17430786,
            Gearoid Lynch 17459176
 */
public class Players {
    private String playerName;
    private int playerColour;
    private DefaultUserInputModel userInputModel;
    private String userInput;


    Players(String playerName, int playerColour){
        this.playerName = playerName;
        this.playerColour = playerColour;
    }

    //private static final int INPUT_FIELD_WIDTH = 15;
    //private JTextField commandInputField;



   /*public Players(DefaultUserInputModel userInputModel){
       this.userInputModel = userInputModel;
       this.userInputModel.addPropertyChangeListener(new PropertyChangeListener() {
           @Override
           public void propertyChange(PropertyChangeEvent evt) {
               if ("playerName".equals(evt.getPropertyName())){
                   //User input changed
                   setPlayerName(userInputModel.getPlayerName());
               }
           }
       });
    }*/




    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setPlayerColour(int playerColour){
        this.playerColour = playerColour;
    }

    public String getPlayerName(){
        return playerName;
    }

}

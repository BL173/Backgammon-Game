import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
/*
Team: Jives
Written by: Brian Leahy 17372896,
            Oscar Byrne Carty 17430786,
            Gearoid Lynch 17459176
 */


public class MainFrame extends JFrame{
    private String userInput;
    DefaultUserInputModel userInputModel = new DefaultUserInputModel();
    JPanel commandPanel = new CommandPanel(userInputModel);
    JPanel gameBoardPanel = new GameBoardPanel(userInputModel);
    JPanel infoPanel = new InfoPanel(userInputModel);


    public MainFrame() throws HeadlessException {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Backgammon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());
        add(commandPanel, BorderLayout.PAGE_END);
        add(gameBoardPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.LINE_START);

        this.userInputModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if("winner".equals(evt.getPropertyName()) && !(userInputModel.getWinner() == " ")){
                    if(userInputModel.getWinner() == "red"){
                        JFrame announceWinner = new AnnounceWinner("red");
                        announceWinner.setVisible(true);
                        CloseFrame();
                    }else if(userInputModel.getWinner() == "blue") {
                        JFrame announceWinner = new AnnounceWinner("blue");
                        announceWinner.setVisible(true);
                        CloseFrame();
                    }
                }

            }
        });


    }
    public void CloseFrame() {
        super.dispose();
    }


}

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DefaultUserInputModel implements UserInputModel{
    private PropertyChangeSupport propertyChangeSupport;
    private String userInput;

    public DefaultUserInputModel(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public String getUserInput(){
        return userInput;
    }
    //@Override
    public void setUserInput(String newUserInput){
        String oldUserInput = userInput;
        userInput = newUserInput;
        propertyChangeSupport.firePropertyChange("userInput", oldUserInput, userInput);
        userInput = "";
        propertyChangeSupport.firePropertyChange("userInput", oldUserInput, userInput);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
   /* @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }*/
}

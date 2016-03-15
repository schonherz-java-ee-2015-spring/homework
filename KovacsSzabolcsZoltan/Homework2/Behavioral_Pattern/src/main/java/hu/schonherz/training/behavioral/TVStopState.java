package hu.schonherz.training.behavioral;

public class TVStopState implements State {
	
	//The TV is OFF state
    public String doAction() {
        return "TV is turned OFF";
    }
}
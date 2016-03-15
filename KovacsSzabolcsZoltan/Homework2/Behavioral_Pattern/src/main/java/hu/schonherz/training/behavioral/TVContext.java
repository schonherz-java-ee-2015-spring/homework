package hu.schonherz.training.behavioral;

public class TVContext implements State {

	private State tvState;
	//Setting the TV status
	public void setState(State state) {
		this.tvState = state;
	}
	//Getting the TV status
	public State getState() {
		return this.tvState;
	}
	//Returns a string with the status of the TV
	public String doAction() {
		return this.tvState.doAction();
	}

}
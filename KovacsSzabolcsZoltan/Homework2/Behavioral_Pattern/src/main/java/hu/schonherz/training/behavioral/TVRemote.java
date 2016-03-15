package hu.schonherz.training.behavioral;

public class TVRemote {
	
	public static TVContext context = new TVContext();

	
    public static void main(String[] args) {
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();
         
        context.setState(tvStartState);
        context.doAction();
        
        context.setState(tvStopState);
        context.doAction();
         
    }
 
}

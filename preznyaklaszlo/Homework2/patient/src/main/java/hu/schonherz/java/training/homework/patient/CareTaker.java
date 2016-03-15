package hu.schonherz.java.training.homework.patient;

import java.util.ArrayList;
import java.util.List;

//This is the memory class. We save the conditions in a list!
public class CareTaker {

	private List<Condition> conditionList = new ArrayList<Condition>();

	public void add(Condition condition) {
		conditionList.add(condition);
	}

	public Condition get(int index) {
		return conditionList.get(index);
	}

}

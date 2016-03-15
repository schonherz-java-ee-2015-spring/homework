package hu.schonherz.java.training.homework.patient;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Condition> conditionList = new ArrayList<Condition>();

	public void add(Condition condition) {
		conditionList.add(condition);
	}

	public Condition get(int index) {
		return conditionList.get(index);
	}

}

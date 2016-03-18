package hu.schonherz.training.beans;

public class Blogs {

	public String ID;
	public String name;
	public String text;

	public Blogs(String iD, String name, String text) {
		super();

		this.ID = iD;
		this.name = name;
		this.text = text;
	}

	public Blogs() {
	}

	@Override
	public String toString() {
		return "Blogs [ID=" + ID + ", name=" + name + ", text=" + text + "]";
	}

}
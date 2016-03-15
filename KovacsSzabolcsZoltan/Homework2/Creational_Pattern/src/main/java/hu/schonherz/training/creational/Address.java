package hu.schonherz.training.creational;

public class Address {
	private final String houseNumber;
	private final String floorNumber;
	private final String street;
	private final String city;
	private final String province;
	private final String country;
	private final String zip;
	private final String landmark;

	private Address(AddressBuilder ab) {
		this.houseNumber = ab.houseNumber;
		this.floorNumber = ab.floorNumber;
		this.street = ab.street;
		this.city = ab.city;
		this.province = ab.province;
		this.country = ab.country;
		this.zip = ab.zip;
		this.landmark = ab.landmark;
	}
	//Building the whole address from the parameters
	public static class AddressBuilder {
		public AddressBuilder a;
		private String houseNumber;
		private String floorNumber;
		private String street;
		private String city;
		private String province;
		private String country;
		private String zip;
		private String landmark;

		public AddressBuilder houseNumber(String hno) {
			this.houseNumber = hno;
			return this;
		}

		public AddressBuilder floorNumber(String fno) {
			this.floorNumber = fno;
			return this;
		}

		public AddressBuilder street(String st) {
			this.street = st;
			return this;
		}

		public AddressBuilder city(String ct) {
			this.city = ct;
			return this;
		}

		public AddressBuilder province(String p) {
			this.province = p;
			return this;
		}

		public AddressBuilder country(String c) {
			this.country = c;
			return this;
		}

		public AddressBuilder zip(String z) {
			this.zip = z;
			return this;
		}

		public AddressBuilder landmark(String l) {
			this.landmark = l;
			return this;
		}

		public String build() {
			return new Address(this).toString();
		}

		}
		@Override
		public String toString() {
			return "Address [houseNumber=" + houseNumber + ", floorNumber=" + floorNumber + ", street=" + street
					+ ", city=" + city + ", province=" + province + ", country=" + country + ", zip=" + zip
					+ ", landmark=" + landmark + "]";
		}
	}



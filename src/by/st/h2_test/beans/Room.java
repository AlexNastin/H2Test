package by.st.h2_test.beans;

public final class Room extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 151929209579060226L;

	private int idRoom;
	private double price;

	public Room(int idRoom, double price) {
		super();
		this.idRoom = idRoom;
		this.price = price;
	}

	public Room() {
		super();
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRoom;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (idRoom != other.idRoom)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", price=" + price + "]";
	}

}

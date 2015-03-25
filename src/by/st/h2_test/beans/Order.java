package by.st.h2_test.beans;

public final class Order extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3483519269773583628L;

	private int idOrder;
	private int idUser;
	private int idRoom_rooms;

	public Order(int idOrder, int idUser, int idRoom_rooms) {
		super();
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.idRoom_rooms = idRoom_rooms;
	}

	public Order() {
		super();
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdRoom_rooms() {
		return idRoom_rooms;
	}

	public void setIdRoom_rooms(int idRoom_rooms) {
		this.idRoom_rooms = idRoom_rooms;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOrder;
		result = prime * result + idRoom_rooms;
		result = prime * result + idUser;
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
		Order other = (Order) obj;
		if (idOrder != other.idOrder)
			return false;
		if (idRoom_rooms != other.idRoom_rooms)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", idUser=" + idUser
				+ ", idRoom_rooms=" + idRoom_rooms + "]";
	}

	
	
	
}

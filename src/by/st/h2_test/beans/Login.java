package by.st.h2_test.beans;

public final class Login extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137723090291052911L;

	private int idLogin;
	private String name;
	private String email;
	private int password;

	public Login(int idLogin, String name, String email, int password) {
		super();
		this.idLogin = idLogin;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Login() {
		super();

	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idLogin;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + password;
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
		Login other = (Login) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idLogin != other.idLogin)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password != other.password)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [idLogin=" + idLogin + ", name=" + name + ", email="
				+ email + ", password=" + password + "]";
	}

}

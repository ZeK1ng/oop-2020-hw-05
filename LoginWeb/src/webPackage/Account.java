package webPackage;

public class Account {
	private String username;
	private String password;
	public Account(String uname, String pw) {
		this.username = uname;
		this.password = pw;
	}
	public String getUserName() {
		return this.username;
	}
	public String getPw() {
		return this.password;
	}
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(! (o instanceof Account)) return false;
		Account acc2 = (Account) o;
		if(this.username.equals(acc2.getUserName()) && this.password.equals(acc2.getPw())) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		String s = this.username + this.password;
		
		return s.hashCode();
	}
}

package webPackage;
import java.util.*;
public class AccountManager {
	private HashSet<Account> accDataBase = new HashSet<Account>();
	private HashSet<String> names= new HashSet<String>();
	private static AccountManager AccManager;
	
	public static synchronized AccountManager getInstance() {
		if(AccManager == null) {
			AccManager = new AccountManager();
		}
		return AccManager;
	}
	
	private AccountManager() {
		accDataBase.add(new Account("Patrick","1234"));
		accDataBase.add(new Account("Molly","FloPup"));
		names.add("Patrick");
		names.add("Molly");
	}
	public Boolean createNewAccount(String uname, String pw) {
		if(names.contains(uname)) {
			return false;
		}
		Account newAcc = new Account(uname, pw);
		if(accDataBase.contains(newAcc)) {
			return false;
		}
		accDataBase.add(newAcc);
		names.add(uname);
		return true;
	}
	public Account login(String name , String pw) {
		Account user = new Account(name,pw);
		if(accDataBase.contains(user)) {
			return user;
		}
		return null;
	}
}

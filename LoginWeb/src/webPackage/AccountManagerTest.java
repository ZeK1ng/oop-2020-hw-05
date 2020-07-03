package webPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountManagerTest {

	@Test
	void test() {
		AccountManager accM = AccountManager.getInstance();
		assertFalse(accM.createNewAccount("Patrick", "1234"));
	}

}

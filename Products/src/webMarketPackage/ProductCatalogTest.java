package webMarketPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
class ProductCatalogTest {

	@Test
	void test() {
		ProductCatalog prod = new ProductCatalog();
		Map<String,Product> l = prod.getCatalog();
		assertEquals(14, l.size());
	}

}

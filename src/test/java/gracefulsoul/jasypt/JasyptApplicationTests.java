package gracefulsoul.jasypt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gracefulsoul.config.PropertyEncryptConfig;
import gracefulsoul.user.UserService;

@SpringBootTest(classes = { UserService.class, PropertyEncryptConfig.class })
class JasyptApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PropertyEncryptConfig propertyEncryptConfig;

	@Autowired
	private UserService userService;

	@Test
	void getDrinkTest() {
		String drink = this.userService.getDrink();
//		this.logger.info("Original user.drink value : " + drink);
		String decryptedDrink = this.getDecryptValue(drink.substring(4, drink.length() - 1));
//		this.logger.info("Decrypted user.drink value : " + decryptedDrink);
		assertEquals("Ballantines", decryptedDrink);
	}
	
	String getDecryptValue(String str) {
		return this.propertyEncryptConfig.pooledPBEStringEncryptor().decrypt(str);
	}

}

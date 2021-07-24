package gracefulsoul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import gracefulsoul.user.UserService;

@Component
public class JasyptCheck {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public JasyptCheck(UserService userService) {
		logger.info("User's kind of drink : " + userService.getDrink());
	}

}

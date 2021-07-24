package gracefulsoul.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Value("${user.drink}")
	private String drink;

	public String getDrink() {
		return this.drink;
	}

}

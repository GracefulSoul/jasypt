package gracefulsoul.config;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyEncryptConfig {

	private static final String PASSWORD = "GracefulSoul";
	private static final String SHA256_AES128_ALGORITHM = "PBEWithSHA256And128BitAES-CBC-BC";

	@Bean
	public PooledPBEStringEncryptor pooledPBEStringEncryptor() {
		PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
		pooledPBEStringEncryptor.setProvider(new BouncyCastleProvider());
		pooledPBEStringEncryptor.setPoolSize(2);
		pooledPBEStringEncryptor.setPassword(PASSWORD);
		pooledPBEStringEncryptor.setAlgorithm(SHA256_AES128_ALGORITHM);
		return pooledPBEStringEncryptor;
	}

}

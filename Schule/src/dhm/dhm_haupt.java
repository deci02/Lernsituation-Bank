package dhm;

import java.math.BigInteger;
import java.util.Random;

public class dhm_haupt {

	private BigInteger shared_prime;
	private BigInteger generator;
	private BigInteger personal_key;
	private BigInteger shared_secret_key;
	private BigInteger intermediate_key;
	private static final int CERTAINTY = 30;

	public static void main(String[] args) {
		BigInteger prim = BigInteger.valueOf(47);
		BigInteger generator = BigInteger.valueOf(5);
		if (!dhm_haupt.check_safe_prime(prim)) {
			System.out.println("nicht safe prime");
		}

		BigInteger personal_key_a = BigInteger
				.valueOf(new Random().nextInt(prim.subtract(BigInteger.valueOf(2)).intValueExact() + 1));
		BigInteger personal_key_b = BigInteger
				.valueOf(new Random().nextInt(prim.subtract(BigInteger.valueOf(2)).intValueExact() + 1));

		dhm_haupt A = new dhm_haupt(personal_key_a, prim, generator);
		dhm_haupt B = new dhm_haupt(personal_key_b, prim, generator);

		B.calc_final(A.calc_intermediate_key());
		A.calc_final(B.calc_intermediate_key());

		System.out.println(A.getShared_secret_key().equals(B.getShared_secret_key()));
		System.out.println(A.getShared_secret_key().longValueExact());
	}

	public static BigInteger get_random_prime(int groessenordnung) {
		return BigInteger.valueOf(new Random().nextInt(groessenordnung)).nextProbablePrime();
	}

	public static BigInteger get_generator(BigInteger prime) {
		for (int i = 2; i < prime.intValueExact(); i++) {
			if (BigInteger.valueOf(i)
					.modPow((prime.subtract(BigInteger.valueOf(1)).divide(BigInteger.valueOf(2))), prime)
					.equals(BigInteger.valueOf(1))) {
				return BigInteger.valueOf(i);
			}
		}
		return null;
	}

	public dhm_haupt(BigInteger personal_key, BigInteger prim, BigInteger generator) {
		this.personal_key = personal_key;
		this.shared_prime = prim;
		this.generator = generator;
	}

	public static boolean check_safe_prime(BigInteger p) {
		return BigInteger.valueOf((p.longValueExact() - 1) / 2).isProbablePrime(CERTAINTY);
	}

	public BigInteger calc_intermediate_key() {
		return generator.modPow(this.personal_key, this.shared_prime);
	}

	public void calc_final(BigInteger p) {
		this.shared_secret_key = p.modPow(this.personal_key, this.shared_prime);
	}

	public BigInteger getShared_secret_key() {
		return shared_secret_key;
	}

}

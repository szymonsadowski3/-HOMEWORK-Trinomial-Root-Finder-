package sadowski;

public class Calculator {
	Double[] getTrinomialRoots(double a, double b, double c) {
		double delta = b * b - 4 * a * c;
		if (delta < 0)
			return null;
		else if (delta == 0)
			return new Double[] { -b / (2 * a) };
		else {
			double sqrtDelta = Math.sqrt(b * b - 4 * a * c);
			return new Double[] { (-b - sqrtDelta) / (2 * a), (-b + sqrtDelta) / (2 * a) };
		}
	}
}

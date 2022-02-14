package draw;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import org.junit.jupiter.api.Test;
import sun.awt.CGraphicsEnvironment;

class StdDrawTest {

	@Test
	void test() {
		//		GraphicsEnvironment graphicsEnvironment = new CGraphicsEnvironment();
		//		for (Font f : graphicsEnvironment.getAllFonts()) {
		//			System.out.println(f.getFontName());
		//		}

		StdDraw.setScale(-2, +2);
		StdDraw.enableDoubleBuffering();

		double x = 10, y=20;

		for (double t = 0.0; true; t += 0.02) {
		StdDraw.filledRectangle(50, 50, 5, 5);
		StdDraw.show();
		StdDraw.pause(20);
		}
//		for (double t = 0.0; true; t += 0.02) {
//			double xx = Math.sin(t);
//			double yy = Math.cos(t);
//			StdDraw.clear();
//			StdDraw.filledCircle(xx, yy, 0.05);
//			StdDraw.filledCircle(-xx, -yy, 0.05);
//			StdDraw.show();
//			StdDraw.pause(20);
//		}


	}
}
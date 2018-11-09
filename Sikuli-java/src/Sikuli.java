
/**
 * 
 */

/**
 * @author priyatham.bolli
 *
 */
import java.util.Iterator;
import java.util.List;

import org.sikuli.script.App;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.sikuli.script.Match;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;

public class Sikuli {

	static Screen _screen = new Screen();

	public static void find(String region) throws FindFailed {
		try {
			_screen.find(region);
			System.out.println("Element " + region + " has been found successfully");
		} catch (Exception e) {
			System.out.println("Fail to find the element");
		}
	}

	public static void click(String region) throws FindFailed {
		try {
			_screen.click(region);
			System.out.println("Element " + region + " has been clicked successfully");
		} catch (Exception e) {
			System.out.println("Fail to click on element");
		}
	}

	public static void sendkey(String label) {
		try {
			_screen.type(label);
			System.out.println("Typed " + "'" + label + "'" + " and Sendkeys method Passed successfully");
		} catch (Exception e) {
			System.out.println("Sendkeys method Failed");
		}
	}

	public static void exists(String image, double time) {
		try {
			_screen.exists(image, time);
			System.out.println("'" + image + "'" + " exists and exists method Passed");
		} catch (Exception e) {
			System.out.println("exists Failed");
		}
	}

	public static void waitforImage(String image, double time) {
		try {
			_screen.wait(image, time);
			System.out.println("Waited for the " + "'" + image + "'" + " Image for " + time + "  Seconds and "
					+ "wait method Passed");
		} catch (Exception e) {
			System.out.println("wait Failed");
		}
	}

	public static void setAutoWaitTimeout(double sec) {
		try {
			_screen.setAutoWaitTimeout(sec);
			System.out.println("Waited for " + "'" + sec + "'" + "  Seconds");
		} catch (Exception e) {
			System.out.println("wait Failed");
		}
	}

	public static void findAll(String img) throws FindFailed {
		try {
			Iterator<Match> it = _screen.findAll(img);
			while (it.hasNext()) {
				it.next().highlight(1);
				System.out.println("findAll Passed");
			}
		} catch (Exception e) {
			System.out.println("findAll Failed");
		}
	}


	public static void findany(String img) throws FindFailed {
		try {
			_screen.findAny(img);
			System.out.println("Element " + img + " has been found successfully");
		} catch (Exception e) {
			System.out.println("Fail to find the element");
		}
	}
	
	public static void findAllCount(String img) throws FindFailed {
		try {
			List<Match> it = _screen.findAllList(img);
			System.out.println("Total Count of Image '" + img + "' = " + it.size());
		} catch (Exception e) {
			System.out.println("findAllCount method Failed");
		}

	}

	public static void scrollMouseWheelDown(String img, int script) throws FindFailed {
		try {
			_screen.wheel(img, Button.WHEEL_DOWN, 1);
			System.out.println("Mouse has been scrolled down " + script + " times successfully");
		} catch (Exception e) {
			System.out.println("Fail to find the element");
		}
	}

	public static void scrollMouseWheelUp(String img, int script) throws FindFailed {
		try {
			_screen.wheel(img, Button.WHEEL_UP, 1);
			System.out.println("Mouse has been scrolled up " + script + " times successfully");
		} catch (Exception e) {
			System.out.println("Fail to find the element");
		}
	}

	/**
	 * Closes the current focused program.
	 */
	public static void closeFocusedProgram() {
		try {
			if (System.getProperty("os.name").equals("Mac OS X")) {
				_screen.type("q", Key.CMD);
			}
			if (System.getProperty("os.name").contains("Windows")) {
				_screen.type(Key.F4, KeyModifier.WIN | KeyModifier.ALT);
			}

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickSimilarImage(Pattern img) throws FindFailed {

		try {
			_screen.wait(img.similar((float) 0.90), 2).click(); // Click the Image with 90% Match
		} catch (Exception e) {
			System.out.println("findAll Failed");
		}

		// Usage:
		// final Pattern searchbar = new Pattern("imgs/search.png");
		// Sikuli.clickSimilarImage(searchbar);

	}

	public static void openExeFile(String exeFilePath) throws FindFailed {

		try {
			App calc = new App(exeFilePath);
			// App app = new App("C:\\Program Files\\Internet Explorer\\iexplore.exe");
			calc.open();
			Thread.sleep(2000);
//			calc.focus();
			_screen.highlight(0);
//			_screen.type(null, "d", KeyModifier.ALT);
//			_screen.type("http://abc.com" + Key.ENTER);
			
			calc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void highlight(String img, int time, String color) {
		try {
			// _screen.highlight(time,color);
			// System.out.println("Waited for the " + "'" + image + "'" +" Image for "+ time
			// + " Seconds and " + "wait method Passed");

		} catch (Exception e) {
			System.out.println("highlight Failed");
		}
	}
}

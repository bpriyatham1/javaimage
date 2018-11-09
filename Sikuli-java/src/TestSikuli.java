import org.sikuli.script.*;

public class TestSikuli {

	public static void calc() throws FindFailed {
		Sikuli.find("imgs/search.png");
		Sikuli.click("imgs/search.png");
		Sikuli.setAutoWaitTimeout(2);
		Sikuli.exists("imgs/searchbar.png", 3);
		Sikuli.sendkey("Calculator");
		Sikuli.setAutoWaitTimeout(1);
		Sikuli.exists("imgs/calcfound.png", 3);
		Sikuli.click("imgs/calcfound.png");
		Sikuli.waitforImage("imgs/calclayout", 3);
		Sikuli.exists("imgs/calclayout", 2);
		Sikuli.closeFocusedProgram();
	}

	public static void findAll() throws FindFailed {
		Sikuli.find("imgs/search.png");
		Sikuli.click("imgs/search.png");
		Sikuli.waitforImage("imgs/search.png", 2);
		Sikuli.sendkey("folders: teststeps");
//		Sikuli.exists("imgs/testfolder.png", 2);
		Sikuli.waitforImage("imgs/teststepsfolder.png", 2);
		Sikuli.findAllCount("imgs/teststepsfolder.png");
		Sikuli.scrollMouseWheelDown("imgs/teststepsfolder.png",1);
		Sikuli.scrollMouseWheelUp("imgs/teststepsfolder.png",1);
		Sikuli.closeFocusedProgram();
	}

	public static void clickImagewithPercentageMatch() throws FindFailed {
		// Sikuli.clickSimilarImage("imgs/shortcutsfolder.png");
	}

	public static void main(String[] args) throws FindFailed {
//		Sikuli.find("katalonshortcut.png");
		Sikuli.openExeFile("C:\\Windows\\System32\\calc.exe");
		
	}
}

// Screen s = new Screen();
// try {
//
//
// s.wait("imgs/search.png");
// s.click("imgs/search.png");
// s.type("Calculator");
// } catch (FindFailed e) {
// e.printStackTrace();
// }

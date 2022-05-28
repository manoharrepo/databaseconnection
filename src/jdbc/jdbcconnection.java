package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconnection {
	static String host = "localhost";
	int port = 3306;

	public static void main(String args[]) throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + 3306 + "/test", "root", "root");
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from credential where scenario = \"scenario1\"");
		rs.next();
		String user = rs.getString("username");
		String pass = rs.getString("password");

		System.out.println(user + " " + pass);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Manohar\\Downloads\\chromedriver_win32_ver100\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(pass);

	}

}

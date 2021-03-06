package week5day2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Erailsort {

	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.xpath("//label[text()='Sort on Date']")).click();	//DESELECT CHECKBOX
	    Thread.sleep(1000);
		driver.findElement(By.id("txtStationFrom")).clear();  //from
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS",Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();   //to
		driver.findElement(By.id("txtStationTo")).sendKeys("MMCT",Keys.ENTER);
		List<WebElement> train1=driver.findElements(By.xpath("//a[text()='MS  CSMT EXP']"));  //1st train-USING FOREACH
		for(WebElement WebElement: train1) {
			String text = WebElement.getText();
			System.out.println("the first displayed train name is:"+text);}
		
		WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
	        List<WebElement> rows = table.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		System.out.println("the number of trains are:"+rows.size());
		for (int i = 1; i < rows.size(); i++) {
		String t = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
		System.out.println(t);
		
	}

}}
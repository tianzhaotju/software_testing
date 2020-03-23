package cn.tjuscs.selenium;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Selenium {
	public static String[][] getLoginInfo() throws Exception{
		String[][] res = new String[20][2];
		//1.设定Excel文件所在路径
        String excelFilePath = "D:\\eclipse\\eclipse-workplace\\softwareTesting\\experiment2\\test\\cn\\tjuscs\\selenium\\SeleniumLab2020.xlsx";
        //2.读取Excel文档对象
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(new FileInputStream(excelFilePath));
        //3.获取要解析的表格（第一个表格）
        XSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        
        for (int i = 0; i < 20; i++) {//遍历每一行
            //4.获得要解析的行
            XSSFRow row = sheet.getRow(i);
            //5.获得每个单元格中的内容（String）
            String stringCellValue1 = row.getCell(1).getStringCellValue();
            String stringCellValue2 = row.getCell(2).getStringCellValue();
            res[i][0] = stringCellValue1;
            res[i][1] = stringCellValue2;
        }
		return res;
	}
	public static void main(String[] args) {
		try {
			String[][] sz = getLoginInfo();
			//1.设置Chrome驱动
			String driverPath = System.getProperty("user.dir") + "/src/driverchrome/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
			//2.设置网站的地址
			String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
			driver.get(baseUrl);
			//3.根据获取到的Excel的信息，登陆网站获取文本
			for(int i=0;i<sz.length;i++) {
				//4.获取用户名
				String userNameTxt = sz[i][0];
				WebElement userName = driver.findElement(By.name("user_number"));
				userName.sendKeys(userNameTxt);
				//5.获取用户密码
				String passNameTxt = sz[i][1];
				WebElement passName = driver.findElement(By.name("password"));
				passName.sendKeys(passNameTxt);
				//6.获取登陆的按钮，并提交
				WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
				submitName.click();
				//7.获取登录后得到的文本
				WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/form/div[5]/code"));
				String webPassWord = passWord.getText();
				//8.打印测试的结果，把获取的文本与原密码相比较
				System.out.print("Test Case:  ");
				System.out.println(i);
				System.out.print("User Name:  ");
				System.out.print(userNameTxt);
				System.out.print("  Password:  ");
				System.out.println(passNameTxt);
				System.out.print("get text from Chrome:");
				System.out.println(webPassWord);
				if (passNameTxt.contentEquals(webPassWord)){
		            System.out.println("Test Passed!");
		        } else {
		            System.out.println("Test Failed");
		        }
				System.out.println();
			}
			//9.关闭
			driver.close();
		}catch(Exception e){
			System.out.print(e);
		}
	}
}

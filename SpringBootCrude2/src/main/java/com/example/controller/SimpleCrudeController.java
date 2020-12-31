package com.example.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.employee;
import com.example.service.CrudeService;


@Controller
public class SimpleCrudeController {
	
	/*@RequestMapping("/")
	public String Login() {
		
		return "la_login";
	}*/
	
	@Autowired
	private CrudeService crudeService;
	
	public static WebDriver driver;
	
	@Autowired
    private Environment env;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("starting page load :::: ");
		return "emp";
	}
	
	@RequestMapping(value = { "/auto" }, method = { RequestMethod.GET })
    public String auto(final Locale locale, final Model model) throws InterruptedException {
		System.out.println("starting auto method load :::: ");
        final String link = "https://www.bricsonline.net/bonds/BondsTradedToday";
        final Date date = new Date();
        final DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, locale);
        final String formattedDate = dateFormat.format(date);
        this.autoMationCode();
        model.addAttribute("serverTime", (Object)formattedDate);
        return "emp";
    }
	
	
	@RequestMapping(value = { "/autoFileUpload" }, method = { RequestMethod.GET })
    public String autoFileUpload(final Locale locale, final Model model) throws InterruptedException {
		System.out.println("starting autoFileUpload method load :::: ");
        String link = "https://www.bricsonline.net/bonds/BondsTradedToday";
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, locale);
        String formattedDate = dateFormat.format(date);
        autoFileUploadCode3();
        model.addAttribute("serverTime", (Object)formattedDate);
        return "emp";
    }
    
    private void autoFileUploadCode3() {
    	System.setProperty("webdriver.chrome.driver", env.getProperty("cromeDriver") + "\\chromedriver.exe");
        driver = new ChromeDriver();
       // WebDriver driver = new FirefoxDriver(); 

        driver.get("http://www.freepdfconvert.com/pdf-word"); 

        driver.findElement(By.id("clientUpload")).click();

        driver.switchTo().activeElement().sendKeys("D:\\\\\\\\CentralTrade Repository_SecondaryMarket\\\\\\\\File.txt"); 

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 

        driver.findElement(By.id("convertButton"));
		
	}

	private void autoFileUploadCode2() {
    	//inputFile
    	//file_1
    	System.setProperty("webdriver.chrome.driver", env.getProperty("cromeDriver") + "\\chromedriver.exe");
        driver = new ChromeDriver();
        
        //driver.get("http://www.freepdfconvert.com/pdf-word");
        driver.get("https://www.zamzar.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //driver.findElement(By.name("file_1")).click();
        ////WebElement fileInput = driver.findElement(By.xpath("//input[@id='inputFile']"));////By.name("file_1")
        ////fileInput.sendKeys("D:\\\\c1.jpeg");//Users\\\\HP\\\\Desktop\\\\sample\\\\
        driver.findElement(By.xpath("//input[@id='inputFile']")).sendKeys("D:\\\\\\\\c1.jpeg");
        //driver.findElement(By.id("SWFUpload_0")).click();
//        Robot r=null;
//		try {
//			r = new Robot();
//		} catch (AWTException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        r.keyPress(KeyEvent.VK_C);        // C
//        r.keyRelease(KeyEvent.VK_C);
//        r.keyPress(KeyEvent.VK_COLON);    // : (colon)
//        r.keyRelease(KeyEvent.VK_COLON);
//        r.keyPress(KeyEvent.VK_SLASH);    // / (slash)
//        r.keyRelease(KeyEvent.VK_SLASH);
//        // etc. for the whole file path
//
//        r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
//        r.keyRelease(KeyEvent.VK_ENTER);
        //fileInput.
       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.findElement(By.id("clientUpload")).click();
//        driver.switchTo()
//                .activeElement()
//                .sendKeys(
//                        "C:\\Users\\HP\\Desktop\\sample.pdf");///home/likewise-open/GLOBAL/123/Documents/filename.txt
        //driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Select fruits = new Select(driver.findElement(By.id("convert-format")));
		//png
		//fruits.selectByIndex(1);
		fruits.selectByVisibleText("png");//
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //driver.findElement(By.id("convertButton"));
		driver.findElement(By.id("convert-button")).click();
		
	}

	private void autoFileUploadCode1() {
		// TODO Auto-generated method stub
    	System.setProperty("webdriver.chrome.driver", env.getProperty("cromeDriver") + "\\chromedriver.exe");
        driver = new ChromeDriver();
    	driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		addFile.sendKeys("C:\\Users\\HP\\Desktop\\c1.jpeg");//C:\Users\HP\Desktop///Users/neeraj.kumar/Desktop/c1.jpeg
		//driver.findElement(By.xpath(".//input[@type='file']']")).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(".//span[text()='Start upload']")).click();

//		try {
//			Thread.sleep(2000000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("flag ::::::::::::::"+(driver.findElement(By.xpath(".//a[text()='c1.jpeg']")).isDisplayed()));
		if(driver.findElement(By.xpath(".//a[text()='c1.jpeg']")).isDisplayed()) {
			//assertTrue(true, "Image Uploaded");
			System.out.println("image upload");
		}else {
			//assertTrue(false, "Image not Uploaded");
			System.out.println("image not upload");
		}
	}

	private void autoFileUploadCode() {
    	System.setProperty("webdriver.chrome.driver", env.getProperty("cromeDriver") + "\\chromedriver.exe");
        driver = (WebDriver)new ChromeDriver();
    	driver.get("https://smallseotools.com/plagiarism-checker/");
    	driver.manage().window().maximize();
    	try {
            Thread.sleep(100000L);
        }
        catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    	System.out.println("site load");
    	//Locating upload filebutton
    	//WebElement upload =driver.findElement(By.linkText("Upload a Document:( .tex, .txt, .doc, .docx, .odt, .pdf, .rtf )"));
    	//upload.sendKeys("D:\\CentralTrade Repository_SecondaryMarket\\File.txt"); 
    	WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
    	addFile.sendKeys("D:\\\\CentralTrade Repository_SecondaryMarket\\\\File.txt");
    	driver.findElement(By.xpath(".//input[@type='file']")).click();
    	System.out.println("after click");
    	
    	
    	
    	
    	
    	//driver.close();
		
	}

	public void autoMationCode() {
    	System.out.println("starting autoMationCode load :::: ");
        final String link = "https://www.bricsonline.net/bonds/BondsTradedToday";
        final Date date = new Date();
        final File df = new File(env.getProperty("cromeDriver"));
        //if (!df.exists()) {
            //df.mkdirs();
        //}
        System.setProperty("webdriver.chrome.driver", env.getProperty("cromeDriver") + "\\chromedriver.exe");
        driver = (WebDriver)new ChromeDriver();
        final String baseUrl = "https://www.bseindia.com/markets/debt/debt_search.aspx";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        final DateFormat date_format = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println("date >>>>>>>>>>>>>>> " + date_format.format(date));
        Date myDate = null;
        try {
            myDate = date_format.parse(date_format.format(date));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        final Date oneDayBefore = new Date(myDate.getTime() - 2L);
        final String result = date_format.format(oneDayBefore);
        System.out.println("result :::::::: " + result);
        String currentDay = "";
        String currentMonth = "";
        String currentYear = "";
        String lastDay = "";
        String lastMonth = "";
        String lastYear = "";
        final String string = date_format.format(date);
        final String[] Parts = string.split("-");
        currentDay = Parts[0];
        System.out.println("currentDay first :::::::::: " + currentDay);
        final Integer lstDayCs = Integer.parseInt(Parts[0]);
        System.out.println("lstDayCs :::::::::::: " + lstDayCs);
        if (lstDayCs < 10) {
            currentDay = Parts[0].replace("0", "");
            System.out.println("currentDay in :::::::: " + currentDay);
        }
        System.out.println("currentDay out:::::::: " + currentDay);
        currentMonth = Parts[1];
        currentYear = Parts[2];
        final String[] lastParts = result.split("-");
        lastDay = lastParts[0];
        final Integer lstDay = Integer.parseInt(lastParts[0]);
        if (lstDay < 10) {
            lastDay = lastParts[0].replace("0", "");
            System.out.println("lstDay ::::: " + lstDay);
        }
        System.out.println("lastDay ::::: " + lastDay);
        lastMonth = lastParts[1];
        lastYear = lastParts[2];
        driver.findElement(By.id("ContentPlaceHolder1_txtFromDate")).click();
        final Select dropdown = new Select(driver.findElement(By.className("ui-datepicker-month")));
        if (currentDay.equals("1")) {}
        dropdown.selectByVisibleText(lastMonth);
        final Select dropdown2 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        dropdown2.selectByVisibleText(lastYear);
        final WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        final List<WebElement> rows = (List<WebElement>)dateWidget.findElements(By.tagName("tr"));
        final List<WebElement> columns = (List<WebElement>)dateWidget.findElements(By.tagName("td"));
        for (final WebElement cell : columns) {
            if (cell.getText().equals("1")) {
                cell.findElement(By.linkText("1")).click();
            }
        }
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        driver.findElement(By.id("ContentPlaceHolder1_txtTodate")).click();
        final Select dropdownTo = new Select(driver.findElement(By.className("ui-datepicker-month")));
        dropdownTo.selectByVisibleText(lastMonth);
        final Select dropdownTo2 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        dropdownTo2.selectByVisibleText(lastYear);
        final WebElement dateWidgetTo = driver.findElement(By.id("ui-datepicker-div"));
        final List<WebElement> rowsTo = (List<WebElement>)dateWidgetTo.findElements(By.tagName("tr"));
        final List<WebElement> columnsTo = (List<WebElement>)dateWidgetTo.findElements(By.tagName("td"));
        for (final WebElement cell2 : columnsTo) {
            if (cell2.getText().equals("1")) {
                cell2.findElement(By.linkText("1")).click();
            }
        }
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        final WebElement option1 = driver.findElement(By.id("ContentPlaceHolder1_rdbtr"));
        option1.click();
        driver.findElement(By.id("ContentPlaceHolder1_btnSubmit")).click();
        final String fileDowanload = "Dowanload file Done successfully";
        System.out.println("Dowanload file Done successfully");
        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        driver.close();
        final String home = System.getProperty("user.home");
        final File f = this.getLastModifiedFile();
        System.out.println("f.name:::::::::::::: " + f.getName());
        System.out.println("file of path is :::::::::::::: " + home + "\\Downloads\\" + f.getName());
        final String FileNameAsString = home + "\\Downloads\\" + f.getName();
        final File a = new File(FileNameAsString);
        final String fname = f.getName();
        final String[] oldfilename = fname.split("\\.");
        System.out.println("filename[0] ::::::::::::::::::::: " + oldfilename[0]);
        System.out.println("filename[1] ::::::::::::::::::::: " + oldfilename[1]);
        final String finalFilname = oldfilename[0] + "_" + currentDay + "_" + currentMonth + "_" + currentYear + "." + oldfilename[1];
        final String destinationFile = "D:\\\\Users\\\\admin\\\\Desktop\\\\FileCopy\\\\" + finalFilname;
        final File dir = new File("D:\\\\CentralTrade Repository_SecondaryMarket\\\\FileCopy\\\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (f.isFile()) {
            a.renameTo(new File("D:\\\\CentralTrade Repository_SecondaryMarket\\\\FileCopy\\\\" + finalFilname));
            System.out.println("Move successfully file name is." + finalFilname);
        }
        else {
        	System.out.println("File is not download that why it's not Move. Date is :" + date_format.format(date));
        }
    }
    
    public File getLastModifiedFile() {
        final String home = System.getProperty("user.home");
        final File fl = new File(home + "/Downloads/");
        final File[] files = fl.listFiles();
        if (files.length == 0) {
            return null;
        }
        
        return files[0];
    }
	
	@RequestMapping(value="/showAll",method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<employee> updateEmp(Model model){
		List<employee> emplist =crudeService.findAll();
		
		//System.out.println("emp.getId() ::: "+emp.getId());
		System.out.println("showAll ::: ");
		return emplist;
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST,produces="application/json")
	public @ResponseBody Integer save(@RequestParam("fname")String firstname,
			@RequestParam("lname")String lastname,
			@RequestParam("address")String address,
			@RequestParam("gen") String gen, Model model) {
		System.out.println(" save ::: ");
		System.out.println("firstname ::: "+firstname);
		System.out.println("lastname ::: "+lastname);
		System.out.println("address ::: "+address);
		System.out.println("gen ::: "+gen);
		employee emp = new employee();
		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		emp.setAddress(address);
		emp.setGender(gen);
		emp.setDflag(1);
		String message ="";
		int i =0;
		emp=crudeService.save(emp);
		System.out.println("emp.getId() ::: "+emp.getId());
		if(emp.getId() >0) {
			message="success";
			i=1;
		}else {
			message="fail";
			i=2;
		}
		System.out.println("message ::: "+message);
		System.out.println("message ::: "+i);
		return i;
	}
	
	@RequestMapping(value ="editData",method = RequestMethod.GET, produces="application/json")
	public @ResponseBody employee editData(@RequestParam("id") int id) {
		employee emp =crudeService.findById(id);
		return emp;
	}
	
	@RequestMapping(value="/updateEmp",method = RequestMethod.POST,produces="application/json")
	public @ResponseBody Integer updateEmp(@RequestParam("id")int id,@RequestParam("fname")String firstname,@RequestParam("lname")String lastname,
			@RequestParam("address")String address,@RequestParam("gen")String gen,Model model){
		employee emp =crudeService.findById(id);
		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		emp.setAddress(address);
		emp.setDflag(emp.getDflag());
		emp.setGender(gen);
		emp=crudeService.save(emp);
		System.out.println("emp.getId() ::: "+emp.getId());
		String message ="";
		int i =0;
		if(emp.getId() >0) {
			message="success";
			i=1;
		}else {
			message="fail";
			i=2;
		}
		System.out.println("message ::: "+message);
		System.out.println("message ::: "+i);
		return i;
	}
	@RequestMapping(value="/deleteEmp",method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Integer deleteEmp(@RequestParam("id")int id,Model model) {
		employee emp = crudeService.findById(id);
		emp.setFirstName(emp.getFirstName());
		emp.setLastName(emp.getLastName());
		emp.setAddress(emp.getAddress());
		emp.setDflag(0);
		emp.setGender(emp.getGender());
		emp=crudeService.save(emp);
		String message ="";
		int i =0;
		if(emp.getId() >0) {
			message="success";
			i=1;
		}else {
			message="fail";
			i=2;
		}
		System.out.println("message ::: "+message);
		System.out.println("message ::: "+i);
		return i;
		
	}
}

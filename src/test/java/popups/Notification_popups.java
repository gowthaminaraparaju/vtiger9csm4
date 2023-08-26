package popups;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Notification_popups {

	public static void main(String[] args) {
	 HashMap<String,Integer> contentSettings=new HashMap<String,Integer>();
	 HashMap<String,Object> profile=new HashMap<String,Object>();
     HashMap<String,Object> preferences=new HashMap<String,Object>();
     ChromeOptions options=new ChromeOptions();
     contentSettings.put("media_stream",1);
     profile.put("managed_default_content_settings",contentSettings);
     preferences.put("profile",profile);
     options.setExperimentalOption("prefs",preferences);
    
	}

}

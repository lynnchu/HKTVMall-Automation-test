package com.hktvmall.www.libs;

public interface objectStore {
	
	
	//---------------------registerPage element--------------------
	public static String register_URL = "https://ecomtest01.hktv.com.hk/hktv/en/register";
	public static String register_Name = "//input[@id='register.email']";
	public static String register_firstName = "//input[@id='register.firstName']";
	public static String register_lastName = "//input[@id='register.lastName']";
	public static String register_selectAge = "//select[@id='ageGroup']";
	public static String register_Gendar = "//input[@id='gender2']";
	public static String register_PWD= "//input[@id='password']";
	public static String register_CheckPwd = "//input[@id='register.checkPwd']";
	public static String register_Button = "//form[@id='hktvRegisterForm']//button";
	public static String register_emailError= "//div/span[@id='email.errors']";
	
	
	//---------------------Main HomePage----------------------------
	public static String MainPageURL="http://ecomtest01.hktv.com.hk/hktv/en/";
	public static String MainPage_Title = "HKTV";
	public static String HelloName = "//div[@class='welcome']/a";
	public static String Main_Link="//div[@class='top-street-link']//a[contains(@href,'main')]";
	public static String subCategoryLink ="//li/span/a[contains(@href,'BeautyandHealth')]";
	public static String subCategryHeader= "//div[@class='category-head']/span/a[contains(@href,'BeautyCare')]";
	public static String Hotpicks_title = "//div[@class='hot-picks']/div[1]/h3";
	public static String FirstHotpicks = "//div[@id='hotPickProductListId']/div[1]";
	public static String FirstQuickView = "//div[@id='hotPickProductListId']/div[1]//span[@class='quick-view']";
	public static String viewDetailsInQVpage = "//span[@class='view-details']";
	public static String FirstSave= "//div[@id='hotPickProductListId']/div[1]//span[@class='save']";
	public static String siteLogo = "//a[@class='site-logo-large']";
	public static String wishlistInBottom = "//li[contains(@class,'wishlist')]/span";
	public static String wishlistLink ="//a[contains(@href,'getWishlistPage')]";
	public static String hotpicks= "//div[@id='hotPickProductListId']/div";
	public static String QtyCountUp="//span[contains(@class,'count-up')]";
	public static String QtyAddtoCart = "//span[@class='add-to-cart']";
	public static String minicart = "//span[@class='top-minicart-toggle']";
	public static String minicartCheckout = "//div[@class='minicart-checkout']";
	
	//--------------------LoginPage element-------------------------
	public static String login_URL="https://ecomtest01.hktv.com.hk/hktv/en/login";
	public static String login_UserName = "//input[@id='j_username']";
	public static String login_Password = "//input[@id='j_password']";
	public static String login_Button = "//button[@id='submitLogin']";
	public static String login_emailError="//div[@id='email-error']/span";
	
	
	//------------------------globalMessages---------------------
	public static String globalMessages= "//div[@id='globalMessages']/div";
	
	
	//-------------------------WishlistPage---------------------------
	public static String wishlistSelect = "//div[@class='wishlist-select']";
	
	
	
	//-------------------------cartPage-------------------------
	public static String removeProducts = "//a[@class='submitRemoveProduct']";
	public static String cartURL = "http://ecomtest01.hktv.com.hk/hktv/en/cart";
	
}

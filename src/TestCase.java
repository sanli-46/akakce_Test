


import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.junit.Assert.assertEquals;


public class TestCase extends BaseDriver {
    @Test
    public void Test1() {


        // Hesap açma butonuna tıklar
        WebElement newAccount = driver.findElement(By.xpath("//a[text()='Hesap Aç']"));
        newAccount.click();


        //İsim (1),soyisim(2) ,email (3),tekrar email(4), şifre(5) ,tekrar şifre(6) girişi

        //(1)
        WebElement name = driver.findElement(By.xpath("//input[@type='text'][@name='rnufn']"));
        name.sendKeys("Can");
        //(2)
        WebElement lastName = driver.findElement(By.xpath("//input[@type='text'][@name='rnufs']"));
        lastName.sendKeys("Cen");
        //(3)
        WebElement email = driver.findElement(By.xpath("//input[@type='email'][@name='rnufe1']"));
        email.sendKeys("sulmoyarza@gufum.com"); // Tek kullanımlık mail
        //(4)
        WebElement tryEmail = driver.findElement(By.xpath("//input[@type='email'][@name='rnufe2']"));
        tryEmail.sendKeys("sulmoyarza@gufum.com");
        //(5)
        WebElement password = driver.findElement(By.xpath("//input[@type='password'][@name='rnufp1']"));
        password.sendKeys("Can123Can");
        //(6)
        WebElement password2 = driver.findElement(By.xpath("//input[@type='password'][@name='rnufp2']"));
        password2.sendKeys("Can123Can");

        //Cinsiyet seçimi
        WebElement gender = driver.findElement(By.xpath("//input[@type='radio'][@name='rngc'][@id='rngm']"));
        gender.click();

        // İl ve İlçe Girişi
        WebElement city = driver.findElement(By.xpath("//option[text()='Afyon']"));
        city.click();

        WebElement county = driver.findElement(By.xpath("//option[text()='Çobanlar']"));
        county.click();


        // Dogum Tarihi girişi .
        WebElement webDay = driver.findElement(By.id("bd"));
        WebElement webMonth = driver.findElement(By.id("bm"));
        WebElement webYear = driver.findElement(By.id("by"));

        Select day = new Select(webDay);
        Select month = new Select(webMonth);
        Select year = new Select(webYear);

        day.selectByVisibleText("16");
        month.selectByValue("4");
        year.selectByVisibleText("1998");


        //Kullanım koşullarını onayla .
        WebElement usageAgreement = driver.findElement(By.xpath("//input[@type='checkbox'][@id=\"rnufpca\"]"));
        usageAgreement.click();

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit'][@value=\"Hesap aç\"]"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement accountCreationControl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='m-c']")));
        assertEquals("Bu eposta adresi zaten kayıtlı. Lütfen giriş yapmayı deneyin.", accountCreationControl.getText());


        // Kullanıcı isminin Can oldugunu kontrol ediyor
        WebElement checkName = driver.findElement(By.cssSelector("[rel='nofollow'][href='/akakcem/']"));
        Assert.assertEquals("Can", checkName.getText());


    }

    @Test
    public void Test2() {
        //bLogoutTest2
//        WebElement hesabim=driver.findElement(By.xpath("//*[text()='Can'] "));
//        hesabim.click();
//        WebElement hMenu = driver.findElement(By.xpath("//a[@title='Hesabım']"));
//        hMenu.click();


        WebElement element = driver.findElement(By.cssSelector("[title='Hesabım']"));
        Actions actions = new Actions(driver);

        Action action = actions.moveToElement(element).build();//elementin üstüne gel
        action.perform();//etkinleştir.

        WebElement exit = driver.findElement(By.xpath("//a[text()='Çık']"));
        exit.click();


        WebElement test = driver.findElement(By.xpath("(//a[text()='Giriş Yap'])[1]"));

        Assert.assertTrue("Çıkış yapılamadı", test.isEnabled());
    }

    @Test

    public void Test3() {

        WebElement girisYap = driver.findElement(By.cssSelector("[id='H_rl_v8'] a+a"));
        girisYap.click();


        WebElement email = driver.findElement(By.cssSelector("[id='life']"));
        email.sendKeys("sulmoyarza@gufum.com");

        WebElement password = driver.findElement(By.cssSelector("[id='lifp']"));
        password.sendKeys("Can123Can");

        WebElement Button = driver.findElement(By.cssSelector("[id='lfb']"));
        Button.click();


        WebElement hMenu = driver.findElement(By.xpath("//a[text()='Hesap Aç']"));
        Assert.assertTrue("YANLIŞ ŞİRRE GİRİŞİ", hMenu.isDisplayed());

    }

    @Test
    public void Test4() {


        WebElement hesabim = driver.findElement(By.xpath("//*[text()='Can'] "));
        hesabim.click();


        WebElement siparislerim = driver.findElement(By.xpath("//a[text()='Siparişlerim']"));
        siparislerim.click();

        WebElement text = driver.findElement(By.xpath("//div[text()='Kayıtlı siparişiniz bulunmuyor.']"));

        Assert.assertTrue("Mesaj kutusu dolu!! ", text.getText().toLowerCase().contains("siparişiniz bulunmuyor"));


    }

    @Test
    public void Test5() {


        WebElement hesabim = driver.findElement(By.xpath("//*[text()='Can'] "));
        hesabim.click();


        //Mesajlarima Giris

        WebElement MyMessages = driver.findElement(By.xpath("//a[text()='Mesajlarım']"));
        MyMessages.click();

        //Mesaj Kutusunun bos oldugunun kontrolu
        WebElement confirmationText = driver.findElement(By.xpath("//div[@class='wbb_v8']"));
        Assert.assertTrue("Listelenecek mesaj bulunamadı", confirmationText.getText().contains("Listelenecek mesaj bulunamadı"));
        System.out.println("Mesajlarim = " + confirmationText.getText());


    }

    @Test
    public void Test6() {


        WebElement hesabim = driver.findElement(By.xpath("//*[text()='Can'] "));
        hesabim.click();


        WebElement hesapsil = driver.findElement(By.xpath("//*[text()='Hesabımı Sil']"));
        hesapsil.click();


        WebElement password2 = driver.findElement(By.xpath("//*[@id='p']"));
        password2.sendKeys("Can123Can");


        WebElement btnHesabimiSil = driver.findElement(By.xpath("//*[@id='u']"));
        btnHesabimiSil.click();

        WaitAndClose();
    }
}


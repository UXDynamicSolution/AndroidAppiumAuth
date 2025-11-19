import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class SampleTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                //definimos si es android o iphone
                .setPlatformName("Android")
                //nombre del telefono
                .setDeviceName("Android Emulator")
                //libreria automatizacion
                .setAutomationName("UiAutomator2")
                //ubicacion apk o package del proyecto
                .setApp("/home/charly/AndroidStudioProjects/android_duoc_pao/ProyectoBase/app/build/outputs/apk/debug/app-debug.apk")
                //tiempo limite de espera
                .setNewCommandTimeout(Duration.ofSeconds(360));

        //driver de appium server
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(10000);
    }

    @Test
    public void testExample() {

        //buscamos elementos por el id en android layouts
        WebElement edUs = driver.findElement(AppiumBy.id("ed_username"));

        //determinamos una accion
        edUs.sendKeys("admin");

        WebElement edPass = driver.findElement(AppiumBy.id("ed_password"));
        edPass.sendKeys("admin");


        WebElement el = driver.findElement(AppiumBy.id("btn_login"));
        el.submit();


        // Funciona sin errores en Appium 9
        System.out.println("Contextos disponibles: " + driver.getContextHandles());
        System.out.println("Contexto actual: " + driver.getContext());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //cerramos la app
            // driver.quit();
        }
    }
}
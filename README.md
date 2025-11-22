Pruebas unitarias automatizadas Android con Appium.

Appium es una tecnología que nos permite automatizar “robotizar” procesos de navegación para Android. También aplica para IoS. Es muy similar al funcionamiento de Selenium para navegadores web. 

Pasos para la implementación:

Verificar si Node está instalado sino instalarlo siguiendo los pasos según el sistema operativo que se está usando.
si node esta instalado, deberán ejecutar el siguiente comando para instalar Appium:

npm install -g appium

Verificamos que Appium esté instalado con el comando: appium

{
  "platformName": "Android",
  "appium:deviceName": "Pixel_3a_API_35_extension_level_13_x86_6",
  "appium:platformVersion": "15",
  "appium:automationName": "uiautomator2",
  "appium:appPackage": "com.example.proyectobase",
  "appium:appActivity": "com.example.proyectobase.MainActivity",
  "appium:ensureWebviewsHavePages": true,
  "appium:nativeWebScreenshot": true,
  "appium:newCommandTimeout": 3600,
  "appium:connectHardwareKeyboard": true
}




Fuente:
https://support.smartbear.com/testcomplete/docs/app-testing/mobile/device-cloud/configure-appium/android-on-windows.html



capabilities Android java

 /**
     * Configura las capabilities y crea el driver de Appium para Android.
     * Define plataforma, dispositivo, motor de automatización, ruta del APK
     * y timeout, luego inicia la conexión con el servidor Appium.
     * QUE SON LAS CAPABILITIES:
     * En Appium, las capabilities (o desired capabilities) son un conjunto de
     * parámetros que le dices al servidor para indicar cómo debe ejecutar la automatización.
     */
    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("Android Emulator")
                .setAutomationName("UiAutomator2")
                .setApp("/home/charly/AndroidStudioProjects/android_duoc_pao/ProyectoBase/app/build/outputs/apk/debug/app-debug.apk")
                .setNewCommandTimeout(Duration.ofSeconds(360));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // ⬇ AÑADIR ESTA LÍNEA SIN CAMBIAR NADA MÁS
        DriverManager.setDriver(driver);

        Thread.sleep(10000);
    }



capabilities android python

capabilities = {
    "browserName" : "chrome",
    "platformName" : "android",
    "appium:platformVersion" : "14",
    "appium:deviceName" : "Google Pixel 7 Pro",
    "appium:automationName": "uiautomator2",
    "sauce:options" : {
        # Check below for the available version
        "appiumVersion" : "latest"
    }
}


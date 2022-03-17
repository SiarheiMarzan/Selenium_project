## A project for calculating the cost of using the Google cloud platform and checking the cost sent to the user's email to compare the costs from the calculator's page and the received value to the mail.

# Requirements

***

* JDK (version 8 or later)
* Maven
* Selenium WebDriver
* TestNG
* Docker
* Selenoid

# Running

* VM options -ea -Dbrowser=chrome -Denvironment=test-data

# Running with Selenoid

* It is using Docker to launch browsers.
* Docker installed and running
* Downloading Configuration Manager binary for PC(Windows64x, Linux..) https://github.com/aerokube/cm/releases
* Rename binary file on cm.exe
* Use command in command line: ./cm.exe selenoid start --vnc (images will be loaded with a VNC server, that is, images
  in which the ability to see the browser screen in real time is available)
* and ./cm.exe selenoid-ui start (download and run Selenoid UI, a graphical shell through which we can view the progress
  of our tests in real time)
* The Selenoid UI is available at http://localhost:8080/

<p>Connecting to the Selenide Selenoid project to run your tests in a Docker container:</p> 
<pre><code>
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("browserName", "UNKNOWN");
capabilities.setCapability("browserVersion", "");
capabilities.setCapability("selenoid:options", Map.String Object of(
    "enableVNC", true,
    "enableVideo", true
));
RemoteWebDriver driver = new RemoteWebDriver(
    URI.create("http://selenoid:4444/wd/hub").toURL(), 
    capabilities
);
</code></pre>

* VM options: -ea -Dbrowser=remoteChrome -Denvironment=test-data or -ea -Dbrowser=remoteFirefox -Denvironment=test-data

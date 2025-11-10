from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
import time

# path to chromedriver binary (adjust if you placed it elsewhere)
chromedriver_path = "/usr/local/bin/chromedriver"

service = Service(executable_path=chromedriver_path)
options = webdriver.ChromeOptions()
# optional: use headless mode on servers
# options.add_argument("--headless=new")  # for modern chrome headless
# required on some systems when running as root (Kali):
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-shm-usage")

driver = webdriver.Chrome(service=service, options=options)

driver.get("https://example.com")
time.sleep(3)
print("Page title:", driver.title)
driver.quit()

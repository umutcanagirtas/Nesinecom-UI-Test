# Nesinecom-UI-Test

Selenium ve rest assured kullanarak birkaç senaryo üzerinden UI/Api Test projesi oluşturdum. Test sonuçlarının raporlanması için Log4j, monitoring edilmesi için allure yapısını, paralel koşumlar için de docker kullandım. Bu proje Web Sitesinine(NesineCom) girerek login olma ve Apiden gelen değer ile UI ekranındaki değerlerin eşleştiğinin kontrolünü sağlayan, monitoring logging yardımıyla çok amaçlı olarak isteğe göre değiştirilebilir bir projedir.

## Kullanılan Teknolojiler

- Java (Projenin yazılmış olduğu kodlama dilidir);
- TestNG(Test Caselerin yazılması ve çıktıların kontrollerinde kullanılan Test Yazım Aracıdır);
- Selenium (Web Sitesini test etmek için kullanılan Test Otomasyon Aracıdır);
- RestAssured (Api istekleri oluşturmak için Kullanılan Test Aracıdır);
- Docker(Container yapısı sayesinde uygulamalarınızı hızla derlemenize, test etmenize ve dağıtmanıza imkan tanıyan bir yazılım aracıdır);
- Allure (Test Sonuclarının monitorize edilmesini sağlar);
- Log4J (Hata sonuçlarının loglanmasını sağlar);
- Page Object Pattern (Projede kullanılan mimari yapıdır).

## Proje Yapısının Açıklanması

Projede aşşağıda açıkladığım yapıyı kullandım;

![image](https://user-images.githubusercontent.com/56224909/194906128-03345950-5089-4e16-a356-e1308de32332.png)

+ **Base:** BaseClass, BasePage ve Constants sınıflarının bulunduğu klasör.
  + **BaseClass** Bu sınıf içerisinde api istek oluşturma ve driver sonlandırma işlemleri yapıldı.
  + **BasePage** Bu sınıf driverları ortak bir sınıfa bağlıyor.
  + **Constants** Bu sınıf içerisinde projede kullanılan sabit değişkenler tanımlandı.

![image](https://user-images.githubusercontent.com/56224909/194903662-a6c4b83e-26f5-4c45-86ce-fd98b1ab9b97.png)

+ **nesinePages:** Pages klasörünün yaratılma sebebi Pape Object Pattern kalıbını uygulamaktır. İçerisinde caselerde kullanılan tüm sayfalar sınıflar aracılığıyla temsil edilir. Pages Klasörü içerisinde; Nesinecom Ana Sayfası, Loginli Nesinecom Ana Sayfası ve Popüler Bahisler Sayfası sınıfları bulunur.
  + **NesineComHomePageWithLogin** Login olunduğunda karşılaşılan sayfadır.
  + **NesineComHomePageWithOutLogin** Uygulama ilk açıldığında yüklenen sayfadır.
  + **NesineComPopularBetsPageWithLogin** Popüler bahisler sayfasıdır. "Ana ekranda populer bahisler" sekmesine tıklandığında açılan sayfadır.
+ **popUpHandler:** Uygulamada bulunan farklı popup ve çerezler için ayrılan yapıdır.
  + **PopUpHandler** Çerezler ve popUpların yönetilmesini sağlayan static bir sınıftır.

![image](https://user-images.githubusercontent.com/56224909/194908928-ee422e5c-b400-4327-89d6-93cb441d654a.png)

+ **features:** Cucumber feature dosyaları bu klasörde bulunur.
  + **NesineComLayoutTest.feature** Layout testlerini barındıran senaryo burada bulunur.
  + **NesineComUITest.feature** UI senaryoları bu sınıfta bulunur.

![image](https://user-images.githubusercontent.com/56224909/194906262-262c1d20-bc5c-4fc7-bce5-c6cd055a2406.png)

+ **Helpers:** Sistemde birden fazla yerde kullanılacağını düşündüğüm metodları bu klasör altında topladım. Böylelikle kod tekrarını önleyip okunaklığı arttırabileceğini düşündüm. Helpers klasörü altında; ActionClass, CustomElementWaits, DataHelpers, Listeners ve Log sınıfları bulunur.
  + **ActionClass** Sayfa aksiyonlarının artması durumunda(moveTo gibi) işimizi kolaylaştırabilecek bir yapıdır. Şuanki tek amacı elementleri görünür olana dek sayfayı harekeket ettirmektir.
  + **CustomElementWaits** Sayfa Yüklenirken geç gelen elementleri beklememizi kolaylaştıran bir sınıftır(clickable, visibility ve findall gibi).
  + **DataHelpers** Listelerden random bir şekilde eleman çekmemize yarayan bir sınıftır.
  + **TestListener** Projede bulunan caseleri dinleyen bir yapıdır.
  + **Log** Loglama yapmamızı sağlayan bir yapıdır.
  + **GalenFramework** Galen ile layout testi yapan sınıftır. "gspec" dosyalarını okuyarak istenen elementlerin layout testlerini gerçkeleştirir.
  + **GeneralServiceHelper** Api ile atılan request işlemini düzenler.
  + **ResponseSpec** Dönen response'u ön koşula sokan sınıftır. Modele eşitleme geçmeden önce status kod ve data tipine bakalır.
  
  
  ![image](https://user-images.githubusercontent.com/56224909/194906034-9630a256-7170-483f-abf8-23c4d891eb54.png)

+ **Models** Model klasörünün yaratılma sebebi projede bulunan modelleri tek bir yapı altında toplamaktır.
  + **ResponseModel** Api sonucu gelen isteği karşılayan ilk sınıftır.
  + **FilterDates** Api sonucu gelen isteği karşılayan sınıflardan biridir.
  + **PopularBetLeague** Projede kullanılması istenen asıl bilgiler bu model içindedir.
  + **PopularBetList** Api sonucu gelen isteği karşılayan sınıflardan biridir.
  
  
![image](https://user-images.githubusercontent.com/56224909/194907132-7d88961e-e989-42a0-ab26-f9d9e84aad3e.png)

+ **services.responseServices:** Api isteklerini oluşturan sınıftır.
  + **NesineComServices** Nesinecom servisine post isteği açan sınıftır.


![image](https://user-images.githubusercontent.com/56224909/194907938-d71726d9-ee04-46e1-9f9c-ebf9c7ee4660.png)

+ **stepDefinition:** Projede bulunan step fonksiyonları klasör altında bulunur.
  + **NesineComSteps** Nesinecom da bulunan tüm step işlemleri bu sınıfta bulunur.

![image](https://user-images.githubusercontent.com/56224909/194908647-5a995529-9df4-41ac-8841-95be71910754.png)


+ **testRunner:** Runner sınıfını barından klasördür.
  **TestRunner** Cucumber runner'ı bulunduran sınıftır.
  
![image](https://user-images.githubusercontent.com/56224909/194907582-a41f9fbd-d8ef-4e31-8045-50b2f3719d7f.png)

+ **resources** Properties dosyları, galen specs dosyaları ve testng.xml dosyaları bulunur.
  + **allure.properties** allure kayıtlarını yönlendiren sınıftır.
  + **log4j.properties** log4j kullanarak log dosyası oluşturma standartlarını ayarladığımız sınıftır.
  + **testng.xml** testlerin koşumunu sağlayan bir xml dosyası.
  + **specs:** Galen framework dosyalarının okuyacağı gspec dosyaları bulunur.
    **nesineComLoginButton.gspec** Ana sayfada bulunan login butonu için layout testini oluşturacak galen gspec dosyasıdır.


![image](https://user-images.githubusercontent.com/56224909/194909643-612e28a7-1245-44c9-8c93-b045326677e6.png)
+ **target:** Allure, galen ve log4j sonuçları bu klasör altında toplanır.
+ **docker-compose.yml:** Projede kullanılan remote driverları bağlayan docker ayarlamaları bu klasör üzerinden yapılır.
+ **pom.xml:** Proje de kullanılan tüm teknolojiler buradan eklenilerek kullanılır.

## Projenin Ayağa Kaldırılması

1. İlk olarak projede bulunan pom.xml içerisinde değişiklik yapılmalıdır. Değişken değerleri değiştirilmeliki proje de kendi login işlemlerinizi gerçekleştirebilesiniz. log4j.properties ve allure.properties dosyalarında kendi pathlerinizi ayarlayabilirsiniz.
2. BaseClass içerisinde driver kaldırma sırasında bilgisayarınızda ki driver pathlerini vermemiz gerekir.
3. Allure monitoring kullanmak isterseniz de bilgisayarınızda allure'nin yüklü olması gerekiyor.
4. Docker kullanmak isterseniz de docker desktop'ın bilgisayarınızda yüklü olması gerekiyor.
5. Daha sonra "mvn test" komutu ile koşum yapabilirsiniz.

## Allure Monitoring Kullanımı

Allure yapısı caseler her tamamlandıktan sonra belirtilen path e kaydediliyor. Bunları görüntülemek için komut satırını açıp "allure serve [config dosyasında ayarladığınız path]\allure-results" girerseniz browserda açılan pencere üzerinde detaylı inceleme yapabilirsiniz.

![image](https://user-images.githubusercontent.com/56224909/194910641-ce94bbfc-785f-4b4d-acf7-6865bae74b05.png)

## Docker Kullanımı

Docker ile koşum yapabilmek içinde "docker-compose -f docker-compose.yml up" kodunu proje dizininde çalıştırmanız gerekiyor.
 
![image](https://user-images.githubusercontent.com/56224909/194911698-e4a5a58e-de26-4c99-a4cb-171375de6f2a.png)


## Örnek Ekran Çıktıları

- Log Yapısının Örnek çıktısı:

![image](https://user-images.githubusercontent.com/56224909/194910808-6e7e88cb-91ec-493b-9bcf-2c50ab8106e0.png)

- Allure Ekran Görüntüsü

![image](https://user-images.githubusercontent.com/56224909/194910962-265d1304-b082-43ec-b2cb-293e8c11c101.png)

- Docker Desktop Ekran Görüntüsü

![image](https://user-images.githubusercontent.com/56224909/194911340-195061a4-4604-4d93-9d63-823b961159eb.png)


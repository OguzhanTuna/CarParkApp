CarParkApp

-> Proje özeti:
  Elimizde mevcut bulunan 10 alanlı otopark' ın işletimi sırasında üzerinde park, parktan çıkış ve boş park alanlarının
  gösterimini içeren teknik olarak temelde Spring Framework ekosisteminin kullanıldığı bir projedir.
 
 -> Proje nasıl indirilir:
  Proje https://github.com/OguzhanTuna/CarParkApp URL üzerinden Code kısmına tıklanılarak "Download ZIP" seçeneği ile
  indirilebilir.
  
-> Proje nasıl çalıştırılır:
  Proje indirildikten sonra Intelijj IDEA üzerinden açılmalı, ve proje ayağa kaldırılmalıdır.
  Proje testi için Postman API yi indirmemiz gerekli. Bunun için aşağıdaki linkten indirmeyi gerçekleştirip, kurulumunu
  yapabilirsiniz. Postman API Link: https://www.postman.com/downloads/
  
  -> Proje nasıl test edilir:
   Kurulumlar yapılıp proje ayağa kaldırıldıktan sonra Postman API üzerinden temel olarak 3 Http Request Type ile
   projeyi test edeceğiz.
   Bunlardan birincisi uygun park alanına araç eklemek için olacaktır. Burada araç eklemek aksiyonu için
   Http POST Request kullanacağız. Postman API üzerinden Request Type POST olarak seçilmeli ve gönderilecek Http Request
   için request body kısmında ilgili araca ilişkin "plate" ve "color" bilgileri attribute olarak girilmelidir. Örnek Http POST 
   Request için URL ve Request Body bilgileri:
   URL: http://localhost:40400/carpark/park
   Body:
   {
      plate : "34-ABC-1002",
      color : "Red"
   }
   bu şekilde Http Request gönderildiği zaman aracımız uygun park alanına kaydedilecektir.
   İkinci Request tipimizde ise aracımızı park alanından çekmek için kullanılacaktır. Bunun için Http DELETE Request
   isteği atacağız. Burada ilgili park alanının numarası URL üzerinden parametre olarak iletilecektir. Örneğin
   1 numaralı park alanının boşaltılması için Http DELETE Request URL bilgisi:
   URL: http://localhost:40400/carpark/leave/1
   Üçüncü Request tipimizde ise otoparktaki mevcut alanların dolu ve boş olup olmadığını izleyebileceğimiz Http GET Request
   vardır. Burada sadece url kısmında alt url olarak "status" yazarak park alanlarını izleyebiliriz. Örnek Http GET Request için
   URL bilgisi:
   URL: http://localhost:40400/carpark/status
 
 -> Projede kullanılan teknolojiler:
  Projemizde Spring Framework e ilişkin muhtelif library seçenekleri kullanılmıştır. Spring-WEB, Spring-Validation...
  Bunlardan ayrı olarak katmanlar arası class converting(Entity-DTO, DTO-Entity) işlemleri için MapStruct Library 
  kullanılmıştır. Projede Exception Managing yapısı olarak kendi hazırladığım customize library kullanılmış olup
  bu library "Project Local Repository(Proje içine)" eklenmiştir.(Ekstra görüntülemek için link:     https://github.com/OguzhanTuna/ExceptionLib) belirli noktalarda design pattern kullanımına dikkat edilmiş olup JUnit 
  library kabiliyetleri ile örnek olması açısından "sadece bir adet" unit test class yazılmıştır. Race condition oluşmaması
  için belirli noktalarda thread-safe yaklaşım sergilenmiştir. Projede DB bağlantısı ele alınmamış. Veri yapıları üzerinden
  işlemler gerçekleştirilmiştir.
  
  -> Projeyi geliştiren:
  Oğuzhan Tuna ÖZDOĞAN

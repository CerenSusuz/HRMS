# HRMS
Human Resourse Management Software, 
İnsan Kaynakları Yönetim Sistemi anlamına gelir. Kuruluşların şirket içi İK faaliyetlerini yönetmek için kullandıkları bir yazılım ürün setini ifade eder. İK Yönetim Sistemi yazılımı, İK uzmanlarının çalışan verilerinin yönetiminden bordro, işe alım, yan haklar, eğitim, yetenek yönetimi, çalışan etkileşimi ve çalışan katılımına kadar modern iş gücünü yönetmesine yardımcı olur. İnsan kaynakları bilgi sistemi (HRIS) olarak da adlandırılan İK Yönetim Sistemi sistemleri, bir şirketin en değerli varlıkları hakkındaki bilgileri, bu bilgilere ihtiyacı olan kişilerin önüne getirir. Dünün HR yazılımı ve HRIS sistemleri, bugünün insan kaynakları yönetimi bulut çözümleri haline geldi.

<img src="https://github.com/CerenSusuz/HRMS/blob/main/hrms.jpg">

-------------------------------------------------

# Proje İsterleri

-------------------------------------------------

# Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.
# Req 2 : İş verenler sisteme kayıt olabilmelidir.

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin (bizim :)) onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.

# Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. 

Örneğin Software Developer, Software Architect.

Kabul Kriterleri:

Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.


# Req 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)

# Req 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)

# Req 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste)

# Req 7 : İş verenler sisteme iş ilanı ekleyebilmelidir.

İş ilanı formunda;
Seçilebilir listeden (dropdown) genel iş pozisyonu seçilebilmelidir.(Örneğin Java Developer)(Zorunlu)
İş tanımı girişi yapılabilmelidir. (Örneğin; firmamız için JAVA, C# vb. dillere hakim....)(Zorunlu)
Şehir bilgisi açılır listeden seçilebilmelidir. (Zorunlu)
Maaş skalası için min-max girişi yapılabilmelidir. (Opsiyonel)
Açık pozisyon adedi girişi yapılabilmelidir. (Zorunlu)
Son başvuru tarihi girişi yapılabilmelidir.

# Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

# Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

# Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

# Req 11 : İş verenler sistemdeki bir ilanı kapatabilmelidir. (Pasif ilan)

-------------------------------------------------

# Projeyi geliştirirken yararlandığım kaynaklar:

-------------------------------------------------

<a href="https://www.youtube.com/watch?v=HB0T0hAMk0k&list=PLqG356ExoxZUuVYKLuiQLnref7Y4ims87">(Java & React) Yazılım Geliştirici Yetiştirme Kampı - Engin Demiroğ</a>

<a href="https://www.btkakademi.gov.tr/portal/course/java-ile-programlamaya-giris-9617#!/about">JAVA İle Programlamaya Giriş</a>

<a href="https://www.btkakademi.gov.tr/portal/course/ileri-seviye-java-9353#!/about">İleri Seviye Java</a>

<a href="https://www.mobilhanem.com/spring-java-tabanli-konfigurasyon/">@Configuration</a>

<a href="https://gokhana.medium.com/inversion-of-control-ioc-nedir-ve-avantajlar%C4%B1-nelerdir-cf05e42c16e4">IoC</a>

<a href="https://www.baeldung.com/hibernate-identifiers">An Overview of Identifiers in Hibernate/JPA</a>

<a href="https://kodedu.com/2013/10/spring-framework-java-siniflari-ile-konfigurasyon/">@Bean</a>
  
<a href="https://www.youtube.com/watch?v=YE0dybIeMLQ">Mernis</a>

<a href="https://tugrulbayrak.medium.com/hibernate-1-orm-kavram%C4%B1na-giri%C5%9F-c2ba2f2a3bfe">ORM</a>

<a href="https://blog.burakkutbay.com/hibernate-dersleri-bire-cok-iliski-one-to-many-annotation.html/">One To Many Annotation</a>

<a href="https://oguzhaninan.gitlab.io/Java-Jackson-Annotation-Ek-Aciklamalar/">Java Jackson Annotations</a>

<a href="https://metinalniacik.medium.com/equals-ve-hashcode-metotlar%C4%B1n%C4%B1n-%C3%B6nemi-nedir-800c99af1519">Equals ve HashCode</a>

<a href="https://www.baeldung.com/jpa-one-to-one">One-to-One Relationship in JPA</a>

<a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/format/annotation/DateTimeFormat.ISO.html">DateTimeFormat.ISO</a>

<a href="https://medium.com/kodgemisi/spring-boot-ile-validation-yontemleri-cedc6701411e">Spring Boot ile Validation Yöntemleri</a>

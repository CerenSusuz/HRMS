# HRMS

İstihdam ve Kariyer Platformu

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

# Req 12: Adaylar sisteme CV girişi yapabilmelidir.

Adaylar okudukları okulları sisteme ekleyebilmelidir. (Okul adı, bölüm)
Bu okullarda hangi yıllarda okuduklarını sisteme girebilmelidir.
Eğer mezun değilse mezuniyet yılı boş geçilebilmelidir.
Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte ve "devam ediyor" olarak görüntülenmelidir.
Adaylar iş tecübelerini girebilmelidir. (İş yeri adı, pozisyon)
Bu tecrübelerini hangi yıllarda yaptıklarını sisteme girebilmelidir.
Eğer hala çalışıyorsa işten ayrılma yılı boş geçilebilmelidir.
Adayların tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve "devam ediyor" olarak görüntülenmelidir.
Adaylar bildikleri yabancı dilleri sisteme girebilmelidir. ( Dil, Seviye -> 1-5)
Adaylar sisteme fotoğraf girebilmelidir. Adaya ait fotoğraf https://cloudinary.com/pricing sisteminde tutulacaktır. (Dış servis entegrasyonu) Ücretsiz hesabı kullanınız.
Adaylar sisteme github adreslerini girebilmelidir.
Adaylar sisteme linkedin adreslerini girebilmelidir.
Adaylar bildikleri programlama dillerini veya teknolojilerini sisteme girebilmelidir. (Programlama/Teknoloji adı) Örneğin; React
Adaylar sisteme ön yazı ekleyebilmelidir. (Örneğin: Çalışmayı çok severim....)

-------------------------------------------------

# Projeyi geliştirirken yararlandığım kaynaklar:

-------------------------------------------------

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

<a href="https://tugrulbayrak.medium.com/maven-java-geli%C5%9Ftiricisinin-kurtar%C4%B1c%C4%B1s%C4%B1-914f345170a2">Maven</a>

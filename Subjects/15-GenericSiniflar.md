# Java Generics (Jenerikler)

Jenerikler, kelime anlamı itibariyle **parametrelendirilmiş** tür anlamına gelir. Jenerikler sayesinde, sınıf, arayüz veya metot yazarken tek bir türe bağlı kalmayıp üzerinde işlem yapacağınız türü parametre olarak alabilirsiniz. Bu sayede, farklı türler üzerinde çalışan tek bir sınıf yazmak mümkündür. Bu şekilde yazılan sınıflara **jenerik sınıf**, metotlara **jenerik metot** denir.

Jenerikler JDK 5 ile dile eklenmiştir. Buna rağmen, Java’nın en temel özelliklerinden biridir ve dili temelden etkilemiştir. Bu yüzden, jenerikleri iyi anlamak Java’yı öğrenmek açısından büyük önem taşır.

Jenerikler **tür güvenliğini** (**type-safety**) sağlamak amacıyla dile eklenmiştir. Java’nın tür kesinliği olan (**strongly typed**) bir dil olduğunu daha önce belirtmiştik. Fakat bu iki kavram birbirinden farklıdır. Tür güvenliği kavramını ve neden gerekli olduğunu anlamak için bir örnek yapalım.

**Nullable** adında basit bir sınıf yazalım. Bu sınıfı NullPointerException hatalarının önüne geçmek amacıyla kullanacağız. İlk olarak bu sınıfı String değerler üzerinde kullanalım:
```java
public class Nullable { 
    private final String value; 	
    public Nullable(String value) { 
        this.value = value; 	
    }
    public String getValue() { 
        return value; 	
    }
    public boolean isNull() { 
        return value == null; 	
    }
    @Override public String toString() { 
        return isNull() ? "null" : value; 	
    }
}
```

String nesneler üzerinde uğraşırken null hatalarının önüne geçmek için bu sınıfı kullanacağız. Sınıfı oluştururken parametre olarak bir **String** değer vereceğiz. Bu değerin **null** olup olmadığını **isNull()** metoduyla kontrol edeceğiz. Şimdi örnek bir kullanım gösterelim:
```java
Nullable x = new Nullable("null olmayan değer"); 
if (!x.isNull()) {
	System.out.println(x.getValue());
}
String nullString = null; 
Nullable y = new Nullable(nullString); 
if (y.isNull()) {
    System.out.println("y değişkeni null"); 
}
```

Yukarıdaki kodu çalıştırdığınız zaman çıktısı aşağıdaki gibi olur:
```java
null olmayan değer y değişkeni null
```

Gördüğünüz gibi yazdığımız sınıf güzel bir şekilde çalışmaktadır. Peki ya bu sınıfı String türünden başka türler için de kullanmak istersek? Mevcut durumda Nullable sınıfı yalnızca String değerleri kabul ediyor. Yani bu sınıfı Date türündeki değerler üzerinde kullanamayız. O halde bu sınıfın adını NullableString olarak değiştirelim ve NullableDate adında başka bir sınıf oluşturalım:

```java
import java.util.Date;

public class NullableDate { 
    private final Date value;     
    public NullableDate(Date value) { 
        this.value = value; 	
    }
    public Date getValue() { 
        return value; 	
    }
    public boolean isNull() { 
        return value == null; 	
    }
@Override public String toString() { 
    return isNull() ? "null" : value.toString(); 	
    }
}
```

Gördüğünüz gibi, aynı sınıfı sadece **String** türünü **Date** olarak değiştirerek tekrar yazdık. Bunun iyi bir yöntem olmadığını kabul etmelisiniz. Yalnızca kod tekrarı yapmakla kalmadık, aynı zamanda birbiriyle alakalı olmalarına rağmen sınıflara farklı isimler vermek zorunda kaldık. Artık **String** türü için **NullableString** sınıfını, **Date** türü için **NullableDate** sınıfını kullanabiliriz.

Yine de hâlâ ideal bir çözüm bulamadık. Çünkü Nullable sınıfını yalnızca 2 tür için kullanabiliyoruz. Peki ya bu sınıfı Integer, Double, Boolean gibi diğer türler için de kullanmak istersek? Hepsi için aynı kodu kopyalayıp farklı sınıflar oluşturmamız gerekir.

Yapmak istediğimiz şey, bütün türler için geçerli olacak bir **Nullable** sınıfı yazmak. Bunu şu şekilde başarabiliriz: **Nullable** sınıfının **Object** türü üzerinde çalışmasını sağlayalım. Bildiğiniz gibi, **Object** sınıfı bütün sınıfların atasıdır. Dolayısıyla bütün türleri **Object** türünden ifade edebiliriz. Şimdi sınıfı düzenleyip tekrar yazalım:
```java
public class Nullable { 
    private final Object value;     
    public Nullable(Object value) { 
        this.value = value;     
    }
    public Object getValue() { 
        return value;     
    }
    public boolean isNull() { 
        return value == null;     
    }
    @Override 
    public String toString() { 
        return isNull() ? "null" : value.toString();     
    }
}
```

Şimdi bu sınıfı farklı türler üzerinde kullanalım:
```java
Nullable nullableString = new Nullable("abc"); Nullable nullableDate = new Nullable(new Date()); Nullable nullableInt = new Nullable(2020); Nullable nullableDouble = new Nullable(3.14); Nullable nullableBoolean = new Nullable(true);
```

Yukarıda görebileceğiniz gibi, Nullable sınıfını farklı türler üzerinde kullanabiliriz. Fakat hâlâ bir sorunumuz var: getValue() metodunu çağırdığımız zaman çıkan değeri dönüştürmek zorundayız:
```java
Nullable nullableString = new Nullable("abc"); 
if (!nullableString.isNull()) {
	String value = (String) nullableString.getValue();
}
```

Bu önemli bir açıktır. Bu açık yüzünden farkında olmadan hataya sebebiyet verebiliriz. Örneğin, aşağıdaki kodu inceleyelim:
```java
Nullable nullableString = new Nullable("abc"); 
if (!nullableString.isNull()) {
    boolean value = (boolean) nullableString.getValue(); 
}
```

Bu örnekte Nullable sınıfına parametre olarak verdiğimiz değer String iken, bu değeri boolean türüne dönüştürmeye çalışıyoruz. Bu durumda yukarıda da gördüğümüz ClassCastException hatasıyla karşılaşırız.

**Bu örnekten şunu anlıyoruz:** Nullable sınıfını bütün türleri kapsayacak şekilde geliştirmemize rağmen tür güvenliğini sağlayamadık. JDK 5’ten önce bu gibi durumlar sıkça yaşanıyordu ve tür güvensiz kodlar yazılıyordu. Jenerikler ile bunun önüne geçmek mümkün olmuştur. Jenerikler, bir yandan farklı türler için tek bir kod yazmamızı sağlarken, diğer yandan tür güvenliğini sağlar.

### Tek Parametreli Generic Class
```java
public class Nullable <T>{
    private final T value;

    public Nullable(T value) {
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }
    public boolean isNull(){
        return this.getValue() == null;
    }
    public void run(){
        if(isNull()){
            System.out.println("Values has not anything");
        }else{
            System.out.println(this.getValue());
        }
    }
}
```

Burada herhangi bir wrapper sınıfı kullanmadan Nullable class tanımlanırken **<>** ifadesini kullanarak generic class oluşturabiliriz. Normal class yapısı ile arasında fark bulunmamaktadır. **\<T>**  ifadesi yerine istenilen isimlendirme kurallara uygun bir şekilde yapılabilir.

```java
public class Main {
    public static void main(String[] args) {
        Nullable<Integer> n = new Nullable<>(5);
        n.run();
    }
}
```
Nullable class için Wrapper sınıfı istediğimiz gibi belirtebilir ve Constructor metodu içerisine uygun değer yazılır. Ardından n nesnesinin run() fonksiyonu gibi tüm özelliklere ulaşılabilir.

### Birden Fazla Parametreli Generic Class
```java
public class Test <T1,T2,T3>{
    private T1 obj1;
    private T2 obj2;
    private T3 obj3;

    public Test(T1 obj1, T2 obj2, T3 obj3) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    public T1 getObj1() {
        return obj1;
    }

    public void setObj1(T1 obj1) {
        this.obj1 = obj1;
    }

    public T2 getObj2() {
        return obj2;
    }

    public void setObj2(T2 obj2) {
        this.obj2 = obj2;
    }

    public T3 getObj3() {
        return obj3;
    }

    public void setObj3(T3 obj3) {
        this.obj3 = obj3;
    }
    public void showInfo(){
        System.out.println("T1 : " +obj1+ " " +obj1.getClass().getSimpleName());
        System.out.println("T2 : " +obj2+ " " +obj2.getClass().getSimpleName());
        System.out.println("T3 : " +obj3+ " " +obj3.getClass().getSimpleName());
    }
}
```
Birden fazla parametre de alınabilir. Burada önemli olan nesne tanımlanırken Constructor'a gönderilecek olan değerlerin doğru sırada olması gerekir.
Örnerğin 
```java
public class Main {
    public static void main(String[] args) {
        Integer a = 10;
        String b = "patika";
        Double d = 3.14;
        String c = "dev";
        Test<Integer,String,Double> t = new Test<>(a,b,d);
        t.setObj2(c);
        t.showInfo();
    }
}
```
Örneğin;
```java
Test<Integer,String,Double> t = new Test<>(a,b,d);
```
ifadesinde a değişkeni Integer, b değişkeni String, d değişkeni de Double olmalıdır.
```java
Test<String,Integer,Double> t = new Test<>(b,a,d);
```
şeklinde de tanımlama yapabiliriz. Yeter ki tanım ile parametre tutarlı olsun.
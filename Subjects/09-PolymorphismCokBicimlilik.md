# Çok Biçimlilik (Polymorphism)
Çok biçimlilik aynı görevin veya işin farklı yollarla yapılabilmesini ifade eder. Nesne, aynı davranışı farklı formlar ve görünüşler ile yerine getirebilir.

Bunu yapabilmek için iki yöntem vardır.

1. Overriding in Java (Ezme)
2. Overloading in Java (Aşırı yükleme)

## Polymorphism Özellikleri

**Örnek**:
```java
class Hayvan{ private String isim; 
    public Hayvan(String isim) { 
        this.isim = isim;     
    }

    public String getIsim() { 
        return isim;     
    }

    public void setIsim(String isim) { 
        this.isim = isim;     
    }

    public String konus(){ 
        return "Hayvan Konuşuyor...";     
    }
} 

class Kedi extends Hayvan{ 
    public Kedi(String isim) { 
        super(isim);     
    }

    @Override 
    public String konus() { 
        return this.getIsim() + " Miyavlıyor...";     
        }
    }

class Kopek extends Hayvan { 
    public Kopek(String isim) { 
        super(isim);     
        }

    @Override 
    public String konus() { 
        return this.getIsim() + " Havlıyor...";     
    }
}

class At extends Hayvan { 
    public At(String isim) { 
        super(isim);     }

    @Override 
    public String konus() { 
        return this.getIsim() + " Kişniyor...";     
    }
}

public class Main { 
    public static void konustur(Hayvan hayvan){         
        System.out.println(hayvan.konus());
    }

    public static void main(String[] args){ // İlk Gösterim Hayvan hayvan = new Hayvan("Hiper");         System.out.println(hayvan.konus());
    Hayvan hayvan1 = new Kedi("Hiper");         System.out.println(hayvan1.konus());
    Hayvan hayvan2 = new Kopek("Hiper");         System.out.println(hayvan2.konus());
    Hayvan hayvan3 = new At("Hiper");         System.out.println(hayvan3.konus());

    //Fonksiyon kullanarak gösterim konustur(new Kedi("Nasip")); konustur(new Kopek("Karabaş")); konustur(new At("Bold-Pilot"));     }
}
```

## instanceof - polymorphism ilişkisi

- Obje vereceğimiz objenin hangi sınıftan olduğuna bakacağız
- Kedi sınıfı aynı zamanda Hayvan sınıfından miras alıyor. Bu yüzden superclass'la kıyaslanırsa inheritance olduğu için true döner.
- Bütün classlar objeden türüyor.(Object class)
- Polymorphism kullanmazsak bütün nesneleri instanceof ile kontrol etmemiz gerekir.
- Yeni bir sınıf üretirsek ve Hayvan sınıfından miras alırsa yine kontrol etmemiz gerekecek ama polymorphism bu iş yükünü azaltıyor.

**instanceof** operatörü, polymorphism kavramının uygulanmasıyla, nesnelerin türlerini dinamik olarak kontrol etmemizi sağlar. Böylece farklı türlerin aynı arayüzü paylaşmasına ve yöntemlerin uygun şekilde çağrılmasına olanak tanır.

Örnek II:

```java
class Hayvan{ private String isim; 
    public Hayvan(String isim) { 
        this.isim = isim;     
    }

    public String getIsim() { 
        return isim;     
    }

    public void setIsim(String isim) { 
        this.isim = isim;     
    }

    public String konus(){ 
        return "Hayvan Konuşuyor...";     
        }
}

class Kedi extends Hayvan{ 
    public Kedi(String isim) { 
        super(isim);     
    }

    @Override public String konus() { 
        return this.getIsim() + " Miyavlıyor...";     
        }
    }

class Kopek extends Hayvan { 
    public Kopek(String isim) { 
        super(isim);     
    }

    @Override public String konus() { 
        return this.getIsim() + " Havlıyor...";     
    }
}

class At extends Hayvan { 
    public At(String isim) { 
        super(isim);     
    }

    @Override public String konus() { 
    return this.getIsim() + " Kişniyor...";     
    }
}

public class Main { 
    public static void konustur(Object object){ 
        if (object instanceof Kopek){             
            Kopek kopekTest = (Kopek)object;
                System.out.println(kopekTest.konus());
        }
        else if(object instanceof Kedi){                
            Kedi kediTest = (Kedi)object;
            System.out.println(kediTest.konus());
        }
        else if (object instanceof At){             
            At atTest = (At)object;
            System.out.println(atTest.konus());
        }
        else if (object instanceof Hayvan){             
            Hayvan hayvanTest = (Hayvan)object;
            System.out.println(hayvanTest.konus());
        }
    }

    public static void main(String[] args){ 
        // Temel Gösterim Kedi kedi = new Kedi("Nasip"); 
        if (kedi instanceof Kedi){ System.out.println("Bu nesne Kedi sınıfından");         }

        if (kedi instanceof Hayvan){ System.out.println("Bu nesne Hayvan sınıfından");         }

        //Fonksiyon ile gösterim 
        Kedi kedii = new Kedi("Nasip"); 
        Kopek kopek = new Kopek("Zizu"); 
        At at = new At("BoldPilot"); 
        Hayvan hayvan = new Hayvan("Turunç"); 
        konustur(kedii);
        konustur(kopek);
        konustur(at);
        konustur(hayvan);
    }
}
```

Yukarıdaki Örnek II Polymorphism'in gerçek faydasını tam olarak ortaya çıkartıyor. Daha fazla hata yapma ihitmali, daha fazla kod ve daha fazla manuel kontrol. Sonuç olarak, polymorphism kullanmak kod temizliği ve güvenliği açısından verimli bir özellik.

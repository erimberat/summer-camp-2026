# 🧠 JVM Bellek Yönetimi: Stack ve Heap Analizi

**Tarih:** 22 Haziran 2026  
**Konu:** Java'da İlkel Tipler ve Nesnelerin Hafıza Yolculuğu

---

## 🎭 Büyük Analoji
* **STACK:** Garsonun elindeki küçük, hızlı ve aşırı düzenli sipariş defteridir. İş bitince sayfa kopartılır ve çöpe atılır.
* **HEAP:** Restoranın arkasındaki devasa, dinamik ama hafif dağınık merkez deposudur. Malzemeler orada durur, temizlikçi (Garbage Collector) gelip eskiyenleri atar.

---

## 📊 Karşılaştırma Tablosu

| Özellik | STACK (Defter) | HEAP (Depo) |
| :--- | :--- | :--- |
| **Hız** | Işık hızında (CPU Cache'e çok yakın) | Stack'e göre daha yavaş |
| **Boyut** | Küçük ve sabit kapasiteli | Devasa ve dinamik (büyüyebilir) |
| **Ne Tutar?** | İlkel tipler (`int`, `char`) & Nesne referansları (Adresler) | Gerçek `new` nesneleri (`HashMap`, `String`) |
| **Yönetim** | Otomatik (Metot bitince anında silinir - LIFO) | Garbage Collector (Çöp Toplayıcı) tarafından |
| **Kritik Hata** | `StackOverflowError` (Sonsuz döngülerde olur) | `OutOfMemoryError` (Hafıza dolduğunda olur) |

---

## 💻 Canlı Kod Üzerinde Gösterim (Two Sum Analizi)

Yazdığımız koddaki şu satırların hafızada ne yaptığına bakalım:

```java
int mevcut = nums[i]; 
HashMap<Integer, Integer> map = new HashMap<>();


STACK (Hızlı & Düzenli)               HEAP (Dinamik Sunucu Deposu)
┌────────────────────────────────┐         ┌──────────────────────────────┐
│  [ i = 0 ] (ilkel değer)       │         │                              │
│  [ mevcut = 5 ] (ilkel değer)  │         │                              │
│                                │         │   { HashMap Nesnesi }        │
│  [ map referansı ] ────────────┼────────►│   (İçinde verileri tutar)    │
│  (Bir nevi kartvizit/adres)    │         │                              │
└────────────────────────────────┘         └──────────────────────────────┘
public class MonteCarloPi {
    public static void main(String[] args) {
        // Atılacak toplam ok/nokta sayısı (Ne kadar büyükse tahmin o kadar yaklaşır)
        int toplamOkSayisi = 10000000; // 10 Milyon ok
        int daireIcineDusenler = 0;

        System.out.println("🔮 Simülasyon başladı, 10 milyon ok fırlatılıyor...");

        for (int i = 0; i < toplamOkSayisi; i++) {
            // 0.0 ile 1.0 arasında rastgele X ve Y koordinatları üret
            double x = Math.random();
            double y = Math.random();

            // Orijine olan uzaklığı hesapla (X^2 + Y^2 <= 1 ise dairenin içindedir)
            if ((x * x) + (y * y) <= 1) {
                daireIcineDusenler++;
            }
        }

        // Monte Carlo formülü: Pi ~= 4 * (Daire İçi Noktalar / Toplam Noktalar)
        double piTahmini = 4.0 * daireIcineDusenler / toplamOkSayisi;

        System.out.println("\n📊 --- SİMÜLASYON SONUÇLARI ---");
        System.out.println("🎯 Toplam Fırlatılan Ok: " + toplamOkSayisi);
        System.out.println("⚪ Daire İçine Düşen Ok: " + daireIcineDusenler);
        System.out.println("📐 Bizim Pi Tahminimiz : " + piTahmini);
        System.out.println("📌 Gerçek Pi Sayısı    : " + Math.PI);
        System.out.println("--------------------------------");
    }
}
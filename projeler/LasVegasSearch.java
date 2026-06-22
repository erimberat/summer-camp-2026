import java.util.Random;

public class LasVegasSearch {
    public static void main(String[] args) {
        int[] dizi = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int hedef = 70; // Bulmak istediğimiz kesin hedef

        Random rand = new Random();
        int denemeSayisi = 0;
        long baslangicZamani = System.nanoTime();

        System.out.println("🎰 Las Vegas Kumarhanesi açıldı. Hazine aranıyor...");

        while (true) {
            denemeSayisi++;

            // Diziden rastgele bir indeks seçiyoruz
            int rastgeleIndeks = rand.nextInt(dizi.length);

            // Kontrol ediyoruz: Hazine bu mu?
            if (dizi[rastgeleIndeks] == hedef) {
                // Hazine bulunduğunda döngüden çıkıyoruz
                break;
            }
            // Bulamadıysak döngü başa sarıyor, zaman uzuyor...
        }

        long bitisZamani = System.nanoTime();
        double gecenSure = (bitisZamani - baslangicZamani) / 1000000.0;

        System.out.println("\n📊 --- SİMÜLASYON SONUÇLARI ---");
        System.out.println("🎯 Bulunan Eleman : " + hedef + " (%100 Doğru)");
        System.out.println("🎲 Toplam Deneme  : " + denemeSayisi + " tur sürdü.");
        System.out.println("⏱️ Geçen Süre     : " + gecenSure + " ms");
        System.out.println("--------------------------------");
    }
}
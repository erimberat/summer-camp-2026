import java.util.Random;
public class MonteCarloOkey {
    private static final int Total_Stones = 106;//toplam taş sayısı
    private static final int Hand_size = 14; //elimize gelen taş sayısı
    private static final long Simulation_Count = 685_000_000L; //100 milyon deneme

    public static void main(String[] args) {
       //106 taşlık sabit destemizi Id mapping ile kuruyoruz
       int[] deck = new int[Total_Stones];
       for (int i = 0; i<Total_Stones;i++){
           deck[i]=i;
       }
       long successfulHands = 0;
       Random random = new Random();

       System.out.println("=================================================");
       System.out.println("Okey Monte Carlo Olasılık Simülasyonu Başlatıldı  ");
       System.out.println("Hedef: ilk Dağıtılan elde 'Saf 7 Çift' yakalamak");
       System.out.println("=================================================");


       long startTime = System.currentTimeMillis();

       //Heapi yormayıp performansı artırmak için "new" kullanmıyoruz
        // Her şey Stack hafızasında dönecek , Garbage collector çalışmayacak
        int[] currentHand = new int[Hand_size];
        int[][] matrix = new int[Hand_size][Hand_size];


        for(long sim = 0; sim<Simulation_Count;sim++){
            //optimizasyon:106 taşın tamamını karıştırmak yerine,
            //sadece ihtiyacımız olan ilk 14 taşı seçip karıştırıyoruz(kısmi Fischer-Yates)
            for(int i=0; i<Hand_size; i++){
                int randomIndex = i + random.nextInt(Total_Stones-i);
                int temp = deck[i];
                deck[i] = deck[randomIndex];
                deck[randomIndex] = temp;
                currentHand[i] = deck[i];
            }
            //matrisi sıfırlıyoruz
            resetMatrix(matrix);

            //Counting sort mantığı : Taşları renk ve sayısına göre hücrelere fırlatacak
            for(int i=0; i<Hand_size; i++){
                int id = currentHand[i];
                if(id>=104) continue; // Basitlik adına sahte okeyleri bu senaryoda pas geçiyoruz

                int color = id / 26; //0:kırmızı , 1: Mavi , 2: Siyah , 3: Sarı
                int number = (id % 26) / 2 + 1; // 1 ile 13 arasındaki gerçek taş sayısı

                matrix[color][number]++;
            }
            if(isSevenPairs(matrix)){
                successfulHands++;
            }
        }
        long endTime = System.currentTimeMillis();
        double probability = (double) successfulHands / Simulation_Count;

        System.out.println("\n--- Simülasyon Analiz Raporu ---");
        System.out.println("Toplam Dağıtılan El Sayısı : " + String.format("%,d", Simulation_Count));
        System.out.println("Yakalanan Mükemmel Çift    : " + successfulHands);
        System.out.println("Deneysel Olasılık Sonucu   : " + String.format("%.10f", probability));
        System.out.println("Hesaplanan Hesaplama Süresi: " + (endTime - startTime) + " ms");
        System.out.println("====================================================");
    }
    private static void resetMatrix(int[][] matrix){
        for(int i=0; i<4; i++){
            for(int j=0; j<14; j++){
                matrix[i][j] = 0;
            }
        }
    }
    private static boolean isSevenPairs(int[][] matrix){
        int pairCount = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                if(matrix[i][j] == 2){
                    pairCount++;
                }
            }
        }
        return pairCount == 7; //Eğer elde tam 7 adet çift varsa el mükemmeldir
    }
}

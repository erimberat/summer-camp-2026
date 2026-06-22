import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        // Sayıları ve indekslerini tutacağımız harita (Space Complexity: O(n))
        HashMap<Integer, Integer> map = new HashMap<>();

        // Diziyi tek bir turda dönüyoruz (Time Complexity: O(n))
        for (int i = 0; i < nums.length; i++) {
            int mevcut = nums[i];
            int arkadas = target - mevcut;

            // Eğer aradığımız arkadaş sayı haritada varsa, indeksleri dön
            if (map.containsKey(arkadas)) {
                return new int[] { map.get(arkadas), i };
            }

            // Yoksa mevcut sayıyı ve indeksini haritaya kaydet
            map.put(mevcut, i);
        }

        return new int[] {}; // Tanım gereği boş dizi
    }

    // İleride lokalde test etmek istersen diye örnek bir main metodu
    public static void main(String[] args) {
        twoSum cozum = new twoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] sonuc = cozum.twoSum(nums, target);
        System.out.println("Sonuç İndeksleri: [" + sonuc[0] + ", " + sonuc[1] + "]");
    }
}
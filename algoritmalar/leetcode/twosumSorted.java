public class twosumSorted {
    public static void main(String[] args) {
        int[] numbers = new int[4];
        numbers[0] = 2;
        numbers[1] = 7;
        numbers[2] = 11;
        numbers[3] = 15;


        int left = 0;
        int right = numbers.length-1;
        int target=9;

        while(left<right){
            int currentSum = numbers[left] + numbers[right];

            if(currentSum==target){
                //eşitse bulunmuştur
                System.out.println("aranan indeksler bulundu"+ "\n "+ left + "," + right);
                break;
            }
            else if(currentSum>target){
                right--; //toplam hedeften büyük çıktı diziyi sağdan bir adım sola yaklaştırıyoruz
            }
            else{
                left++; //toplam hedeften küçük çıktı diziyi soldan sağa bir adım yaklaştırıyoruz
            }
        }

    }
}

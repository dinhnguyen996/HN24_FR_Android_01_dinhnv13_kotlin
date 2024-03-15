package assignment1.exp1

import java.util.Scanner
/*Viết chương trình tìm tất cả các số chia hết cho 7 nhưng không phải
bội của 5 (từ 10 đến 200). Các số kết quả sẽ được in dưới dạng các chuỗi
trên một dòng, được phân tách bằng dấu phẩy.*/
fun main(){
    //tạo mảng lưu trữ kết quả thảo mãn điều kiện
    var arrayList=ArrayList<Int>()
   for (i in 10..200){
       if (i%7==0 && i%5!=0){
           arrayList.add(i)
       }
   }
    println("Tất cả các số chia hết cho 7 nhưng không phải là bội của 5 là:")
    print(arrayList.joinToString(","))
}
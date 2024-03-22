package assignment3.exp2

import android.os.Build
import androidx.annotation.RequiresApi
import assignment3.exp1.Teacher
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

import java.util.Scanner

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val scanner=Scanner(System.`in`)
    var danhSachGiaoDichDat= mutableListOf<GiaoDichDat>()
    var danhSachGiaoDichNha= mutableListOf<GiaoDichNha>()
    var luaChon:Int
    do {
        while (true){

            println("Các lựa chọn")
            println("1. Nhập danh sách các giao dịch")
            println("2. Xuất danh sách các giao dịch")
            println("3. Tính tổng số lượng cho từng loại.")
            println("4. Tính trung bình thành tiền của giao dịch đất.")
            println("5. Xuất ra các giao dịch của tháng trước trong năm nay.")
            println("0. Thoát chương trình.")
            print("Lựa chọn của bạn là : ")

            while (true){
                if (scanner.hasNextInt()){
                    luaChon=scanner.nextInt()
                    break
                }else{
                    println("Nhập sai nhập lại lựa chọn")
                    scanner.next()
                }
            }
            when(luaChon){
                1 -> {
                    nhapDanhSach(danhSachGiaoDichDat, danhSachGiaoDichNha)
                }
                2 -> {
                    xuatDanhSach(danhSachGiaoDichDat, danhSachGiaoDichNha)
                }
                3 -> {
                    tinhTongGiaoDich(danhSachGiaoDichDat, danhSachGiaoDichNha)
                }
                4 -> {
                    trungBinhGiaoDichDat(danhSachGiaoDichDat)
                }
                5 -> {
                    giaoDichThangTruoc(danhSachGiaoDichDat, danhSachGiaoDichNha)
                }

                0 -> {
                    println("Chương trình đã thoát.")
                }
                else -> {
                    println("Lựa chọn không hợp lệ.")
                }
            }
        }

    } while (luaChon != 0)
}

@RequiresApi(Build.VERSION_CODES.O)
fun giaoDichThangTruoc(danhSachGiaoDichDat: MutableList<GiaoDichDat>, danhSachGiaoDichNha: MutableList<GiaoDichNha>) {
    // Lấy ngày hiện tại
    val ngayHienTai = LocalDate.now()

    // Lặp qua danh sách các giao dịch đất
    println("Các giao dịch đất của tháng trước trong năm nay:")
    for (giaoDich in danhSachGiaoDichDat) {
        // Lấy tháng và năm của ngày giao dịch
        val ngayGiaoDich = LocalDate.parse(giaoDich.ngayGiaoDich, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val thangGiaoDich = ngayGiaoDich.monthValue
        val namGiaoDich = ngayGiaoDich.year

        // So sánh với tháng và năm hiện tại
        if (thangGiaoDich == ngayHienTai.monthValue - 1 && namGiaoDich == ngayHienTai.year) {
            // Xuất ra thông tin của giao dịch
            giaoDich.xuatGiaoDich()
        }
    }
}

fun trungBinhGiaoDichDat(danhSachGiaoDichDat: MutableList<GiaoDichDat>) {
    if (danhSachGiaoDichDat.isEmpty()){
        println("Không có giao dịch đất nào")
        return
    }
    var tongTien:Double=0.0
    for (giaoDich in danhSachGiaoDichDat){
        tongTien+=giaoDich.thanhTien()
    }
    var trungBinh=tongTien/danhSachGiaoDichDat.size
    println("Trung bình thành tiền của giao dịch đất là: $trungBinh")

}

fun tinhTongGiaoDich(danhSachGiaoDichDat: MutableList<GiaoDichDat>, danhSachGiaoDichNha: MutableList<GiaoDichNha>) {
    var tongGiaoDichDat=danhSachGiaoDichDat.size
    var tongGiaoDichNha=danhSachGiaoDichNha.size
    println("Tổng giao dịch đất là: $tongGiaoDichDat")
    println("Tổng giao dịch nhà là: $tongGiaoDichNha")
}

fun xuatDanhSach(danhSachGiaoDichDat: MutableList<GiaoDichDat>, danhSachGiaoDichNha: MutableList<GiaoDichNha>) {
    if (danhSachGiaoDichDat.isEmpty()){
        println("Danh sách giao dịch đất rỗng")
    }else{
        println("Danh sách giao dịch đất")
        danhSachGiaoDichDat.forEach { it.xuatGiaoDich() }
    }
    if (danhSachGiaoDichNha.isEmpty()){
        println("Danh sách giao dịch nhà rỗng")
    }else{
        println("Danh sách giao dịch nhà")
        danhSachGiaoDichNha.forEach { it.xuatGiaoDich() }
    }

}

fun nhapDanhSach(danhSachGiaoDichDat: MutableList<GiaoDichDat>, danhSachGiaoDichNha: MutableList<GiaoDichNha>) {
    val scanner = Scanner(System.`in`)
    var luaChon:Int=0
    while (true) {
        println("Chọn loại nhập:")
        println("1. Giao dịch đất")
        println("2. Giao dịch nhà")
        print("Chọn: ")

        if (scanner.hasNextInt()) { // Kiểm tra xem người dùng đã nhập một số nguyên hợp lệ chưa
            luaChon = scanner.nextInt()
            if (luaChon == 1 || luaChon == 2) {
                break // Thoát khỏi vòng lặp nếu lựa chọn hợp lệ
            } else {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        } else {
            println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            scanner.next() // Đọc và loại bỏ giá trị không phải số nguyên khỏi luồng đầu vào
        }
    }

    when (luaChon) {
        1 -> {
            val giaoDichdat = GiaoDichDat()
            giaoDichdat.themGiaoDich()
            danhSachGiaoDichDat.add(giaoDichdat)
        }
        2 -> {
            val giaoDichNha = GiaoDichNha()
            giaoDichNha.themGiaoDich()
            danhSachGiaoDichNha.add(giaoDichNha)
        }
    }


}

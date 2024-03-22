package assignment3.exp2

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Scanner

open class GiaoDich(
    var maGiaoDich:String,
    var ngayGiaoDich:String,
    var donGia:Double,
    var dienTich:Double
){
    constructor():this("","",0.0,0.0)
    open fun themGiaoDich(){
        val scanner=Scanner(System.`in`)
        println("Nhập mã giao dịch")
        maGiaoDich=scanner.nextLine()

        //nhập ngày giao dịch
        var kiemTraNgay:Boolean=false
        while (!kiemTraNgay){
            println("Ngày giao dịch")
            var ngay=scanner.nextLine()
            if (kiemTraNgayHopLe(ngay)){
                ngayGiaoDich=ngay
                kiemTraNgay=true
            }else{
                println("nhập lại ngày giao dịch hợp lệ")
            }
        }

        //nhập đơn giá
        while (true){
            println("Nhập đơn giá")
            if (scanner.hasNextDouble()){
                donGia=scanner.nextDouble()
                if (donGia>0){
                    break
                }else{
                    println("nhập đơn giá lớn hơn 0")
                }
            }else{
                println("nhập sai dữ liệu ,nhập lại giá")
                scanner.next()
            }
        }

      //nhập diện tích
        while (true) {
            println("Nhập diện tích")
            if (scanner.hasNextDouble()){
                dienTich=scanner.nextDouble()
                if (dienTich>0){
                    break
                }else{
                    println("Nhập sai diện tích,nhập lại diện tích lớn hơn 0")
                }
            }else{
                println("Nhập sai kiểu dữ liệu cho diện tích")
                scanner.next()
            }
        }

    }
    open fun xuatGiaoDich(){
        println("Mã gia dịch: $maGiaoDich")
        println("Ngày giao dịch: $ngayGiaoDich")
        println("Đơn giá: $donGia")
        println("Diện tích: $dienTich")
    }
    open fun thanhTien(): Double {

        return 0.0
    }
    //kiểm tra ngày tháng hợp lệ
    @SuppressLint("SimpleDateFormat")
    fun kiemTraNgayHopLe(dateOfBirth: String): Boolean {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        dateFormat.isLenient = false

        try {
            dateFormat.parse(dateOfBirth)
            return true
        } catch (e: ParseException) {
            return false
        }
    }
    // Hàm lấy ra tháng từ ngày giao dịch
    open fun layThangTuNgay(): Int {
        val ngayThangNam = ngayGiaoDich.split("/")
        return if (ngayThangNam.size == 3) {
            ngayThangNam[1].toInt() // Trả về tháng
        } else {
            0 // Trả về 0 nếu ngày giao dịch không hợp lệ
        }
    }

}
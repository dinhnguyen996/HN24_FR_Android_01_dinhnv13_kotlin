package assignment3.exp2

import java.util.Scanner

class GiaoDichNha:GiaoDich {
    var loaiNha:String=""
    var diaChi:String=""

    constructor(magiaoDich:String,ngayGiaoDich:String,donGia:Double,dienTich:Double,loaiNha:String,diaChi:String):super(magiaoDich,ngayGiaoDich,donGia,dienTich){
        this.loaiNha=loaiNha
        this.diaChi=diaChi
    }
    constructor():super()

    override fun themGiaoDich() {
        super.themGiaoDich()
        val scanner= Scanner(System.`in`)
        while (true){
            println("Nhập loại nhà")
            if (scanner.hasNextLine()){
                loaiNha=scanner.nextLine().toLowerCase()
                if (loaiNha=="thương gia"||loaiNha=="cao cấp"||loaiNha=="bình dân"){
                    break
                }else{
                    println("Nhập sai nhập lại loại đất")
                }
            }
        }
        println("Địa chỉ")
        diaChi=scanner.nextLine()
    }

    override fun thanhTien(): Double {
        super.thanhTien()
        var tongTien:Double=0.0
        when(loaiNha){
            "thương gia"->tongTien=dienTich * donGia*1.1
            "cao cấp"->tongTien=dienTich * donGia
            "bình dân"->tongTien=dienTich * donGia*0.9
        }
        return tongTien

    }

    override fun xuatGiaoDich() {
        super.xuatGiaoDich()
        println("Loại nhà: $loaiNha")
        println("Địa chỉ: $diaChi")
    }

}
package assignment3.exp2

import java.util.Scanner

class GiaoDichDat: GiaoDich {
    var loaiDat:String=""

    constructor(maGiaoDich:String,ngayGiaoDich:String,donGia:Double,dienTich:Double,loaiDat:String):super(maGiaoDich, ngayGiaoDich, donGia, dienTich){
        this.loaiDat=loaiDat
    }
    constructor():super()

    override fun themGiaoDich() {
        super.themGiaoDich()
        val scanner=Scanner(System.`in`)
        println("Nhập loại đất A,B,C")
        while (true){
            if (scanner.hasNextLine()){
                loaiDat=scanner.nextLine().toUpperCase()
                if (loaiDat=="A"||loaiDat=="B"||loaiDat=="C"){
                    break
                }else{
                    println("Nhập sai nhập lại loại đất")
                }
            }
        }
    }

    override fun xuatGiaoDich() {
        super.xuatGiaoDich()
        println("Loại đất: $loaiDat")
    }

    override fun thanhTien(): Double {
        super.thanhTien()
        var tongTien:Double=0.0
        when(loaiDat){
            "A"->tongTien=dienTich * donGia*1.5*1.1
            "B"->tongTien=dienTich * donGia*1.1
            "C"->tongTien=dienTich * donGia
        }
        return tongTien

    }

}
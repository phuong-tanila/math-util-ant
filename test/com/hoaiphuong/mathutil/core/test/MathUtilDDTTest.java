package com.hoaiphuong.mathutil.core.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.hoaiphuong.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Admin
 */

@RunWith(value = Parameterized.class) //Class này chuẩn bị chơi trò tách data ra khỏi câu lệnh xanh đỏ
                                      //cho dễ kiểm soát test case
                                      //thư viện JUnit sẽ tự generate thêm code lúc biên dịch
                                      //để giúp hiện thực hóa ý tưởng DDT
                                      //ví dụ: nó sẽ tự biết lấy data ở mảng 2 chiều nào đó nhồi vào hàm assertEquals()
                                      //ép ta phải viết code theo cách nào đó định trước mới chạy được
                                      //thư viện đó được gọi tên mới: FRAMEWORK
public class MathUtilDDTTest {
    
    //tạo ra một hàm, tên tùy ý, trả về mảng 2 chiều
    //chứa danh sách data ta dự định nhồi vào hàm getF() và assertE()
    //phần duyệt mảng để nhồi vào hàm test, FRAMEWORK tự lo, coder ko cần lo
    @Parameterized.Parameters //bộ data nè
    public static Object[][] initData(){
        //int a[] = {5, 10, 15, 20, 25};
        
        //Object arr1[][] = {{1, 0}, {1, 1}, {2, 2}, {6, 3}, {24, 4}, {120, 5}, {720, 6}};
        
        return new Integer[][] {
                            {1, 0},
                            {1, 1},
                            {2, 2},
                            {6, 3},
                            {24, 4},
                            {120, 5},
                            {720, 6}
                         };
    }
    
    @Parameterized.Parameter(value = 0) //index trong mảng
    public long expected; //biến này sẽ lưu giá trị kì vọng
                          //khi xài hàm getFactorial() --> expected
    
    @Parameterized.Parameter(value = 1)
    public int n; //biến này sẽ lưu giá trị đưa vào hàm gerF() để check
                  //ta sẽ map/ánh xạ 2 biến này ứng với 2 cột của từng dòng
                  //của mảng ở trên
                  //ta phải quy ước biến expected map vào cột nào mình muốn
                  //thứ tự biến ko quan trọng, thứ tự cột ko quan trọng
                  //vì ta sẽ cấu hình việc map tương ứng này
    
    //TEST-TIME
    @Test
    public void testParameterGivenRightArgumentReturnWell(){
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
}
// DDT: Data Driven Testing, là 1 kỹ thuật dùng trong Unit Test
// Dùng để viết code test các hàm/class một cách dễ đọc hơn
// Bằng cách tách data kiểm thử và câu lệnh test thành hai nơi khác nhau
// ví dụ cách cũ, non-DDT:
//assertEquals(1, getF(0));
//assertEquals(1, getF(1));
//assertEquals(2, getF(2));
//assertEquals(6, getF(3));
//assertEquals(24, getF(4));
//cách này dễ  viết nhưng khó kiểm tra đủ hết tập test case cần test
//trộn lẫn data đưa vào, và câu lệnh gọi hàm kiểm thử

//KĨ THUẬT TÁCH DATA ĐỂ RIÊNG RA 1 CHỖ SAU ĐÓ 
//FILL/FEED NẠP CHÚNG VÀO LỆNH GỌI LÀ assertEquals(?, getF(?))
//giúp code dễ hiểu
//kĩ thuật này gọi là DDT: DATA    DRIVEN      TESTING
//                      tách data  hướng về   code kiểm thử
//THAM SỐ HÓA DATA - BIẾN DATA RA 1 NƠI, ĐẶT CHO CHÚNG TÊN BIẾN
//LÁT HỒI NHỒI VÀO LỆNH SO SÁNH
//THAM SỐ HÓA - BIẾN DATA THÀNH THAM SỐ - PARAMETERIZED

//JUnit sẽ tự tách mảng ra thành các test case
//chạy so sánh XANH ĐỎ CỦA TỪNG TEST CASE VÀ ĐƯA RA KẾT LUẬN CHUNG
//XANH KHI TẤT CẢ CÙNG XANH
//CHỈ KHI CÓ 1 THẰNG ĐỎ, TẤT CẢ ĐỎ - HÀM KHÔNG ỔN ĐỊNH

//KHI ĐỎ, CÓ 2 TRƯỜNG HỢP
//ĐỎ: DO CÓ SỰ != NHAU GIỮA EXPECTED VÀ ACTUAL
//ĐỎ VÌ EXPECTED != ACTUAL, VẬY KO BẰNG VÌ LÝ DO GÌ
// 1. EXPECTED LÁ GIÁ TRỊ TÍNH TOÁN TRƯỚC, HÀM PHẢI TRẢ VỀ BẰNG ĐƯỢC GIÁ TRỊ NÀY
//    VÀ EXPECTED MÌNH TÍNH BẰNG TAY KHI CHƯA XÀI APP, PHẢI TÍNH ĐÚNG
//    MÀU ĐỎ LÀ DO ACTUAL ÉO GIỐNG, TỨC LÀ CODE SAI, BUG!!!

// 2. EXPECTED MÌNH TÍNH BẰNG TAY VÀ BỊ SAI
//KÌ VỌNG ĐÃ SAI TRƯỚC KHI ĐỎ
//HÀM TRẢ VỀ CHO DÙ ĐÚNG NHƯNG CŨNG BỊ MÀU ĐỎ
//KỲ VỌNG SAI THÌ KO THỂ KẾT LUẬN ĐƯỢC HÀM CÓ BUG HAY KO



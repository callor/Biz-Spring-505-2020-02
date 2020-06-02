package com.biz.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.shop.domain.CartVO;

public interface CartDao {

	// 장바구니 보기용 SELECT
	@Select(" SELECT C.seq, P.p_code,P.p_name, C.username, C.p_oprice, C.p_qty "
			+ " FROM tbl_cart C "
			+ " LEFT JOIN tbl_product P ON C.p_code = P.p_code "
			+ " WHERE username = #{username} AND p_status = 'CART' ")
	public List<CartVO> selectCart(@Param("username") String username);

	// 관리자가 현재 카트에 몇건이나 담겨있는지 조회할때
	@Select("SELECT count(*) FROM tbl_cart "
			+ " WHERE p_status = 'CART' ")
	public int countCart();
	
	// 주문 완료 후 배송중 SELECT
	@Select("SELECT * FROM tbl_cart WHERE username = #{username} AND p_status = 'DELIV' ")
	public List<CartVO> selectDelivery(@Param("username") String username);

	// 관리자가 현재 배송중인 상품이 몇건이나 되는지 조회할때
	@Select("SELECT count(*) FROM tbl_cart WHERE p_status = 'DELIV' ")
	public int countDelivery();
	
	@Update("UPDATE tbl_cart "
			+ " SET p_qty = #{p_qty} "
			+ " WHERE seq = #{seq}")
	public int qty_update(
			@Param("seq") long seq, 
			@Param("p_qty") int p_qty);

	public int cart_list_delete(List<String> strSeqList);
	
	// Dao에서 mapper에 2개 이상의 변수를 전달할 경우는
	// 반드시 @Param()을 설정해 주어야 한다.
	public int cart_to_delivery(
			@Param("buyList") List<String> buyList,
			@Param("CartVO") CartVO cartVO);
		
}








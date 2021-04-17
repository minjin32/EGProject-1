package shop.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import shop.model.dao.ShopDAO;
import shop.model.vo.Menu;
import shop.model.vo.Product;
import shop.model.vo.Shop;
import shop.model.vo.ShopPageData;

public class ShopService {
	private JDBCTemplate factory;
	
	public ShopService () {
		factory = JDBCTemplate.getConnection();
	}
	
	   // 2.셀렉트byshopno -> 매장번호(shopno)로 하나 긁어오는거
	   // 3.insert가 필요한데 만들어두기만하면 나중에 회원가입하면서 불러올거라 회원ID로 insert만 해두면
	   // 나중에 정보는 사업자가 "매장관리 화면"에서 정보수정으로 "update일어나게" 할거라서
	   // 회원가입할때 입력받는게 "회원id 사업자등록번호 대표자명" 3개 를 파라메터로 insert할거야
	   // public int createshop(Shop shop) { -> 인서트 테이블만 만드는거 ->shop 3~15번 업데이트
	   // 4.수정,삭제용 update /
	   // 5.  shop테이블의 매장번호랑 menu테이블의 매장번호를 join   -> select List
	   // 6.  shop테이블의 매장번호랑 product테이블의 매장번호를 join   -> select List
	
	// 매장번호로 긁어오기
	public Shop selectOneByShopNo(int shopNo) {
		Shop shop = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			shop = new ShopDAO().seletOneByShopNo(conn, shopNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return shop;
	}
	
	
	// shop 업데이트(수정,삭제)
	public int modifyShop(Shop shop) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShopDAO().updateMember(conn, shop);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	
	// shop 추가하기
	public int registerShop(Shop shop) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShopDAO().insertShop(conn, shop);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// shop 매장용 메뉴 가져오기
	public ArrayList<Menu> selectMenuList() {
		ArrayList<Menu> list = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			list = new ShopDAO().selectMenuList(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return list;
	}
	
	// shop 스토어용 상품 가져오기
	public ArrayList<Product> selectProductList() {
		ArrayList<Product> list = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			list = new ShopDAO().selectProductList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}
	
	public ShopPageData selectListByAddress(String add1, String add2, String add3, int targetPage) {
		Connection conn = null;
		ShopPageData pd = null;
		
		try {
			conn = factory.createConnection();
			pd.setShopList(new ShopDAO().selectListByAddress(conn, add1, add2, add3, targetPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
	}
	
}

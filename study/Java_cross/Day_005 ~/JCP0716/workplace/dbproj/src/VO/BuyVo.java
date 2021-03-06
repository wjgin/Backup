package VO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// BUY# 테이블과 매핑
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BuyVo {
	private int buy_no;
	private String custom_id;
	private String product_code;
	private int buy_quantity;
	private Date buy_date;
}

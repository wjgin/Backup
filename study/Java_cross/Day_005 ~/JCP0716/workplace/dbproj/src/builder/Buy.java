package builder;

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
@Builder	// Builder pattern 객체 생성 가능

public class Buy {
	private int buy_no;
	private String custom_id;
	private String product_code;
	
}

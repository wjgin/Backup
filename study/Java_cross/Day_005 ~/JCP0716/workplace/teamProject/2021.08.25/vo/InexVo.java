package vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
	public class InexVo {
		private int ie_idx;
		private String ie_division;
		private String ie_category;
		private Date ie_time;
		private int ie_price;
		private String userinfo_id;
		private String account_num;
		private String ie_memo;
	
}
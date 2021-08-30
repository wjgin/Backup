package vo.seungJoon.teamProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AccountVo {
	private String accNum;
	private String bank;
	private String owner;
	private String id;
	
}

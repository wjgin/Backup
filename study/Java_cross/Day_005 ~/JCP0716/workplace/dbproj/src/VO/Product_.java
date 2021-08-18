package VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// lombok test -> 라이브러리추가 -> 롬복 설치(이클립스)
// Annotation 역할에 따라 위치가 정해짐
//@Getter
//@Setter
@Data	// getter + setter
@ToString
@NoArgsConstructor	//기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 커스텀 생성자

public class Product_ {
	private String product_code;
	private String product_name;
	private String product_category;
	private int product_price;
}

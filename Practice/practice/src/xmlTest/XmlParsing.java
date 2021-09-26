package xmlTest;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlParsing {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// xml 파싱 빌드업
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// xml 파일을 document로 파싱하기
		Document document = builder.parse("xml/sample.xml");
		
		// root 요소 가져오기
		Element root = document.getDocumentElement();
		// root 요소 확인 : 첫 태그 sample
		System.out.println(root.getNodeName()); 
		// root 요소의 첫번째 노드는 #Text
		Node firstNode = root.getFirstChild();
		// 다음 노드는 customer
		Node customer = firstNode.getNextSibling();
		// customer 요소 안의 노드 리스트
		NodeList childList = customer.getChildNodes();
		
		// customer 태그 하위 노드 리스트들의 내용을 출력
		for(int i = 0; i < childList.getLength(); i++) {
			Node item = childList.item(i);
			if(item.getNodeType() == Node.ELEMENT_NODE) { // 노드의 타입이 Element일 경우(공백이 아닌 경우)
				System.out.println(item.getNodeName());
				System.out.println(item.getNodeValue());
				System.out.println(item.getTextContent());
			}
		}
	}

}

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
		// document 안의 노드의 리스트 가져오기
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		// 첫 요소는 root 요소
		Element root = document.getDocumentElement();
		System.out.println(root);
		//NodeList childList = root.getChildNodes();
		NodeList name = root.getElementsByTagName("name");
		System.out.println(name.item(0));
		
//		for(int i = 0; i < nodeList.getLength(); i++) {
//			System.out.println(childList.item(i).getNodeName());
//			System.out.println(childList.item(i).getTextContent());
//		}
		
	}

}

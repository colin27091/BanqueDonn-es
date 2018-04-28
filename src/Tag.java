import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Tag extends Hashtable<String, String> {

	Tag(File XMLfile) {


	}
	
	
	static void description(Node n, String tab) {
		Element element = (Element)n;
		
		System.out.println(n.getNodeName());
	}

	static ArrayList<Tag> tagFromLine(String str) {

		ArrayList<Tag> tags = new ArrayList<Tag>();

		return tags;
	}

}

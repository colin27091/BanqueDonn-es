import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MainTag {

	public static void main(String[] args) {

		File file = new File("oil.png");
		ImageInputStream iis;
			iis = ImageIO.createImageInputStream(file);
			
			
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

			if (readers.hasNext()) {

				// pick the first available ImageReader
				ImageReader reader = readers.next();

				// attach source to the reader
				reader.setInput(iis, true);

				// read metadata of first image
				IIOMetadata metadata;
				try {
					metadata = reader.getImageMetadata(0);
					
				}

			}		
					String[] names = metadata.getMetadataFormatNames();
				int length = names.length;
				for (int i = 0; i < length; i++) {
					System.out.println("Format name: " + names[i]);
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}
			

				
		}
}

/*
 * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 * 
 * try { DocumentBuilder builder = factory.newDocumentBuilder(); Document xml;
 * 
 * try {
 * 
 * xml = builder.parse();
 * 
 * Element root = xml.getDocumentElement();
 * 
 * description(root, "");
 * 
 * } catch (SAXParseException e) { }
 * 
 * } catch (ParserConfigurationException e) {
 * 
 * e.printStackTrace();
 * 
 * } catch (SAXException e) {
 * 
 * e.printStackTrace();
 * 
 * } catch (IOException e) {
 * 
 * e.printStackTrace();
 * 
 * }
 */

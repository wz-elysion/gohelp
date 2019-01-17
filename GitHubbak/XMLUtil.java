package wz_ling1991.utils;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLUtil {
	
	private XMLUtil(){}
	

	/**
	 * xml文件转对象
	 * 
	 * @param clazz
	 * @param path
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlFileToObject(Class<T> clazz, String path) throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(new File(path));
		} catch (JAXBException e) {
			throw e;
		}
	}

	/**
	 * xml字符串转对象
	 * 
	 * @param clazz
	 * @param xmlString
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlStringToObject(Class<T> clazz, String xmlString) throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(new StringReader(xmlString));
		} catch (JAXBException e) {
			throw e;
		}
	}
	
	/**
	 * 对象转xml字符串
	 * 默认删除报文头
	 * @param t
	 * @return
	 */
	public static <T> String objectToXMLString(T t) {
		return objectToXMLString(t,true);
	}
	
	/**
	 * 对象转xml字符串
	 * 
	 * @param t
	 * @param isExclusiveHead 是否删除报文头
	 * @return
	 */
	public static <T> String objectToXMLString(T t,boolean isExclusiveHead) {
		StringWriter sw = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 去掉生成xml的默认报文头
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, isExclusiveHead);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(t, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
	
}

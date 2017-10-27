package br.com.is.utils;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class Serializacao {

    public static void FileGerator(Marshaller marshaller, List<?> list, String name, String arquivo)
            throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, new File(arquivo));
    }

    public static <T> List<T> FileLoger(Unmarshaller unmarshaller,
            Class<T> clazz, String xmlLocation) throws JAXBException {
        StreamSource xml = new StreamSource(xmlLocation);
        Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml,
                Wrapper.class).getValue();
        return wrapper.getItems();
    }
}

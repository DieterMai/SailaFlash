
package dev.dietermai.sailaflash.persistence.xml.node;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dev.dietermai.sailaflash.persistence.xml.node package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Sailaflash_QNAME = new QName("http://dietermai.sailaflash.dev/1.0.0", "sailaflash");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dev.dietermai.sailaflash.persistence.xml.node
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sailaflash }
     * 
     */
    public Sailaflash createSailaflash() {
        return new Sailaflash();
    }

    /**
     * Create an instance of {@link Cards }
     * 
     */
    public Cards createCards() {
        return new Cards();
    }

    /**
     * Create an instance of {@link AbstractCard }
     * 
     */
    public AbstractCard createAbstractCard() {
        return new AbstractCard();
    }

    /**
     * Create an instance of {@link SimpleCard }
     * 
     */
    public SimpleCard createSimpleCard() {
        return new SimpleCard();
    }

    /**
     * Create an instance of {@link MultiCard }
     * 
     */
    public MultiCard createMultiCard() {
        return new MultiCard();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new Answer();
    }

    /**
     * Create an instance of {@link Text }
     * 
     */
    public Text createText() {
        return new Text();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sailaflash }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Sailaflash }{@code >}
     */
    @XmlElementDecl(namespace = "http://dietermai.sailaflash.dev/1.0.0", name = "sailaflash")
    public JAXBElement<Sailaflash> createSailaflash(Sailaflash value) {
        return new JAXBElement<Sailaflash>(_Sailaflash_QNAME, Sailaflash.class, null, value);
    }

}

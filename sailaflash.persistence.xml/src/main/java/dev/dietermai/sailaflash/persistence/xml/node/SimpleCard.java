
package dev.dietermai.sailaflash.persistence.xml.node;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimpleCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleCard"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dietermai.sailaflash.dev/1.0.0}AbstractCard"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="question" type="{http://dietermai.sailaflash.dev/1.0.0}Question"/&gt;
 *         &lt;element name="answer" type="{http://dietermai.sailaflash.dev/1.0.0}Answer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleCard", propOrder = {
    "question",
    "answer"
})
public class SimpleCard
    extends AbstractCard
{

    @XmlElement(required = true)
    protected Question question;
    @XmlElement(required = true)
    protected Answer answer;

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link Question }
     *     
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link Question }
     *     
     */
    public void setQuestion(Question value) {
        this.question = value;
    }

    /**
     * Gets the value of the answer property.
     * 
     * @return
     *     possible object is
     *     {@link Answer }
     *     
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     * Sets the value of the answer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Answer }
     *     
     */
    public void setAnswer(Answer value) {
        this.answer = value;
    }

}

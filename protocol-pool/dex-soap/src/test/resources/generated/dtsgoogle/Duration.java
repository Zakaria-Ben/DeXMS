import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This class was generated by the CHOReVOLUTION BindingComponent Generator using com.sun.codemodel 2.6
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Duration")
public class Duration {

    @XmlElement(name = "text", required = true)
    private String text;
    @XmlElement(name = "value", required = true)
    private Double value;

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    public Double getvalue() {
        return value;
    }

    public void setvalue(Double value) {
        this.value = value;
    }

}
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This class was generated by the CHOReVOLUTION BindingComponent Generator using com.sun.codemodel 2.6
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Bounds")
public class Bounds {

    @XmlElement(name = "northeast", required = true)
    private Northeast northeast;
    @XmlElement(name = "southwest", required = true)
    private Southwest southwest;

    public Northeast getnortheast() {
        return northeast;
    }

    public void setnortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Southwest getsouthwest() {
        return southwest;
    }

    public void setsouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

}
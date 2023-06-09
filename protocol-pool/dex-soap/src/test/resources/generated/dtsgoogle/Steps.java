import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This class was generated by the CHOReVOLUTION BindingComponent Generator using com.sun.codemodel 2.6
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Steps")
public class Steps {

    @XmlElement(name = "distance", required = true)
    private Distance distance;
    @XmlElement(name = "duration", required = true)
    private Duration duration;
    @XmlElement(name = "end_location", required = true)
    private EndLocation end_location;
    @XmlElement(name = "maneuver", required = false)
    private String maneuver;
    @XmlElement(name = "html_instructions", required = true)
    private String html_instructions;
    @XmlElement(name = "polyline", required = true)
    private Polyline polyline;
    @XmlElement(name = "start_location", required = true)
    private StartLocation start_location;
    @XmlElement(name = "travel_mode", required = true)
    private String travel_mode;

    public Distance getdistance() {
        return distance;
    }

    public void setdistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getduration() {
        return duration;
    }

    public void setduration(Duration duration) {
        this.duration = duration;
    }

    public EndLocation getend_location() {
        return end_location;
    }

    public void setend_location(EndLocation end_location) {
        this.end_location = end_location;
    }

    public String getmaneuver() {
        return maneuver;
    }

    public void setmaneuver(String maneuver) {
        this.maneuver = maneuver;
    }

    public String gethtml_instructions() {
        return html_instructions;
    }

    public void sethtml_instructions(String html_instructions) {
        this.html_instructions = html_instructions;
    }

    public Polyline getpolyline() {
        return polyline;
    }

    public void setpolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public StartLocation getstart_location() {
        return start_location;
    }

    public void setstart_location(StartLocation start_location) {
        this.start_location = start_location;
    }

    public String gettravel_mode() {
        return travel_mode;
    }

    public void settravel_mode(String travel_mode) {
        this.travel_mode = travel_mode;
    }

}

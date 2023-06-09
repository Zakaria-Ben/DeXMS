import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This class was generated by the CHOReVOLUTION BindingComponent Generator using com.sun.codemodel 2.6
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Legs")
public class Legs {

    @XmlElement(name = "distance", required = true)
    private Distance distance;
    @XmlElement(name = "duration", required = true)
    private Duration duration;
    @XmlElement(name = "end_address", required = true)
    private String end_address;
    @XmlElement(name = "end_location", required = true)
    private EndLocation end_location;
    @XmlElement(name = "start_address", required = true)
    private String start_address;
    @XmlElement(name = "start_location", required = true)
    private StartLocation start_location;
    @XmlElement(name = "steps", required = true)
    private Steps steps;
    @XmlElement(name = "via_waypoint", required = true)
    private ViaWaypoint via_waypoint;

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

    public String getend_address() {
        return end_address;
    }

    public void setend_address(String end_address) {
        this.end_address = end_address;
    }

    public EndLocation getend_location() {
        return end_location;
    }

    public void setend_location(EndLocation end_location) {
        this.end_location = end_location;
    }

    public String getstart_address() {
        return start_address;
    }

    public void setstart_address(String start_address) {
        this.start_address = start_address;
    }

    public StartLocation getstart_location() {
        return start_location;
    }

    public void setstart_location(StartLocation start_location) {
        this.start_location = start_location;
    }

    public Steps getsteps() {
        return steps;
    }

    public void setsteps(Steps steps) {
        this.steps = steps;
    }

    public ViaWaypoint getvia_waypoint() {
        return via_waypoint;
    }

    public void setvia_waypoint(ViaWaypoint via_waypoint) {
        this.via_waypoint = via_waypoint;
    }

}

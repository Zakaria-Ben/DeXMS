import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.zefxis.dexms.dex.protocols.mqtt.MQTTResponseBuilder;
import org.zefxis.dexms.dex.protocols.primitives.MediatorGmSubcomponent;
import org.zefxis.dexms.gmdl.utils.Data;


/**
 * This class was generated by the CHOReVOLUTION BindingComponent Generator using com.sun.codemodel 2.6
 * 
 */
@WebService(serviceName = "Mediator", targetNamespace = "")
public class Mediator {

    private final MediatorGmSubcomponent apiRef;

    public Mediator(MediatorGmSubcomponent apiRef) {
        this.apiRef = apiRef;
    }

    @WebMethod
    public TrafficLight getTrafficLight(Integer id) {
        List<Data<?>> datas = new ArrayList<Data<?>>();
        datas.add(new Data<Integer>("id", "Integer", true, id, "PATH"));
        String serializedlight = this.apiRef.mgetTwowaySync("/traffic-lights/{id}", datas);
        return MQTTResponseBuilder.unmarshalObject("application/json", serializedlight, TrafficLight.class);
    }

    @WebMethod
    public void postTrafficLight(TrafficLight light) {
        List<Data<?>> datas = new ArrayList<Data<?>>();
        datas.add(new Data<TrafficLight>("light", "TrafficLight", false, light, "BODY"));
        this.apiRef.mgetOneway("/traffic-lights", datas);
    }

}

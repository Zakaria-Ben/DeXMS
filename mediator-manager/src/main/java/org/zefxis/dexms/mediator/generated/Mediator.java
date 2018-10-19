
package org.zefxis.dexms.mediator.generated;

import java.io.File;

import org.zefxis.dexms.dex.protocols.coap.MediatorCoapSubcomponent;
import org.zefxis.dexms.dex.protocols.primitives.MediatorGmSubcomponent;
import org.zefxis.dexms.dex.protocols.rest.MediatorRestSubcomponent;
import org.zefxis.dexms.gmdl.utils.MediatorConfiguration;
import org.zefxis.dexms.gmdl.utils.GmServiceRepresentation;
import org.zefxis.dexms.gmdl.utils.Interface;
import org.zefxis.dexms.gmdl.utils.PathResolver;
import org.zefxis.dexms.gmdl.utils.enums.RoleType;
import org.zefxis.dexms.tools.serviceparser.ServiceDescriptionParser;


public class Mediator {

	MediatorGmSubcomponent[][] subcomponent;
    GmServiceRepresentation gmServiceRepresentation = null;

    public void run() {
        java.lang.Integer intFive;
        intFive = Integer.parseInt("5");
        java.lang.Integer intOne;
        intOne = Integer.parseInt("1");
        java.lang.Integer intNine;
        intNine = Integer.parseInt("9");
        PathResolver pathResolver = new PathResolver();
        String interfaceDescFilePath;
        interfaceDescFilePath = pathResolver.myFilePath(Mediator.class, ((new String("config")+ File.separator)+ new String("serviceDescription.gxdl")));
        System.out.println(interfaceDescFilePath);
        gmServiceRepresentation = ServiceDescriptionParser.getRepresentationFromGIDL(interfaceDescFilePath);
        int num_interfaces = gmServiceRepresentation.getInterfaces().size();
        subcomponent = new MediatorGmSubcomponent[num_interfaces][2];
        for (int i = 0; (i<gmServiceRepresentation.getInterfaces().size()); i += 1) {
            Interface inter = null;
            inter = gmServiceRepresentation.getInterfaces().get(i);
            RoleType busRole;
            if (inter.getRole() == RoleType.SERVER) {
                busRole = RoleType.CLIENT;
            } else {
                busRole = RoleType.SERVER;
            }
            MediatorConfiguration bcConfiguration1 = new MediatorConfiguration();
            MediatorConfiguration bcConfiguration2 = new MediatorConfiguration();
            bcConfiguration1 .setSubcomponentRole(inter.getRole());
            bcConfiguration2 .setSubcomponentRole(busRole);
            String config_block1_interfacePath;
            config_block1_interfacePath = pathResolver.myFilePath(Mediator.class, (((new String("config")+ File.separator)+ new String("config_block1_interface_"))+ String.valueOf((i + intOne))));
            bcConfiguration1 .parseFromJSON(gmServiceRepresentation, new String(config_block1_interfacePath));
            String config_block2_interfacePath;
            config_block2_interfacePath = pathResolver.myFilePath(Mediator.class, (((new String("config")+ File.separator)+ new String("config_block2_interface_"))+ String.valueOf((i + intOne))));
            bcConfiguration2 .parseFromJSON(gmServiceRepresentation, new String(config_block2_interfacePath));
            subcomponent[i][0] = new MediatorCoapSubcomponent(bcConfiguration1, gmServiceRepresentation);
            subcomponent[i][1] = new MediatorRestSubcomponent(bcConfiguration2, gmServiceRepresentation);
            MediatorGmSubcomponent block1Component = subcomponent[i][0];
            MediatorGmSubcomponent block2Component = subcomponent[i][1];
            block1Component.setNextComponent(block2Component);
            block2Component.setNextComponent(block1Component);
            block1Component.start();
            block2Component.start();
        }
    }

    public void pause(){
    	
        for (int i = 0; (i<gmServiceRepresentation.getInterfaces().size()); i += 1) {
            System.out.println("genfac stop iteration");
            MediatorGmSubcomponent block1Component = subcomponent[i][0];
            MediatorGmSubcomponent block2Component = subcomponent[i][1];
            block1Component.stop();
            block2Component.stop();
        }
    }

}
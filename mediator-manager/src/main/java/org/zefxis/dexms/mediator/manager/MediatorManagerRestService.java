package org.zefxis.dexms.mediator.manager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.zefxis.dexms.dex.protocols.Manageable;
//import org.zefxis.dexms.mediator.generated.Mediator;


public class MediatorManagerRestService implements Manageable {

	private Component component;
	private Server server;  
	private Boolean serverOnline = false;
	private Boolean bcStarted = false;
	
	// Mediator bc = new Mediator();

	public MediatorManagerRestService(final int port){
		
		if(!isServerOnline()){
			
			this.server = new Server(Protocol.HTTP, port);
			this.component = new Component();
			this.component.getServers().add(server);
			this.component.getDefaultHost().attach("/getconfiguration", GetConfiguration.class);
			this.component.getDefaultHost().attach("/setconfiguration", SetConfiguration.class);

			try {
				
				this.component.start();
				
				Thread.sleep(1000);
				
				runBC();
				
				setServerOnline(true);
				
			} catch (Exception e){
				
				e.printStackTrace();
			}
			
		}else{
			
			System.out.println(" Server already started ");
			
		}
		      
	}

	public void runBC(){
		
		if(!isBcSarted()){
			
			// bc.run();
			setBcSarted(true);
			
		}else{
			
			System.out.println(" BC already started ");
		}
		
	}

	public void pauseBC() {
		
		if(isBcSarted()){
			
			// bc.pause();
			setBcSarted(false);
			
		}else{
			
			System.out.println(" BC already stopped ");
			
		}
		
	}

	public static class GetConfiguration extends ServerResource {
		@Override
		protected Representation post(Representation entity) throws ResourceException {
			File dir = new File(MediatorManagerRestService.class.getClassLoader().getResource("example.json").toExternalForm().substring(9)).getParentFile().getParentFile().getParentFile().getParentFile();
			File dir2 = new File(dir.getAbsolutePath() + File.separator + "config");

			List<File> configFiles = Arrays.asList(dir2.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith("config_block");
				}}));

			String returnMessage = "Following files copied: \n";

			for (File file : configFiles) {
				String configTemplatePath = file.getAbsolutePath();
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = null;

				try{
					
					jsonObject = (JSONObject) parser.parse(new FileReader(configTemplatePath));
				
				}catch (IOException | ParseException e) {
					e.printStackTrace();
				}

				try (FileWriter output_file = new FileWriter(file.getName())) {
					output_file.write(jsonObject.toJSONString());
					returnMessage += file.getName();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return new StringRepresentation(returnMessage);
		}

		@Override
		protected Representation get() throws ResourceException{
			
			File dir = new File(MediatorManagerRestService.class.getClassLoader().getResource("example.json").toExternalForm().substring(9)).getParentFile().getParentFile().getParentFile().getParentFile();
			File dir2 = new File(dir.getAbsolutePath() + File.separator + "config");

			List<File> configFiles = Arrays.asList(dir2.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith("config_block");
				}}));

			String returnMessage = "Following files copied: \n";

			for (File file : configFiles) {
				String configTemplatePath = file.getAbsolutePath();
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = null;

				try {
					jsonObject = (JSONObject) parser.parse(new FileReader(configTemplatePath));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}

				try (FileWriter output_file = new FileWriter(file.getName())) {
					output_file.write(jsonObject.toJSONString());
					returnMessage += file.getName();
				} catch (IOException e){
					
					e.printStackTrace();
				}
			}

			returnMessage += "\n\nConfiguration Complete!";
			return new StringRepresentation(returnMessage);
		}
	}

	public static class SetConfiguration extends ServerResource {

		@Override
		protected Representation get() throws ResourceException {

			File dir = new File(".");

			List<File> configFiles = Arrays.asList(dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith("config_block");
				}}));

			String returnMessage = "Following files copied: \n";

			for (File file : configFiles) {
				String configTemplatePath = file.getAbsolutePath();
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = null;

				try {
					jsonObject = (JSONObject) parser.parse(new FileReader(configTemplatePath));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}

				File dir2 = new File(MediatorManagerRestService.class.getClassLoader().getResource("example.json").toExternalForm().substring(9)).getParentFile().getParentFile().getParentFile().getParentFile();
				File dir3 = new File(dir2.getAbsolutePath() + File.separator + "config");


				List<File> configFiles2 = Arrays.asList(dir3.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.startsWith(file.getName());
					}}));

				for (File file2 : configFiles2) {
					try (FileWriter output_file = new FileWriter(file2)) {
						System.out.println("sidq: " + file2.getAbsolutePath());
						output_file.write(jsonObject.toJSONString());
						returnMessage += file.getName();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

			returnMessage = "Configuration Complete!";
			return new StringRepresentation(returnMessage);
		}

		@Override
		protected Representation post(Representation entity) throws ResourceException {

			File dir = new File(".");

			List<File> configFiles = Arrays.asList(dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.startsWith("config_block");
				}}));

			String returnMessage = "Following files copied: \n";

			for (File file : configFiles) {
				String configTemplatePath = file.getAbsolutePath();
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = null;

				try {
					jsonObject = (JSONObject) parser.parse(new FileReader(configTemplatePath));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}

				File dir2 = new File(MediatorManagerRestService.class.getClassLoader().getResource("example.json").toExternalForm().substring(9)).getParentFile().getParentFile().getParentFile().getParentFile();
				File dir3 = new File(dir2.getAbsolutePath() + File.separator + "config");


				List<File> configFiles2 = Arrays.asList(dir3.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.startsWith(file.getName());
					}}));

				for (File file2 : configFiles2) {
					try (FileWriter output_file = new FileWriter(file2)) {
						output_file.write(jsonObject.toJSONString());
						returnMessage += file.getName();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}

			returnMessage = "Configuration Complete!";
			return new StringRepresentation(returnMessage);
		}

	}

	@Override
	public void start() {
		try{
			
			this.component.start();
			
		}
		catch (Exception e){
			
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		try {
			this.server.stop();
			this.component.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean isServerOnline() {
		return serverOnline;
	}

	public void setServerOnline(Boolean serverOnline) {
		this.serverOnline = serverOnline;
	}

	public Boolean isBcSarted() {
		return bcStarted;
	}

	public void setBcSarted(Boolean bcSarted){
		this.bcStarted = bcSarted;
	}

}
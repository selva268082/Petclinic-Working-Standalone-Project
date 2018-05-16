package org.springframework.samples.test.bean;

import java.io.IOException;
 

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JaksonCustomBusSerializer extends StdSerializer<Bus>{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JaksonCustomBusSerializer() {
	        this(null);
	    }
	 
	    public JaksonCustomBusSerializer(Class<Bus> t) {
	        super(t);
	    }

		@Override
		public void serialize(Bus bus, JsonGenerator jgen, SerializerProvider provider) throws IOException {
			jgen.writeStartObject();
			if (bus.getBusID() <0) {
				jgen.writeNullField("id");
			} else {
				jgen.writeNumberField("id", bus.getBusID());
			}

			jgen.writeStringField("firstName", bus.getName());
			
			jgen.writeArrayFieldStart("passenger");
			jgen.writeStartObject(); // pax
			bus.getPaxLst().stream().forEach(pax-> {
				try {
					jgen.writeNumberField("paxId",pax.getPaxId());
					jgen.writeStringField("paxName", pax.getPaxname());
					jgen.writeNumberField("bus_ID", pax.getBus().getBusID());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			jgen.writeEndObject();
			jgen.writeEndArray(); //pax
		 
			
			jgen.writeEndObject();//Bus
		}
  
	 
	    
}

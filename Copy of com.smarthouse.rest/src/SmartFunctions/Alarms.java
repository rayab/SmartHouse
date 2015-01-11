package SmartFunctions;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;



@JsonPropertyOrder({ "name", "state", "selected" })
public class Alarms {

	@org.codehaus.jackson.annotate.JsonProperty("name")
	private String name;
	@org.codehaus.jackson.annotate.JsonProperty("state")
	private boolean state;
	@org.codehaus.jackson.annotate.JsonProperty("selected")
	private int selected;
	@org.codehaus.jackson.annotate.JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Alarms withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The state
	 */
	@JsonProperty("state")
	public boolean isState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *          
	 */
	@JsonProperty("state")
	public void setState(boolean state) {
		this.state = state;
	}

	public Alarms withState(boolean state) {
		this.state = state;
		return this;
	}

	/**
	 * 
	 * @return selected
	 */
	@JsonProperty("selected")
	public int getSelected() {
		return selected;
	}

	/**
	 * 
	 * @param selected
	 *           
	 */
	@JsonProperty("selected")
	public void setSelected(int selected) {
		this.selected = selected;
	}

	public Alarms withSelected(int selected) {
		this.selected = selected;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}


	
	public String toString() {
	return toString();
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Alarms withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	
	
	public class DoorAlarm{
		String name ="Door Alarm";
		boolean state = true;
		int selected = 1;
		
	}
	
	
	public class FloodAlarm{
		
		String name ="Flood Alarm";
		boolean state = false;
		int selected = 3;
	}
	
	
}
	
	



package SmartFunctions;

public class House {

	// Make sure the right ones are indoors and outdoors
	
	//public Device[][] rooms = new Device[2][12];
	//public Device[] rooms = new Device[2];
	public Device[] inside = new Device[12];
	public Device[] outside = new Device[4];
	
	public House(){
		
	for(int i = 0; i<12; i++){
		inside[i] = new Device();
	}
	for(int i = 0; i<4; i++){
		outside[i] = new Device();
	}	
	
	}
	
//	private boolean fireAlarm;
//	private boolean stove;
//	private boolean waterLeakage;
//	private boolean window;
//	private boolean door;
//	private boolean electricity;
//	private boolean lightIn;
//	private boolean autoLightIn;
//	private boolean lightOut;
//	private boolean autoLightOut;
//	private boolean heaterIn;
//	private boolean heaterRoof;
//	private int fan = 0;
//	private int autoAir = 0;
//	private boolean tempOut;
//	private boolean tempIn;
//	private boolean tempRoof;
//	private boolean elCon;
//	private boolean secAlarm;

	public Device[] getInside() {
		return inside;
	}

	public void setInside(Device[] inside) {
		this.inside = inside;
	}

	public Device[] getOutside() {
		return outside;
	}

	public void setOutside(Device[] outside) {
		this.outside = outside;
	}

	public class Device {
		public String name = null;
		public int id = 0;
		public boolean state;
		public int value = 0;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean getState() {
			return state;
		}
		public void setState(boolean state) {
			this.state = state;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		
		

	}
}

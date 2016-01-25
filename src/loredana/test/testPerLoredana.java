package loredana.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testPerLoredana {

	public static void main(String[] args) {

		HttpClient client = HttpClientBuilder.create().build();
		String url = "http://146.48.85.231:8080//OpenLinkData/rest/webservice/buildingSensorRegister/";
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		SensoreBuilding messaggio = new SensoreBuilding();
		messaggio.setIdApp("test0");
		messaggio.setMonitoredFeature("test1");
		messaggio.setIdLocalSensor("test2");
		messaggio.setSensorType("test3");
		messaggio.setValueType("test4");
		messaggio.setCharacteristic("none5");
		String jsonMessaggio = gson.toJson(messaggio);
		System.out.println(jsonMessaggio);

		HttpResponse response = null;
		try

		{
			HttpPost request = new HttpPost(url);

			StringEntity params = new StringEntity(jsonMessaggio);

			request.addHeader("content-type", "application/x-www-form-urlencoded");
			request.setEntity(params);
			response = client.execute(request);
		} catch (

		IOException e)

		{

			e.printStackTrace();
		}

		BufferedReader rd = null;
		try

		{
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		} catch (UnsupportedOperationException |

		IOException e)

		{

			e.printStackTrace();
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		try

		{
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (

		IOException e)

		{

			e.printStackTrace();
		}
		System.out.println(result);

	}

}

class SensoreBuilding {

	String idApp;
	String idLocalSensor;
	String monitoredFeature;
	String sensorType;
	String valueType;
	String characteristic;

	public String getIdApp() {
		return idApp;
	}

	public void setIdApp(String idApp) {
		this.idApp = idApp;
	}

	public String getIdLocalSensor() {
		return idLocalSensor;
	}

	public void setIdLocalSensor(String idLocalSensor) {
		this.idLocalSensor = idLocalSensor;
	}

	public String getMonitoredFeature() {
		return monitoredFeature;
	}

	public void setMonitoredFeature(String monitoredFeature) {
		this.monitoredFeature = monitoredFeature;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

}

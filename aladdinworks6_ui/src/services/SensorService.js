import http from "../http-common"; 

class SensorService {
  getAllSensors(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/sensor/sensors`, searchDTO);
  }

  get(sensorId) {
    return this.getRequest(`/sensor/${sensorId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/sensor?field=${matchData}`, null);
  }

  addSensor(data) {
    return http.post("/sensor/addSensor", data);
  }

  update(data) {
  	return http.post("/sensor/updateSensor", data);
  }
  
  uploadImage(data,sensorId) {
  	return http.postForm("/sensor/uploadImage/"+sensorId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new SensorService();

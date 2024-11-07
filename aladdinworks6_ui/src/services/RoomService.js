import http from "../http-common"; 

class RoomService {
  getAllRooms(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/room/rooms`, searchDTO);
  }

  get(roomId) {
    return this.getRequest(`/room/${roomId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/room?field=${matchData}`, null);
  }

  addRoom(data) {
    return http.post("/room/addRoom", data);
  }

  update(data) {
  	return http.post("/room/updateRoom", data);
  }
  
  uploadImage(data,roomId) {
  	return http.postForm("/room/uploadImage/"+roomId, data);
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

export default new RoomService();

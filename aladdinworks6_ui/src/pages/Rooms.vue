<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <room-table
            v-if="rooms && rooms.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:rooms="rooms"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-rooms="getAllRooms"
             >

            </room-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import RoomTable from "@/components/RoomTable";
import RoomService from "../services/RoomService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    RoomTable,
  },
  data() {
    return {
      rooms: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllRooms(sortBy='roomId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await RoomService.getAllRooms(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.rooms.length) {
					this.rooms = response.data.rooms;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching rooms:", error);
        }
        
      } catch (error) {
        console.error("Error fetching room details:", error);
      }
    },
  },
  mounted() {
    this.getAllRooms();
  },
  created() {
    this.$root.$on('searchQueryForRoomsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllRooms();
    })
  }
};
</script>
<style></style>

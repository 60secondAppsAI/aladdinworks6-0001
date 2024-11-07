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
            <sensor-table
            v-if="sensors && sensors.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:sensors="sensors"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-sensors="getAllSensors"
             >

            </sensor-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import SensorTable from "@/components/SensorTable";
import SensorService from "../services/SensorService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    SensorTable,
  },
  data() {
    return {
      sensors: [],
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
    async getAllSensors(sortBy='sensorId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await SensorService.getAllSensors(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.sensors.length) {
					this.sensors = response.data.sensors;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching sensors:", error);
        }
        
      } catch (error) {
        console.error("Error fetching sensor details:", error);
      }
    },
  },
  mounted() {
    this.getAllSensors();
  },
  created() {
    this.$root.$on('searchQueryForSensorsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllSensors();
    })
  }
};
</script>
<style></style>

import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import DataCenters from  '@/pages/DataCenters.vue';
import DataCenterDetail from  '@/pages/DataCenterDetail.vue';
import Racks from  '@/pages/Racks.vue';
import RackDetail from  '@/pages/RackDetail.vue';
import PowerSupplys from  '@/pages/PowerSupplys.vue';
import PowerSupplyDetail from  '@/pages/PowerSupplyDetail.vue';
import PowerStrips from  '@/pages/PowerStrips.vue';
import PowerStripDetail from  '@/pages/PowerStripDetail.vue';
import CoolingUnits from  '@/pages/CoolingUnits.vue';
import CoolingUnitDetail from  '@/pages/CoolingUnitDetail.vue';
import StaticTransferSwitchs from  '@/pages/StaticTransferSwitchs.vue';
import StaticTransferSwitchDetail from  '@/pages/StaticTransferSwitchDetail.vue';
import Generators from  '@/pages/Generators.vue';
import GeneratorDetail from  '@/pages/GeneratorDetail.vue';
import MonitoringPoints from  '@/pages/MonitoringPoints.vue';
import MonitoringPointDetail from  '@/pages/MonitoringPointDetail.vue';
import Servers from  '@/pages/Servers.vue';
import ServerDetail from  '@/pages/ServerDetail.vue';
import NetworkSwitchs from  '@/pages/NetworkSwitchs.vue';
import NetworkSwitchDetail from  '@/pages/NetworkSwitchDetail.vue';
import Rooms from  '@/pages/Rooms.vue';
import RoomDetail from  '@/pages/RoomDetail.vue';
import Maintenances from  '@/pages/Maintenances.vue';
import MaintenanceDetail from  '@/pages/MaintenanceDetail.vue';
import Alerts from  '@/pages/Alerts.vue';
import AlertDetail from  '@/pages/AlertDetail.vue';
import Users from  '@/pages/Users.vue';
import UserDetail from  '@/pages/UserDetail.vue';
import UserRoles from  '@/pages/UserRoles.vue';
import UserRoleDetail from  '@/pages/UserRoleDetail.vue';
import TemperatureSensors from  '@/pages/TemperatureSensors.vue';
import TemperatureSensorDetail from  '@/pages/TemperatureSensorDetail.vue';
import PowerMeters from  '@/pages/PowerMeters.vue';
import PowerMeterDetail from  '@/pages/PowerMeterDetail.vue';
import Sensors from  '@/pages/Sensors.vue';
import SensorDetail from  '@/pages/SensorDetail.vue';
import CapacityReports from  '@/pages/CapacityReports.vue';
import CapacityReportDetail from  '@/pages/CapacityReportDetail.vue';
import Incidents from  '@/pages/Incidents.vue';
import IncidentDetail from  '@/pages/IncidentDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/dataCenters',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/dataCenters',
		name: 'DataCenters',
		layout: DefaultLayout,
		component: DataCenters,
	},
	{
	    path: '/dataCenter/:dataCenterId', 
	    name: 'DataCenterDetail',
		layout: DefaultLayout,
	    component: DataCenterDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/racks',
		name: 'Racks',
		layout: DefaultLayout,
		component: Racks,
	},
	{
	    path: '/rack/:rackId', 
	    name: 'RackDetail',
		layout: DefaultLayout,
	    component: RackDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/powerSupplys',
		name: 'PowerSupplys',
		layout: DefaultLayout,
		component: PowerSupplys,
	},
	{
	    path: '/powerSupply/:powerSupplyId', 
	    name: 'PowerSupplyDetail',
		layout: DefaultLayout,
	    component: PowerSupplyDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/powerStrips',
		name: 'PowerStrips',
		layout: DefaultLayout,
		component: PowerStrips,
	},
	{
	    path: '/powerStrip/:powerStripId', 
	    name: 'PowerStripDetail',
		layout: DefaultLayout,
	    component: PowerStripDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/coolingUnits',
		name: 'CoolingUnits',
		layout: DefaultLayout,
		component: CoolingUnits,
	},
	{
	    path: '/coolingUnit/:coolingUnitId', 
	    name: 'CoolingUnitDetail',
		layout: DefaultLayout,
	    component: CoolingUnitDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/staticTransferSwitchs',
		name: 'StaticTransferSwitchs',
		layout: DefaultLayout,
		component: StaticTransferSwitchs,
	},
	{
	    path: '/staticTransferSwitch/:staticTransferSwitchId', 
	    name: 'StaticTransferSwitchDetail',
		layout: DefaultLayout,
	    component: StaticTransferSwitchDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/generators',
		name: 'Generators',
		layout: DefaultLayout,
		component: Generators,
	},
	{
	    path: '/generator/:generatorId', 
	    name: 'GeneratorDetail',
		layout: DefaultLayout,
	    component: GeneratorDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/monitoringPoints',
		name: 'MonitoringPoints',
		layout: DefaultLayout,
		component: MonitoringPoints,
	},
	{
	    path: '/monitoringPoint/:monitoringPointId', 
	    name: 'MonitoringPointDetail',
		layout: DefaultLayout,
	    component: MonitoringPointDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/servers',
		name: 'Servers',
		layout: DefaultLayout,
		component: Servers,
	},
	{
	    path: '/server/:serverId', 
	    name: 'ServerDetail',
		layout: DefaultLayout,
	    component: ServerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/networkSwitchs',
		name: 'NetworkSwitchs',
		layout: DefaultLayout,
		component: NetworkSwitchs,
	},
	{
	    path: '/networkSwitch/:networkSwitchId', 
	    name: 'NetworkSwitchDetail',
		layout: DefaultLayout,
	    component: NetworkSwitchDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/rooms',
		name: 'Rooms',
		layout: DefaultLayout,
		component: Rooms,
	},
	{
	    path: '/room/:roomId', 
	    name: 'RoomDetail',
		layout: DefaultLayout,
	    component: RoomDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/maintenances',
		name: 'Maintenances',
		layout: DefaultLayout,
		component: Maintenances,
	},
	{
	    path: '/maintenance/:maintenanceId', 
	    name: 'MaintenanceDetail',
		layout: DefaultLayout,
	    component: MaintenanceDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/alerts',
		name: 'Alerts',
		layout: DefaultLayout,
		component: Alerts,
	},
	{
	    path: '/alert/:alertId', 
	    name: 'AlertDetail',
		layout: DefaultLayout,
	    component: AlertDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/users',
		name: 'Users',
		layout: DefaultLayout,
		component: Users,
	},
	{
	    path: '/user/:userId', 
	    name: 'UserDetail',
		layout: DefaultLayout,
	    component: UserDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/userRoles',
		name: 'UserRoles',
		layout: DefaultLayout,
		component: UserRoles,
	},
	{
	    path: '/userRole/:userRoleId', 
	    name: 'UserRoleDetail',
		layout: DefaultLayout,
	    component: UserRoleDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/temperatureSensors',
		name: 'TemperatureSensors',
		layout: DefaultLayout,
		component: TemperatureSensors,
	},
	{
	    path: '/temperatureSensor/:temperatureSensorId', 
	    name: 'TemperatureSensorDetail',
		layout: DefaultLayout,
	    component: TemperatureSensorDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/powerMeters',
		name: 'PowerMeters',
		layout: DefaultLayout,
		component: PowerMeters,
	},
	{
	    path: '/powerMeter/:powerMeterId', 
	    name: 'PowerMeterDetail',
		layout: DefaultLayout,
	    component: PowerMeterDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/sensors',
		name: 'Sensors',
		layout: DefaultLayout,
		component: Sensors,
	},
	{
	    path: '/sensor/:sensorId', 
	    name: 'SensorDetail',
		layout: DefaultLayout,
	    component: SensorDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/capacityReports',
		name: 'CapacityReports',
		layout: DefaultLayout,
		component: CapacityReports,
	},
	{
	    path: '/capacityReport/:capacityReportId', 
	    name: 'CapacityReportDetail',
		layout: DefaultLayout,
	    component: CapacityReportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/incidents',
		name: 'Incidents',
		layout: DefaultLayout,
		component: Incidents,
	},
	{
	    path: '/incident/:incidentId', 
	    name: 'IncidentDetail',
		layout: DefaultLayout,
	    component: IncidentDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;

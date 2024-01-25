import foodOrderYaml from "./foodOrder-openapi.yaml";
import restaurantYaml from "./restaurant-openapi.yaml";
import deliveryOrderYaml from "./deliveryOrder-openapi.yaml";
import restaurantManagementYaml from "./restaurantManagement-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let foodOrderSpec = YAML.stringify(foodOrderYaml);
apiSpec += foodOrderSpec;

let restaurantSpec = YAML.stringify(restaurantYaml);
apiSpec += restaurantSpec;

let deliveryOrderSpec = YAML.stringify(deliveryOrderYaml);
apiSpec += deliveryOrderSpec;

let restaurantManagementSpec = YAML.stringify(restaurantManagementYaml);
apiSpec += restaurantManagementSpec;


export default apiSpec;
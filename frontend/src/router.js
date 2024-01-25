
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FoodOrderingFoodOrderManager from "./components/listers/FoodOrderingFoodOrderCards"
import FoodOrderingFoodOrderDetail from "./components/listers/FoodOrderingFoodOrderDetail"
import FoodOrderingRestaurantManager from "./components/listers/FoodOrderingRestaurantCards"
import FoodOrderingRestaurantDetail from "./components/listers/FoodOrderingRestaurantDetail"

import FoodDeliveryDeliveryOrderManager from "./components/listers/FoodDeliveryDeliveryOrderCards"
import FoodDeliveryDeliveryOrderDetail from "./components/listers/FoodDeliveryDeliveryOrderDetail"

import RestaurantManagementRestaurantManagementManager from "./components/listers/RestaurantManagementRestaurantManagementCards"
import RestaurantManagementRestaurantManagementDetail from "./components/listers/RestaurantManagementRestaurantManagementDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/foodOrderings/foodOrders',
                name: 'FoodOrderingFoodOrderManager',
                component: FoodOrderingFoodOrderManager
            },
            {
                path: '/foodOrderings/foodOrders/:id',
                name: 'FoodOrderingFoodOrderDetail',
                component: FoodOrderingFoodOrderDetail
            },
            {
                path: '/foodOrderings/restaurants',
                name: 'FoodOrderingRestaurantManager',
                component: FoodOrderingRestaurantManager
            },
            {
                path: '/foodOrderings/restaurants/:id',
                name: 'FoodOrderingRestaurantDetail',
                component: FoodOrderingRestaurantDetail
            },

            {
                path: '/foodDeliveries/deliveryOrders',
                name: 'FoodDeliveryDeliveryOrderManager',
                component: FoodDeliveryDeliveryOrderManager
            },
            {
                path: '/foodDeliveries/deliveryOrders/:id',
                name: 'FoodDeliveryDeliveryOrderDetail',
                component: FoodDeliveryDeliveryOrderDetail
            },

            {
                path: '/restaurantManagements/restaurantManagements',
                name: 'RestaurantManagementRestaurantManagementManager',
                component: RestaurantManagementRestaurantManagementManager
            },
            {
                path: '/restaurantManagements/restaurantManagements/:id',
                name: 'RestaurantManagementRestaurantManagementDetail',
                component: RestaurantManagementRestaurantManagementDetail
            },



    ]
})

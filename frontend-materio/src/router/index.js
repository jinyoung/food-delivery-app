import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/foodOrders',
      component: () => import('../components/ui/FoodOrderGrid.vue'),
    },
    {
      path: '/restaurants',
      component: () => import('../components/ui/RestaurantGrid.vue'),
    },
    {
      path: '/deliveryOrders',
      component: () => import('../components/ui/DeliveryOrderGrid.vue'),
    },
    {
      path: '/restaurantManagements',
      component: () => import('../components/ui/RestaurantManagementGrid.vue'),
    },
  ],
})

export default router;

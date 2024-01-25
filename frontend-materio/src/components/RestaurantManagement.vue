<template>
    <div>
        <String label="음식점 ID" v-model="value.restaurantId" :editMode="editMode"/>
        <String label="음식점 이름" v-model="value.restaurantName" :editMode="editMode"/>
        <String label="메뉴" v-model="value.menu" :editMode="editMode"/>
        <String label="주문 내역" v-model="value.orderHistory" :editMode="editMode"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'
import String from './primitives/String.vue'

export default {
    name: 'RestaurantManagement',
    mixins:[BaseEntity],
    components:{
        String,
    },
    
    data: () => ({
        path: "restaurantManagements"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

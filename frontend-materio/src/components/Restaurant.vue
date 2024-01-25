<template>
    <div>
        <String label="음식점 ID" v-model="value.restaurantId" :editMode="editMode"/>
        <String label="음식점 이름" v-model="value.restaurantName" :editMode="editMode"/>
        <String label="메뉴" v-model="value.menu" :editMode="editMode"/>
        <String label="운영 시간" v-model="value.operatingHours" :editMode="editMode"/>

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
    name: 'Restaurant',
    mixins:[BaseEntity],
    components:{
        String,
    },
    
    data: () => ({
        path: "restaurants"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

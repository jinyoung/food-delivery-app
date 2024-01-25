<template>
    <div>
        <Number label="주문 ID" v-model="value.orderId" :editMode="editMode"/>
        <String label="사용자 ID" v-model="value.userId" :editMode="editMode"/>
        <String label="음식점 ID" v-model="value.restaurantId" :editMode="editMode"/>
        <String label="메뉴 항목" v-model="value.menuItem" :editMode="editMode"/>
        <String label="주문 상태" v-model="value.status" :editMode="editMode"/>
        <String label="주문 상태 유형" v-model="value.statusType" :editMode="editMode"/>
        <String label="배달원 ID" v-model="value.deliveryDriverId" :editMode="editMode"/>
        <Payment offline label="결제 정보" v-model="value.paymentInfo" :editMode="editMode" @change="change"/>

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
import Number from './primitives/Number.vue'
import String from './primitives/String.vue'
import Payment from './vo/Payment.vue'

export default {
    name: 'FoodOrder',
    mixins:[BaseEntity],
    components:{
        Number,
        String,
        Payment,
    },
    
    data: () => ({
        path: "foodOrders"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

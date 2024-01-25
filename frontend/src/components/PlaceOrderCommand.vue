<template>
    <v-card outlined>
        <v-card-title>
            PlaceOrder
        </v-card-title>

        <v-card-text>
            <String label="OrderId" v-model="value.orderId" :editMode="editMode"/>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="RestaurantId" v-model="value.restaurantId" :editMode="editMode"/>
            <String label="MenuItem" v-model="value.menuItem" :editMode="editMode"/>
            <Payment offline label="PaymentInfo" v-model="value.paymentInfo" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="placeOrder"
            >
                PlaceOrder
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'PlaceOrderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderId = '';
            this.value.userId = '';
            this.value.restaurantId = '';
            this.value.menuItem = '';
            this.value.paymentInfo = {};
        },
        watch: {
        },
        methods: {
            placeOrder() {
                this.$emit('placeOrder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>


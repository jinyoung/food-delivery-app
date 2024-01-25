<template>
    <v-card outlined>
        <v-card-title>
            ViewOrderHistory
        </v-card-title>

        <v-card-text>
            <String label="RestaurantId" v-model="value.restaurantId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="viewOrderHistory"
            >
                ViewOrderHistory
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
        name: 'ViewOrderHistoryCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.restaurantId = '';
        },
        watch: {
        },
        methods: {
            viewOrderHistory() {
                this.$emit('viewOrderHistory', this.value);
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


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
                    color="deep-purple lighten-2"
                    text
                    @click="viewOrderHistory"
            >
                ViewOrderHistory
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
import String from './primitives/String.vue'

export default {
    name: 'ViewOrderHistoryCommand',
    components:{
        String,
    },
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
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>


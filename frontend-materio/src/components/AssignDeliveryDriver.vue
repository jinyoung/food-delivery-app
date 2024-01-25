<template>

    <v-card outlined>
        <v-card-title>
            AssignDeliveryDriver
        </v-card-title>

        <v-card-text>
            <String label="OrderId" v-model="value.orderId" :editMode="editMode"/>
            <String label="DeliveryDriverId" v-model="value.deliveryDriverId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="assignDeliveryDriver"
            >
                AssignDeliveryDriver
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
import String from './String.vue'

export default {
    name: 'AssignDeliveryDriverCommand',
    components:{
        String,
        String,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.orderId = '';
        this.value.deliveryDriverId = '';
    },
    watch: {
    },
    methods: {
        assignDeliveryDriver() {
            this.$emit('assignDeliveryDriver', this.value);
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


<template>

    <v-card outlined>
        <v-card-title>
            UpdateDeliveryStatus
        </v-card-title>

        <v-card-text>
            <String label="OrderId" v-model="value.orderId" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateDeliveryStatus"
            >
                UpdateDeliveryStatus
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
    name: 'UpdateDeliveryStatusCommand',
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
        this.value.status = '';
    },
    watch: {
    },
    methods: {
        updateDeliveryStatus() {
            this.$emit('updateDeliveryStatus', this.value);
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


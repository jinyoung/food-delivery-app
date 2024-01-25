<template>
    <v-card outlined>
        <v-card-title>
            RegisterRestaurant
        </v-card-title>

        <v-card-text>
            <String label="RestaurantId" v-model="value.restaurantId" :editMode="editMode"/>
            <String label="RestaurantName" v-model="value.restaurantName" :editMode="editMode"/>
            <String label="Menu" v-model="value.menu" :editMode="editMode"/>
            <String label="OperatingHours" v-model="value.operatingHours" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registerRestaurant"
            >
                RegisterRestaurant
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
        name: 'RegisterRestaurantCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.restaurantId = '';
            this.value.restaurantName = '';
            this.value.menu = '';
            this.value.operatingHours = '';
        },
        watch: {
        },
        methods: {
            registerRestaurant() {
                this.$emit('registerRestaurant', this.value);
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


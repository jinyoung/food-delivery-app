<template>
    <v-card outlined>
        <v-card-title>
            UpdateRestaurantMenu
        </v-card-title>

        <v-card-text>
            <String label="RestaurantId" v-model="value.restaurantId" :editMode="editMode"/>
            <String label="Menu" v-model="value.menu" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateRestaurantMenu"
            >
                UpdateRestaurantMenu
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
        name: 'UpdateRestaurantMenuCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.restaurantId = '';
            this.value.menu = '';
        },
        watch: {
        },
        methods: {
            updateRestaurantMenu() {
                this.$emit('updateRestaurantMenu', this.value);
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


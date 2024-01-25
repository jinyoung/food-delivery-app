<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="updateOrderStatusDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Restaurant Manager')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>주문 상태 업데이트
                </v-btn>
                <v-dialog v-model="updateOrderStatusDialog" width="500">
                    <UpdateOrderStatus
                        @closeDialog="updateOrderStatusDialog = false"
                        @updateOrderStatus="updateOrderStatus"
                    ></UpdateOrderStatus>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>사용자 ID</th>
                        <th>음식점 ID</th>
                        <th>메뉴 항목</th>
                        <th>결제 정보</th>
                        <th>주문 상태</th>
                        <th>주문 상태 유형</th>
                        <th>배달원 ID</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="사용자 ID">{{ val.userId }}</td>
                            <td class="whitespace-nowrap" label="음식점 ID">{{ val.restaurantId }}</td>
                            <td class="whitespace-nowrap" label="메뉴 항목">{{ val.menuItem }}</td>
                            <td class="whitespace-nowrap" label="결제 정보">
                                <Payment :editMode="false" :inList="true" v-model="val.paymentInfo"></Payment>
                            </td>
                            <td class="whitespace-nowrap" label="주문 상태">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="주문 상태 유형">{{ val.statusType }}</td>
                            <td class="whitespace-nowrap" label="배달원 ID">{{ val.deliveryDriverId }}</td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">FoodOrder 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <FoodOrder :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">FoodOrder 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="주문 ID" v-model="selectedRow.orderId" :editMode="true"/>
                            <String label="사용자 ID" v-model="selectedRow.userId" :editMode="true"/>
                            <String label="음식점 ID" v-model="selectedRow.restaurantId" :editMode="true"/>
                            <String label="메뉴 항목" v-model="selectedRow.menuItem" :editMode="true"/>
                            <String label="주문 상태" v-model="selectedRow.status" :editMode="true"/>
                            <String label="주문 상태 유형" v-model="selectedRow.statusType" :editMode="true"/>
                            <String label="배달원 ID" v-model="selectedRow.deliveryDriverId" :editMode="true"/>
                            <Payment offline label="결제 정보" v-model="selectedRow.paymentInfo" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'
import FoodOrder from '../FoodOrder.vue'
import String from '../primitives/String.vue'
import Payment from '../vo/Payment.vue'
import UpdateOrderStatus from '../UpdateOrderStatus.vue'

export default {
    name: 'foodOrderGrid',
    mixins:[BaseGrid],
    components:{
        FoodOrder,
        String,
        Payment,
        UpdateOrderStatus,
    },
    data: () => ({
        path: 'foodOrders',
        updateOrderStatusDialog: false,
    }),
    watch: {
    },
    methods:{
        updateOrderStatus(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "updateOrderStatus", params)
                this.$EventBus.$emit('show-success','UpdateOrderStatus 성공적으로 처리되었습니다.')
                this.updateOrderStatusDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>
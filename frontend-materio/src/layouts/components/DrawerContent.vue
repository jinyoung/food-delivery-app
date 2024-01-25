<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '음식 주문' }" />
        <VerticalNavLink
            :item="{
                title: '음식 주문',
                to: '/foodOrders',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '음식점',
                to: '/restaurants',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '음식 배달' }" />
        <VerticalNavLink
            :item="{
                title: '배달 주문',
                to: '/deliveryOrders',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '음식 가게 관리' }" />
        <VerticalNavLink
            :item="{
                title: '음식 가게 관리',
                to: '/restaurantManagements',
            }"
        />
    </ul>
</template>

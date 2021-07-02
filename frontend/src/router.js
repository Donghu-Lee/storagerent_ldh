
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentManager from "./components/PaymentManager"

import StorageManager from "./components/StorageManager"
import ReviewManager from "./components/ReviewManager"

import ReservationManager from "./components/ReservationManager"

import MessageManager from "./components/MessageManager"


import Storageview from "./components/Storageview"
export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Payment',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/Storage',
                name: 'StorageManager',
                component: StorageManager
            },
            {
                path: '/Review',
                name: 'ReviewManager',
                component: ReviewManager
            },

            {
                path: '/Reservation',
                name: 'ReservationManager',
                component: ReservationManager
            },

            {
                path: '/Message',
                name: 'MessageManager',
                component: MessageManager
            },


            {
                path: '/Storageview',
                name: 'Storageview',
                component: Storageview
            },


    ]
})

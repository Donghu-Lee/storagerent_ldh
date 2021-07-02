<template>

<v-data-table
    :headers="headers"
    :items="storageview"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Storageview',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "storageId", value: "storageId" },
            { text: "storageStatus", value: "storageStatus" },
            { text: "description", value: "description" },
            { text: "price", value: "price" },
            { text: "reservationId", value: "reservationId" },
            { text: "reservationStatus", value: "reservationStatus" },
            { text: "paymentId", value: "paymentId" },
            { text: "paymentStatus", value: "paymentStatus" },
            { text: "reviewCnt", value: "reviewCnt" },
        ],
        storageview : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/storageviews')

      this.storageview = temp.data._embedded.storageviews;

    },
    methods: {
    }
  }
</script>


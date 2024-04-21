<template>
  <div v-if="page === 0">
      <MainPageComp @page="page = $event"/>
  </div>
  <div v-else-if="page === 1">
      <InputComp @inputValues="handleChange" @page="page = $event"/>
  </div>
  <div v-else-if="page === 2">
      <MultipleInputComp/>
  </div>
  <div v-else-if="page === 3">
      <LoadingComp/>
  </div>
  <div v-else-if="page === 4">
      <ResultComp :index="index" :adress="adress" :parameters="params"/>
  </div>
</template>

<script>
import MainPageComp from './components/MainPageComp.vue'
import MultipleInputComp from './components/MultipleInputComp.vue'
import InputComp from './components/InputComp.vue'
import ResultComp from './components/ResultComp.vue'
import LoadingComp from './components/LoadingComp.vue'
import axios from 'axios'
export default {
  name: 'App',
  data(){
    return{
      adress: '',
      radius: '',
      params: {},
      page: 0,
      error: false,
      index: 0,
    }
  },
  methods: {
    handleChange({adress, radius, params}){
      this.adress = adress
      this.radius = radius
      this.params = params
      this.page = 3
      axios
      .get('https://localhost:8080/api/ping')
      //.post('http://159.223.205.17:8080/api/index', {amount: 1, radius: radius, adress: adress, params: params})
      //.post('http://159.223.205.17:8080/api/index', {amount: 1, radius: radius, adress: adress, params: params})
      .then((response) => {
        console.log(response.data)
      })
      .catch((error) => {
        console.log(error)
      })
      .finally(() => {
        this.page = 4
      })
    }
  },
  components: {
    MainPageComp,
    MultipleInputComp,
    InputComp,
    LoadingComp,
    ResultComp
  }
}
</script>

<style>
body {
  background-color: #f7f8fa;
  margin-inline: 68px;
  margin-top: 55px;
}
div, button, input{
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif !important;
}
</style>

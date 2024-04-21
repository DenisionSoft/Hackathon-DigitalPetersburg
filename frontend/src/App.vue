<template>
  <div v-if="page === 0">
      <MainPageComp @page="page = $event"/>
  </div>
  <div v-else-if="page === 1">
      <InputComp @inputValues="handleChange" @page="page = $event"/>
  </div>
  <div v-else-if="page === 2">
      <MultipleInputComp @multipleInputValues="handleMultipleChange" @page="page = $event"/>
  </div>
  <div v-else-if="page === 3">
      <LoadingComp/>
  </div>
  <div v-else-if="page === 4">
      <ResultComp :index="index" :adress="adress" :parameters="params" @page="page = $event"/>
  </div>
  <div v-else-if="page === 5">
      <MultipleResultComp :multipleIndex="multipleIndex" :multipleAdress="multipleAdress" :parameters="params" @page="page = $event"/>
  </div>
</template>

<script>
import MainPageComp from './components/MainPageComp.vue'
import MultipleInputComp from './components/MultipleInputComp.vue'
import InputComp from './components/InputComp.vue'
import ResultComp from './components/ResultComp.vue'
import LoadingComp from './components/LoadingComp.vue'
import MultipleResultComp from './components/MultipleResultComp.vue'
import axios from 'axios'
export default {
  name: 'App',
  data(){
    return{
      adress: '',
      multipleAdress: [],
      radius: '',
      params: {},
      page: 0,
      error: false,
      index: 0,
      multipleIndex: [],
    }
  },
  methods: {
    handleChange({adress, radius, params}){
      this.adress = adress
      this.radius = radius
      this.params = params
      this.page = 3
      var json = JSON.stringify({"amount": 1, "radius": this.radius, "addresses": [this.adress], "parameters": [this.params]})
      axios
      .post('//localhost:8080/api/debug/index', json, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then((response) => {
        this.index = response.data[0].value
        this.adress = response.data[0].house.address
      })
      .catch((error) => {
        console.log(error)
      })
      .finally(() => {
        this.page = 4
      })
    },
    handleMultipleChange({adress1, adress2, adress3, radius, params}){
      if(adress1 != "") this.multipleAdress.push(adress1);
      if(adress2 != "") this.multipleAdress.push(adress2);
      if(adress3 != "") this.multipleAdress.push(adress3);
      this.radius = radius
      this.params = params
      var json = JSON.stringify({"amount": this.multipleAdress.length, "radius": this.radius, "addresses": this.multipleAdress, "parameters": [this.params]})
      axios
      .post('//localhost:8080/api/debug/index', json, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then((response) => {
        for(var i = 0; i < response.data.length; i++){
           this.multipleIndex[i] = response.data[i].value
           this.multipleAdress[i] = response.data[i].house.address 
        }
      })
      .catch((error) => {
        console.log(error)
      })
      .finally(() => {
        this.page = 5
      })
    },
},
  components: {
    MainPageComp,
    MultipleInputComp,
    InputComp,
    LoadingComp,
    ResultComp,
    MultipleResultComp
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

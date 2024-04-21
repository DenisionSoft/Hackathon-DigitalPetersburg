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
  <div id="footer">
    <div id="logo_footer">
      <img id="logo_img_footer" src="@/assets/bar_black.png">
      <div id="logo_text_footer">Хочу здесь жить</div>
    </div>
    <div id="contacts">
      <div id="footer_number">+7 982 9457782</div>
      <img id="logo_c" src="@/assets/telegram.png">
      <img id="logo_c" src="@/assets/vk.png">
      <div id="footer_year">2024</div>
    </div>
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
      var json = JSON.stringify({"addresses": ["Невский, 6"]})
      axios
      .post('//localhost:8080/api/debug/geocoder', json, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
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
  font-family: "Manrope", sans-serif !important;
}

#footer{
  border-radius: 32px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
  margin-top: 31px;
  height: 77px;
  border: 3px solid #C7D9F3;
}

#contacts{
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-right: 30px;
}

#logo_footer{
  display: flex;
  justify-content: left;
}

#logo_img_footer{
  align-items: center;
  text-align: center;
  width: 20px;
  margin-left: 26px;
  margin-bottom: 5px;
}
#logo_text_footer{
  align-items: center;
  text-align: center;
  font-size: 20px;
  margin-left: 10px;
  margin-right: 20px;
  margin-bottom: 2px;
  font-weight: bold;
  display: flex; 
  align-items: flex-end;
}
#footer_number, #footer_year{
  font-size: 20px;
  margin-left: 26px;
  font-weight: bold;
}
#logo_c{
  width: 40px;
  height: 40px;
  margin-right: 12px;
  margin-left: 30px;
}
</style>

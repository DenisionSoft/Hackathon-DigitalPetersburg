<template>
    <div id="header">
      <div id="head">
        <div id="logo" @click="$emit('page', 0)">
          <img id="logo_img" src="@/assets/bar_white.png">
          <div id="logo_text">Хочу здесь жить</div>
        </div>
        <div id="menu">
          <div id="multiple_btn" @click="$emit('page', 2)">Сравнить несколько адресов</div>
          <div id="main_page_text" @click="$emit('page', 0)">Главная</div>
        </div>
      </div>
      <div id="header_text">Введите адрес дома для оценки</div>
      <form id="inputForm" @submit.prevent="submitForm">
        <div id="inputs">
          <div> <img  id="icon" src="@/assets/search.png" alt=""> </div>
          <input id="adress_input" placeholder="Введите адрес..." name="adress_name" form="inputForm" v-model="adressValue">
          <input id="radius_input" type="number" min ="1" placeholder="Радиус оценки, км" name="radius_name" form="inputForm" v-model="radiusValue">
          <input id="adress_btn" type="submit" value="Оценить" form="inputForm" >
        </div>
        <div id="params">
        <div id="param">
          <div id="params_text">Важно учесть: </div>
        </div>
        <div id="param">
          <input id="education_input" type="checkbox" form="inputForm" v-model="paramsValues.educationValue">
          <div id="params_text">Образование</div>
        </div>
        <div id="param">
          <input id="health_input" type="checkbox" form="inputForm" v-model="paramsValues.healthValue">
          <div id="params_text">Здравоохранение</div>
        </div>
        <div id="param">
          <input id="museum_input" type="checkbox" form="inputForm" v-model="paramsValues.museumValue">
          <div id="params_text">Музеи</div>
        </div>
        <div id="param">
          <input id="restoran_input" type="checkbox" form="inputForm" v-model="paramsValues.restoranValue">
          <div id="params_text">Рестораны</div>
        </div>
      </div>
      </form>
      
    </div>
    
</template>

<script>
export default {
  name: 'InputComp',
  data(){
    return {
      adressValue: '', 
      radiusValue: '',
      paramsValues: {'educationValue' : false, 
                    'heatlthValue' : false, 
                    'museumValue' : false, 
                    'restoranValue' : false, },
    }
  },
  methods: {
    submitForm() {
      this.$emit('inputValues', {adress: this.adressValue, radius: this.radiusValue, params: this.paramsValues})
    }
  },
  emits: ['inputValues', 'page']
}
</script>

<style scoped>
#header{
  background-image: url("@/assets/background_2.jpg");
  width: auto;
  height: 718px;
  border-radius: 32px;
}
#head {
  display: flex;
  justify-content: space-between;
}
#menu{
  display: flex;
  justify-content: right;
  flex-direction: row;  
}
#logo{
  display: flex;
  justify-content: left;
}
#logo_img{
  width: 27px;
  height: 36px;
  margin-left: 35px;
  margin-top: 17px;
}
#logo_text{
  color: white;
  font-size: 24px;
  margin-left: 11px;
  margin-top: 29px;
  font-weight: bold;
}
#main_page_text{
  color: white;
  font-size: 22px;
  margin-right: 45px;
  margin-top: 29px;
  font-weight: bold;
}
#header_text{
    color: white;
    font-size: 64px;
    font-weight: bold;
    margin-top: 71px;
    text-align: center;
}
#adress_input{
    background-color: white;
    border-radius: 38px;
    width: 587px;
    height: 57px;
    font-size: 26px;
    padding-left: 28px;
    margin-left: 36px;
    border-color: #4E7BB4;
    border-width: 3px;
    border-style: solid;
}
#radius_input{
    background-color: white;
    border-radius: 38px;
    width: 244px;
    height: 57px;
    font-size: 26px;
    padding-left: 28px;
    margin-left: 36px;
    border-color: #4E7BB4;
    border-width: 3px;
    border-style: solid;
}
#adress_input:hover, #radius_input:hover{
  cursor: text;
}
#adress_input:focus{
  border-color: #f89882;
  outline: none;
}
#radius_input:focus{
  border-color: #ffdd86;
  outline: none;
}
#adress_btn:hover, #multiple_btn:hover, #main_page_text:hover{
  cursor: pointer;
}
#adress_btn{
    background-color: #4E7BB4;
    color: white;
    border-radius: 83px;
    border: none;
    width: 200px;
    height: 63px;
    font-size: 26px;
    margin-left: 38px;
    padding: 0;
}
#adress_btn:focus{
    outline: none;
}
#inputs{
    margin-top: 26px;
    display: flex;
    justify-content: center;
}
#params{
  width: 1000px;
  margin-inline:auto;
  margin-top: 26px;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}
#param{
  margin-bottom: 15px;
  width: max-content;
  display: flex;
  flex-direction: row;
  justify-content: center;
}
#icon{
    margin-top: 3px;
    width: 52px;
    height: 52px;
}
#multiple_btn{
    font-size: 22px;
    color: white;
    border: solid 2px white;
    margin-left: 153px;
    margin-top: 19px;
    width: fit-content;
    margin-right: 40px;
    font-weight: bold;
    width: 350px;
    height: 40px;
    text-align: center;
    border-radius: 32px;
    padding-top: 9px;
}
#params_text{
  font-size: 30px;
  margin-right: 27px;
  font-weight: bold;
  color:white;
}
input[type="checkbox"]{
  width: 28px;
  height: 28px;
  border-radius: 50%;
  margin-right: 10px;
}
input[type="checkbox"]:checked{
  background-color: #4E7BB4;
}

</style>

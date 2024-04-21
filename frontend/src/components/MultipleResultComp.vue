<template>
        <div id="heading">
            <div id="head">
                <div id="logo" @click="$emit('page', 0)">
                    <img id="logo_img" src="@/assets/bar_black.png">
                    <div id="logo_text">Хочу здесь жить</div>
                </div>
                <div id="main_page_text" @click="$emit('page', 0)">Главная</div>
            </div>
            <div id = "main_field">
                <div id="result_text">Сравнение оценок домов</div>
                <div id="results">
                    <div id="result_field" v-for:="(index, key) in multipleIndex" :key="key"> 
                        <div id="address">по адресу {{multipleAdress[key]}}</div> 
                        <div id="index" :style="{color: calcColor(index)}">{{index}}</div>
                    </div>
                </div>
            </div>
            <div id="parameters">
                <div v-for="(parameter, key) in parameters" :key="key">
                    <div  id="parameter" v-if="parameter">{{setParams(key)}}</div>
                </div>
            </div>
    </div>
      
</template>

<script>
export default {
    name: 'MultipleResultComp',
    data() {
        return {
            color: '',
            params_names: {
                'educationValue' : 'Образование', 
                'healthValue' : 'Здравоохранение', 
                'museumValue' : 'Музеи', 
                'restoranValue' : 'Рестораны', 
            },
        }
    },
    props: ['multipleIndex',
            'multipleAdress',
            'parameters'],
    methods: {
        calcColor: function(index) {
            var r, g, b
            var reverse_ind = 100 - index
            var colour_num = ((reverse_ind)*5440000/100)+11110000
            var h = 1 - (colour_num/16777215)
            var i= ~~(h*6)
            var f = h*6-i
            var q = 1 - f
            switch(i%6){
                case 0: r = 1; g = f; b = 0; break;
                case 1: r = q; g = 1; b = 0; break;
                case 2: r = 0; g = 1; b = f; break;
                case 3: r = 0; g = q; b = 1; break;
                case 4: r = f; g = 0; b = 1; break;
                case 5: r = 1; g = 0; b = q; break;
            }
            return "#" + ("00"+(~~(r*255)).toString(16)).slice(-2) + ("00"+(~~(g*255)).toString(16)).slice(-2) + ("00"+(~~(b*255)).toString(16)).slice(-2)
        },
        setParams(index){
            return this.params_names[index]
        }
    },
    emits: ['page'],
}
</script>

<style scoped>
#heading{
    height: 790px;
    background-color: #e8edf3;
    border-radius: 32px;
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
  font-size: 24px;
  margin-left: 11px;
  margin-top: 29px;
  font-weight: bold;
}
#head {
display: flex;
justify-content: space-between;
}
#main_page_text{
font-size: 24px;
margin-right: 45px;
margin-top: 29px;
font-weight: bold;
}
#main_field{
    display: flex;
    flex-direction: column;
    justify-content: center;
}
#results{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
#result_field{
    max-width: 330px;
    margin-top: 43px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
#result_text{
    margin-top: 45px;
    align-self: center;
    font-size: 40px;
    font-weight: bold;
}
#address{
    font-size: 26px;
    margin-top: 20px;
}
#index{
    font-size: 200px;
    margin-top: 20px;
}
#parameters{
    margin-left: 116px;
    margin-top: 64px;
    height:max-content;
    display: flex;
}
#parameter{
    flex: 1;
    margin-inline: 65px;
    font-size: 26px;
}
</style>